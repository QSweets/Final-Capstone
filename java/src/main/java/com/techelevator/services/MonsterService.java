package com.techelevator.services;

import com.techelevator.model.Monster;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class MonsterService {
    private final String MONSTER_API_BASE_URL = "https://www.dnd5eapi.co/api/monsters";

    private RestTemplate restTemplate = new RestTemplate();
    private List<Map<String, Object>> allMonsters = new ArrayList<>();

    public void fetchMonsters() {
        try {
            Map<String, Object> monstersMap = restTemplate.getForObject(MONSTER_API_BASE_URL, Map.class);

            if (monstersMap != null) {
                List<Map<String, Object>> monstersList = (List<Map<String, Object>>) monstersMap.get("results");

                if (monstersList != null) {
                    allMonsters.addAll(monstersList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error fetching monsters: " + e.getMessage());
        }
    }

    public List<Map<String, Object>> getAllMonsters() {
        return new ArrayList<>(allMonsters);
    }

    public Map<String, Object> getRandomMonsterFromList() {
        if (allMonsters.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return allMonsters.get(random.nextInt(allMonsters.size()));
    }

    public Map<String, Object> fetchMonsterDetails(String index) {
        String monsterDetailsUrl = MONSTER_API_BASE_URL + "/" + index;
        try {
            return restTemplate.getForObject(monsterDetailsUrl, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error fetching monster details: " + e.getMessage());
            return null;
        }
    }
}
