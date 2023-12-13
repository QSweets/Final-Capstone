package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Party;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class JdbcPartyDao implements PartyDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPartyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //split this into two methods
    //create party method and add characters to party method
    @Override
    public Party createParty(Party party, int characterId) {
        //Insert into party table, set that
        try {
            String partySql = "INSERT INTO party " +
                    "(character_id, party_name) " +
                    "VALUES (?, ?);";

            String partyGroupSql = "INSERT INTO partygroup " +
                    "(party_name) VALUES (?) RETURNING party_id";

            int newPartyId = jdbcTemplate.queryForObject(
                    partySql,
                    int.class,
                    party.getPartyName());

            return getPartyByPartyId(newPartyId);
        } catch (
                DataAccessException e) {
            throw new RuntimeException("Error creating character", e);
        }

    }

    @Override
        public Party getPartyByPartyId (int partyId) {

            String sql = "SELECT party_name FROM partygroup WHERE party_id=?;";

            return null;
        }

    @Override
    public List<Party> getAllParties() {
        try {
            List<Party> parties = new ArrayList<>();
            String sql = "SELECT party_id, party_name " +
                    "FROM partygroup;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Party party = mapRowToParty(results);
                parties.add(party);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return null;
    }

    //in characterDao, getAllCharactersByPartyId()

    private Party mapRowToParty(SqlRowSet rowSet) {
        Party party = new Party();
        party.setPartyId(rowSet.getInt("party_id"));
        party.setPartyName(rowSet.getString("party_name"));
        return party;
    }

    }
