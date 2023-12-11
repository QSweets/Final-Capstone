package com.techelevator.controller;


import com.techelevator.dao.CommentDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/social")
public class CommentController {

    private final CommentDao commentDao;
    public CommentController(CommentDao commentDao) {
        this.commentDao = commentDao;

    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Comment> getComments() {
        try {
            return commentDao.getAllComments();
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/addComment", method = RequestMethod.POST)
    public Comment createComment(@Valid @RequestBody Comment comment, Principal principal) {
        try {
            return commentDao.createComment(comment);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{user_id}/{comment_id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment updateComment(@PathVariable int userId, @PathVariable int commentId, @Valid @RequestBody Comment updatedComment) {
        updatedComment.setCommentId(commentId);

        try {
            return commentDao.updateComment(updatedComment);
        } catch (DaoException e) {

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating comment", e);
        }
    }
    @DeleteMapping("/{user_id}/{comment_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCharacter(@PathVariable int userId, @PathVariable int commentId) {
        try {
            commentDao.deleteComment(userId, commentId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting comment", e);
        }
    }
}
