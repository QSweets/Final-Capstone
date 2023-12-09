package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Character;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCharacterDao implements CharacterDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCharacterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
<<<<<<< HEAD
    public List<CharacterDto> getCharactersByUserId(int userId) {
        List<CharacterDto> characters = new ArrayList<>();
        String sql = "SELECT character_id, character_name, creature, class_profession, background, abilities, created_date, " +
                "character_strength, character_dexterity, character_constitution, character_intelligence, " +
                "character_wisdom, character_charisma, vote_id, user_id, image_id " +
                "FROM character " +
                "WHERE user_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                CharacterDto character = mapRowToCharacterDto(results);
                characters.add(character);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return characters;
=======
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

            int characterId = jdbcTemplate.queryForObject(
                    sql,
                    Integer.class,
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

            character.setId(characterId);
            return character;
        } catch (DataAccessException e) {
            // Log the details of the exception
            throw new RuntimeException("Error creating character", e);
        }
>>>>>>> 90fc6a00c00082abf84942be417cddf7a393fa91
    }


    @Override
    public Character updateCharacter(Character character) {
        // Implement the SQL query to update an existing character in the database
        String sql = "UPDATE character SET name = ?, background = ?, creature = ?, " +
                "profession = ?, strength = ?, dexterity = ?, constitution = ?, " +
                "intelligence = ?, wisdom = ?, charisma = ?, abilities = ? " +
                "WHERE id = ?";

        jdbcTemplate.update(
                sql,
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
                character.getId()
        );

        return character;
    }

    @Override
    public int deleteCharacterById(int id) {
        // Implement the SQL query to delete a character by ID
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
    public boolean doesCharacterBelongToUser(int characterId, int userId) {
        return false;
    }

    @Override
    public void deleteCharacter(int characterId) {

    }

    private Character mapRowToCharacter(SqlRowSet rowSet) {
        // Implement the mapping from SQL row to Character object
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