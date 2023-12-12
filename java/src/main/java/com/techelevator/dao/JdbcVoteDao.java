package com.techelevator.dao;

import com.techelevator.model.Character;
import com.techelevator.model.Vote;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class JdbcVoteDao implements VoteDao {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = Logger.getLogger(JdbcVoteDao.class.getName());

    public JdbcVoteDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Vote submitVote(Vote vote, int userId) {
        Vote newVote = null;
        String sql = "INSERT INTO vote " +
                     "(vote_id, user_id, party_id, monster_id, vote_date)" +
                     "VALUES (?, ?, ?, ?, ?)";
        try{
            int newVoteId = jdbcTemplate.queryForObject(
                    sql,
                    int.class,
                    vote.getVoteId(),
                    vote.getPartyId(),
                    vote.getMonsterId(),
                    vote.getDate(),
                    userId);
            return getVoteByUserId(newVoteId);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error submitting vote", e);
        }
    }

    @Override
    public Vote getVoteResultsByMonsterId(int monsterId) {
        //This is a method that returns the party that appears the most frequently in the table given a monsterId
        String sql = "SELECT party_id, COUNT(*) AS vote_count FROM vote WHERE monster_id = ? GROUP BY party_id ORDER BY vote_count DESC LIMIT 1";
//
//        try{
//
//        }
        return null;
    }

    @Override
    public Vote getVoteByUserId(int userId) {
        return null;
    }
}
