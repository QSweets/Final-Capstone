package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcCharacterDao /*implements CharacterDao*/ {
    private JdbcTemplate jdbcTemplate;

    public JdbcCharacterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

//    @Override
//    public List<Character> getCharactersByUsername(String username) {
//        //Change this select *
//        List<Character> characters = new ArrayList<>();
//        String sql = "SELECT * FROM character WHERE username = ? ";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
//        try {
//            while (results.next()) {
//                Character character = mapRowToCharacter(results);
//                characters.add(character);
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//
//        return characters;
//    }
//
//    @Override
//    public Character createCharacter(Character character) {
//        return null;
//    }
//
//    @Override
//    public Character updateCharacter(Character character) {
//        return null;
//    }
//
//    @Override
//    public int deleteCharacterById(int id) {
//        return 0;
//    }
//
//
//    private Character mapRowToCharacter(SqlRowSet rs) {
//
//}
