package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Character;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Component
public class JdbcCharacterDao implements CharacterDao {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = Logger.getLogger(JdbcCharacterDao.class.getName());

    public JdbcCharacterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Character getCharacterById(int userId) {
        String sql = "SELECT * FROM character WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);

        if (result.next()) {
            return mapRowToCharacter(result);
        }

        return null;
    }
    @Override
    public Character createCharacter(Character character) {
        try {
            String sql = "INSERT INTO character (character_name, background, creature, class_profession, " +
                    "character_strength, character_dexterity, character_constitution, character_intelligence, " +
                    "character_wisdom, character_charisma, abilities, user_id, created_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE) RETURNING character_id";

            int newCharacterId = jdbcTemplate.queryForObject(
                    sql,
                    int.class,
                    character.getName(),
                    character.getBackground(),
                    character.getCreature(),
                    character.getProfession(),
                    character.getStrength(),
                    character.getDexterity(),
                    character.getConstitution(),
                    character.getIntelligence(),
                    character.getWisdom(),
                    character.getCharisma(),
                    character.getAbilities(),
                    character.getUser_id()
            );
            character.setId(newCharacterId);
            return character;
        } catch (DataAccessException e) {
            logger.severe("Error creating character");
            logger.severe(e.getMessage());
            logger.severe(Arrays.toString(e.getStackTrace()));
            throw new RuntimeException("Error creating character", e);
        }
    }
    @Override
    public Character updateCharacter(Character character) {
        try {
            String sql = "UPDATE character SET character_name = ?, creature=?, class_profession=?, background=?, abilities=?, character_strength=?, \n" +
                    "character_dexterity=?, character_constitution=?, character_intelligence=?, character_wisdom=?, character_charisma=? WHERE character_id=?;\n";

            int rowsUpdated = jdbcTemplate.update(
                    sql,
                    character.getName(),
                    character.getCreature(),
                    character.getBackground(),
                    character.getProfession(),
                    character.getAbilities(),
                    character.getStrength(),
                    character.getDexterity(),
                    character.getConstitution(),
                    character.getIntelligence(),
                    character.getWisdom(),
                    character.getCharisma(),
                    character.getId()
            );
            if (rowsUpdated > 0) {
                return character;
            } else {
                throw new RuntimeException("Character not found or not updated");
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating character", e);
        }
    }
    @Override
    public int deleteCharacterById(int id) {
        String sql = "DELETE FROM character WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return id;
    }
    @Override
    public List<Character> getCharactersByUserId(int userId) {
        List<Character> characters = new ArrayList<>();
        String sql = "SELECT character_id, character_name, creature, class_profession, background, abilities, created_date, " +
                "character_strength, character_dexterity, character_constitution, character_intelligence, " +
                "character_wisdom, character_charisma, vote_id, user_id, image_id " +
                "FROM character " +
                "WHERE user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                Character character = mapRowToCharacter(results);
                characters.add(character);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return characters;
    }
    @Override
    public Character deleteCharacter(int userId, int characterId) {
        try {
            String sql = "DELETE FROM character WHERE user_id = ? AND character_id = ?";

            int rowsDeleted = jdbcTemplate.update(sql, userId, characterId);

            if (rowsDeleted == 0) {
                throw new RuntimeException("Character not found for deletion");
            }
        } catch (DataAccessException e) {
            throw new DaoException("Error deleting character", e);
        }
        return null;
    }
    private Character mapRowToCharacter(SqlRowSet rowSet) {
        Character character = new Character();
        character.setId(rowSet.getInt("character_id"));
        character.setName(rowSet.getString("character_name"));
        character.setBackground(rowSet.getString("background"));
        character.setCreature(rowSet.getString("creature"));
        character.setProfession(rowSet.getString("class_profession"));
        character.setStrength(rowSet.getInt("character_strength"));
        character.setDexterity(rowSet.getInt("character_dexterity"));
        character.setConstitution(rowSet.getInt("character_constitution"));
        character.setIntelligence(rowSet.getInt("character_intelligence"));
        character.setWisdom(rowSet.getInt("character_wisdom"));
        character.setCharisma(rowSet.getInt("character_charisma"));
        character.setAbilities(rowSet.getString("abilities"));
        return character;
    }
}