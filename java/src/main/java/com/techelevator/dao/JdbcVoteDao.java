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
    public Vote submitVote(Vote vote) {
        Vote newVote = null;
        String sql = "INSERT into vote (user_id, date, party_id, monster_id) VALUES (?, ?, ?, ?) RETURNING vote_id; ";
        try{
            int newVoteId = jdbcTemplate.queryForObject(sql, int.class, vote.getUserId(), vote.getDate(), vote.getPartyId(), vote.getMonsterId());
            return vote;
        } catch (DataAccessException e) {
            throw new RuntimeException("Error creating character", e);
        }
    }

    @Override
    public Vote getVoteResults() {
        //This is a method that searches for the character with the most votes in the vote table
        String sql = "SELECT party_id, COUNT(*) AS vote_count FROM vote GROUP BY party_id ORDER BY vote_count DESC LIMIT 1";
//
//        try{
//
//        }
        return null;
    }




}
