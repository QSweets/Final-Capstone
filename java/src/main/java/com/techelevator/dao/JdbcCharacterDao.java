package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcCharacterDao implements CharacterDao{
    //Using TEnmo as a reference

    private JdbcTemplate jdbcTemplate;
    public JdbcCharacterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Character> getCharactersByUsername() {
//        String sql = "SELECT * FROM character";
//
//        List<Character> characters = jdbcTemplate.query(sql, (resultSet, rowNum) -> {
//            Character character = new Character();
//            character.
//        })

        return null;
    }

    @Override
    public Character getCharacterById(int characterId) {
        return null;
    }

    @Override
    public Character createCharacter(Character character) {
        return null;
    }

    @Override
    public Character updateCharacter(Character character) {
        return null;
    }

    @Override
    public int deleteCharacterById(int id) {
        return 0;
    }
}
