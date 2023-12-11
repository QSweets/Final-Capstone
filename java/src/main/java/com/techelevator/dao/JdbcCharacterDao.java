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
            byte[] imageData = character.getImage();

            String imageSql = "INSERT INTO public.images (user_id, mediatype, data) VALUES (?, ?, ?) RETURNING image_id";

            int imageId = jdbcTemplate.queryForObject(
                    imageSql, int.class, character.getUser_id(), "image/jpg", imageData
            );

            String characterSql = "INSERT INTO character (name, background, creature, class_profession, " +
                    "character_strength, character_dexterity, character_constitution, character_intelligence, " +
                    "character_wisdom, character_charisma, abilities, user_id, image_id, created_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE) RETURNING character_id";

            int newCharacterId = jdbcTemplate.queryForObject(
                    characterSql,
                    int.class,
                    character.getCharacter_name(),
                    character.getBackground(),
                    character.getCreature(),
                    character.getClass_profession(),
                    character.getCharacter_strength(),
                    character.getCharacter_dexterity(),
                    character.getCharacter_constitution(),
                    character.getCharacter_intelligence(),
                    character.getCharacter_wisdom(),
                    character.getCharacter_charisma(),
                    character.getAbilities(),
                    character.getUser_id(),
                    imageId
            );
            return character;
        } catch (DataAccessException e) {
            throw new RuntimeException("Error creating character", e);
        }
    }


    @Override
    public Character updateCharacter(Character character) {
        try {
            String sql = "UPDATE character SET name = ?, creature=?, class_profession=?, background=?, abilities=?, character_strength=?, \n" +
                    "character_dexterity=?, character_constitution=?, character_intelligence=?, character_wisdom=?, character_charisma=? WHERE character_id=?;\n";

            int rowsUpdated = jdbcTemplate.update(
                    sql,
                    character.getCharacter_name(),
                    character.getCreature(),
                    character.getBackground(),
                    character.getClass_profession(),
                    character.getAbilities(),
                    character.getCharacter_strength(),
                    character.getCharacter_dexterity(),
                    character.getCharacter_constitution(),
                    character.getCharacter_intelligence(),
                    character.getCharacter_wisdom(),
                    character.getCharacter_charisma(),
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
        String sql = "SELECT c.character_id, c.name, c.creature, c.class_profession, c.background, c.abilities, c.created_date, " +
                     "c.character_strength, c.character_dexterity, c.character_constitution, c.character_intelligence, " +
                     "c.character_wisdom, c.character_charisma, c.vote_id, c.user_id, c.image_id, i.data as image_data " +
                     "FROM character c " +
                     "JOIN images i ON c.image_id = i.image_id " +
                     "WHERE c.user_id = ?; ";
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
        character.setName(rowSet.getString("name"));
        character.setBackground(rowSet.getString("background"));
        character.setCreature(rowSet.getString("creature"));
        character.setClass_profession(rowSet.getString("class_profession"));
        character.setCharacter_strength(rowSet.getInt("character_strength"));
        character.setCharacter_dexterity(rowSet.getInt("character_dexterity"));
        character.setCharacter_constitution(rowSet.getInt("character_constitution"));
        character.setCharacter_intelligence(rowSet.getInt("character_intelligence"));
        character.setCharacter_wisdom(rowSet.getInt("character_wisdom"));
        character.setCharacter_charisma(rowSet.getInt("character_charisma"));
        character.setAbilities(rowSet.getString("abilities"));
        byte[] imageData = new byte[]{rowSet.getByte("image_data")};
        character.setImage(imageData);
        return character;
    }
}