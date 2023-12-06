package com.techelevator.dao;

import com.techelevator.model.Monster;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class JdbcMonsterDao implements MonsterDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcMonsterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Monster> getAllMonsters() {
        List<Monster> monsters = new ArrayList<>();


    }


}
