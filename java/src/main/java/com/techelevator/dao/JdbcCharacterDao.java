package com.techelevator.dao;

import com.techelevator.exception.DaoException;
<<<<<<< HEAD
import com.techelevator.model.Character;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
=======
import com.techelevator.model.CharacterDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
>>>>>>> b222d202c6c84733e3c94c3ab1dd6f0485273af7

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCharacterDao implements CharacterDao {

    private final JdbcTemplate jdbcTemplate;

<<<<<<< HEAD
=======

    private JdbcTemplate jdbcTemplate;
>>>>>>> b222d202c6c84733e3c94c3ab1dd6f0485273af7
    public JdbcCharacterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
<<<<<<< HEAD
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
=======
    public List<CharacterDto> getCharactersByUserId(int id) {
        //We did not add the image section to the character table
//        String sql = "SELECT character_name, creature, class_profession, background, abilities, character_strength, " +
//                        "character_dexterity, character_constitution, character_intelligence, character_wisdom, " +
//                        "character_charisma FROM character WHERE user_id = ?";
        List<CharacterDto> characterDtos = new ArrayList<>();
        String sql = "SELECT character_name, creature, class_profession, background, abilities, character_strength, " +
                "character_dexterity, character_constitution, character_intelligence, character_wisdom, " +
                "character_charisma FROM character " +
                "JOIN users ON character.user_id = users.user_id " +
                "WHERE user_id = ?";

//            List<CharacterDto> characterDtos = jdbcTemplate.query(sql, (resultSet, rowNum) -> {
//            CharacterDto characterDto = new CharacterDto();
//            characterDto.setName(resultSet.getString("character_name"));
//            characterDto.setCreature(resultSet.getString("creature"));
//            characterDto.setProfession(resultSet.getString("class_profession"));
//            characterDto.setBackground(resultSet.getString("background"));
//            characterDto.setAbilities(resultSet.getString("abilities"));
//            characterDto.setStrength(resultSet.getInt("character_strength"));
//            characterDto.setDexterity(resultSet.getInt("character_dexterity"));
//            characterDto.setConstitution(resultSet.getInt("character_constitution"));
//            characterDto.setIntelligence(resultSet.getInt("character_intelligence"));
//            characterDto.setWisdom(resultSet.getInt("character_wisdom"));
//            characterDto.setCharisma(resultSet.getInt("character_charisma"));
//            return characterDto;
//        });
       // return characterDtos;
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            while (results.next()) {
                characterDtos.add(mapRowToCharacterDto(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return characterDtos;
    }

    @Override
    public CharacterDto createCharacter(CharacterDto characterDto) {
        CharacterDto newCharacter = null;
        String sql = "INSERT INTO character (character_name, creature, class_profession, background, abilities, character_strength, " +
                        "character_dexterity, character_constitution, character_intelligence, character_wisdom, character_charisma) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING character_id;";
            int newCharacterId = jdbcTemplate.queryForObject(sql, int.class, String.class,
                    characterDto.getName(), characterDto.getCreature(), characterDto.getProfession(), characterDto.getBackground(),
                    characterDto.getAbilities(), characterDto.getStrength(), characterDto.getDexterity(), characterDto.getConstitution(),
                    characterDto.getIntelligence(), characterDto.getWisdom(), characterDto.getCharisma());
            newCharacter = getCharacterById(newCharacterId);
        return newCharacter;
    }

    public CharacterDto getCharacterById(int characterId) {
        CharacterDto characterDto = null;
        String sql = "SELECT character_id, character_name, creature, class_profession, background, abilities, character_strength, " +
                        "character_dexterity, character_constitution, character_intelligence, character_wisdom, character_charisma WHERE character_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, characterId);
            if (results.next()) {
                characterDto = mapRowToCharacterDto(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return characterDto;
>>>>>>> b222d202c6c84733e3c94c3ab1dd6f0485273af7
    }


    @Override
<<<<<<< HEAD
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
    public void deleteCharacterById(int id) {
        // Implement the SQL query to delete a character by ID
        String sql = "DELETE FROM character WHERE id = ?";
        jdbcTemplate.update(sql, id);
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
=======
    public CharacterDto updateCharacter(CharacterDto characterDto) {
        CharacterDto updatedCharcterDto = null;
        String sql = "UPDATE character SET character_name = ?, creature = ?, class_profession = ?, background = ?, abilities = ?, " +
                        "character_strength = ?, character_dexterity = ?, character_constitution = ?, character_intelligence = ?, " +
                        "character_wisdom = ?, character_charisma = ? " +
                        "WHERE character_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, characterDto.getName(), characterDto.getCreature(), characterDto.getProfession(),
                    characterDto.getBackground(), characterDto.getAbilities(), characterDto.getStrength(), characterDto.getDexterity(),
                    characterDto.getConstitution(), characterDto.getIntelligence(), characterDto.getWisdom(), characterDto.getCharisma(), characterDto.getCharacterId());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedCharcterDto = getCharacterById(characterDto.getCharacterId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedCharcterDto;
    }

    @Override
    public int deleteCharacterById(int characterId) {
        int numberOfRows = 0;
        String sql = "DELETE FROM character WHERE character_id = ?;";
        try {
            numberOfRows = jdbcTemplate.update(sql, characterId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return numberOfRows;
    }

    private CharacterDto mapRowToCharacterDto(SqlRowSet rs) {
        CharacterDto characterDto = new CharacterDto();
        characterDto.setCharacterId(rs.getInt("character_id"));
        characterDto.setName(rs.getString("character_name"));
        characterDto.setBackground(rs.getString("background"));
        characterDto.setAbilities(rs.getString("abilities"));
        characterDto.setCreature(rs.getString("creature"));
        characterDto.setProfession(rs.getString("class_profession"));
        characterDto.setStrength(rs.getInt("character_strength"));
        characterDto.setDexterity(rs.getInt("character_dexterity"));
        characterDto.setConstitution(rs.getInt("character_constitution"));
        characterDto.setIntelligence(rs.getInt("character_intelligence"));
        characterDto.setWisdom(rs.getInt("character_wisdom"));
        characterDto.setCharisma(rs.getInt("character_charisma"));
        return characterDto;
>>>>>>> b222d202c6c84733e3c94c3ab1dd6f0485273af7
    }
}