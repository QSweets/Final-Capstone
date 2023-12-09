package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.CharacterDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcCharacterDao implements CharacterDao{
    //Using TEnmo as a reference


    private JdbcTemplate jdbcTemplate;
    public JdbcCharacterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
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
    }

    @Override
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
    }
}
