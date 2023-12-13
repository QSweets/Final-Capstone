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

    @Override
    public Party createParty(Party party) {
        try {
            String partyGroupSql = "INSERT INTO partygroup(party_name) VALUES (?);";
            jdbcTemplate.update(partyGroupSql, party.getPartyName());

            String selectPartyIdSql = "SELECT party_id FROM partygroup WHERE party_name = ?;";
            int newPartyId = jdbcTemplate.queryForObject(selectPartyIdSql, Integer.class, party.getPartyName());

            String partySql = "INSERT INTO party(party_id, character_id) VALUES (?, ?);";
            for (Integer characterId : party.getCharacterId()) {
                jdbcTemplate.update(partySql, newPartyId, characterId);
            }

            return getPartyByPartyId(newPartyId);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error creating party", e);
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

    @Override
    public Party deleteParty() {
        return null;
    }

    //in characterDao, add a method of getAllCharactersByPartyId()

    private Party mapRowToParty(SqlRowSet rowSet) {
        int partyId = rowSet.getInt("party_id");
        String partyName = rowSet.getString("party_name");
        return new Party(partyId, partyName, new ArrayList<Integer>());
    }

    }
