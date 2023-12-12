package com.techelevator.dao;

import com.techelevator.model.Party;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPartyDao implements PartyDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPartyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Party getPartyByMonsterId(int monsterId) {
//        String sql = "SELECT party_id FROM "
        return null;
    }


}
