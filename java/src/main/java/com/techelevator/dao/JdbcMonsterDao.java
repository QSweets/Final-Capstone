package com.techelevator.dao;

import com.techelevator.model.Monster;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

public class JdbcMonsterDao implements MonsterDao{
    public static String MONSTER_API_BASE_URL = "https://www.dnd5eapi.co/api/monsters";
    private RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<Monster> getMonsters() {
        try {
            return Collections.singletonList(restTemplate.getForObject(MONSTER_API_BASE_URL, Monster.class));
        }  catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
