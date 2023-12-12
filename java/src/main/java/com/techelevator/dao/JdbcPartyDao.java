package com.techelevator.dao;

import com.techelevator.model.Party;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public class JdbcPartyDao implements PartyDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPartyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Party createParty(Party party, int characterId) {
        return null;
    }

    @Override
    public Party getPartyByPartyId(int partyId) {
        return null;
    }

    @Override
    public List<Party> getAllParties() {
        return null;
    }
}
