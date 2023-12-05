package com.techelevator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin
public class MonsterController {


    private final String MONSTER_API_BASE_URL = "https://www.dnd5eapi.co/api/monsters";
    private RestTemplate restTemplate;


    public ResponseEntity<String> getRandomMonster() {
        String dndApi = MONSTER_API_BASE_URL + "/random";
        String response = restTemplate.getForObject(dndApi, String.class);

        return ResponseEntity.ok(response);
    };


}
