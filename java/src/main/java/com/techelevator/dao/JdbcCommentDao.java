package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Character;
import com.techelevator.model.Comment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JdbcCommentDao implements CommentDao{
    private List<Comment> comments = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;
    public JdbcCommentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Comment> getAllComments(){
        return Collections.unmodifiableList(comments);
    }

    @Override
    public Comment createComment(Comment comment) {
        try {
            String commentSql = "INSERT INTO comment (comment_title, comment_box, CURRENT_DATE)" + "VALUES (?, ?, CURRENT_DATE) RETURNING comment_id";

            int newCommentId = jdbcTemplate.queryForObject(
                    commentSql,
                    int.class,
                    comment.getUserId(),
                    comment.getCommentBox(),
                    comment.getCommentTitle()
            );
            return comment;
        } catch (DataAccessException e) {
            throw new RuntimeException("Error creating comment", e);
        }
    }

    @Override
    public Comment updateComment(Comment comment) {
        try {
            String sql = "UPDATE comment SET comment_title = ?, comment_box = ? WHERE comment_id = ?;";

            int rowsUpdated = jdbcTemplate.update(
                    sql,
                    comment.getCommentTitle(),
                    comment.getCommentBox(),
                    comment.getCommentId()
            );
            if (rowsUpdated > 0) {
                return comment;
            } else {
                throw new RuntimeException("Comment not found or not updated");
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating comment", e);
        }
    }

    @Override
    public Comment deleteComment(int userId, int commentId) {
        try {
            String sql = "DELETE FROM comment WHERE user_id = ? AND comment_id = ?";

            int rowsDeleted = jdbcTemplate.update(sql, userId, commentId);

            if (rowsDeleted == 0) {
                throw new RuntimeException("Comment not found for deletion");
            }
        } catch (DataAccessException e) {
            throw new DaoException("Error deleting comment", e);
        }
        return null;
    }

    public List<Comment> getCommentsByUserId(int userId) {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT comment_id, comment_title, comment_box, timestamp " +
                "FROM comment " +
                "WHERE user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                Comment comment = mapRowToComment(results);
                comments.add(comment);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return comments;
    }

    private Comment mapRowToComment(SqlRowSet rowSet) {
        Comment comment = new Comment();
        comment.setCommentId(rowSet.getInt("comment_id"));
        comment.setCommentTitle(rowSet.getString("comment_title"));
        comment.setCommentBox(rowSet.getString("comment_box"));
        comment.setTimestamp(rowSet.getDate("timestamp"));
        return comment;
    }

}
