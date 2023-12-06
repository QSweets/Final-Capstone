package com.techelevator.services;

import com.techelevator.model.Monster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MonsterService {
    private final String MONSTER_API_BASE_URL = "https://www.dnd5eapi.co/api/monsters";
    private RestTemplate restTemplate;

    public Monster[] getAllMonsters() {
        // call api here
        return restTemplate.getForObject(MONSTER_API_BASE_URL, Monster[].class);
    }


//    @Autowired //used for automatic dependency injection
//    public MonsterService(RestTemplate restTemplate) { /** This is the dependency that Spring will inject **/
//        this.restTemplate = restTemplate;
//    }

    /*public ResponseEntity<String> getRandomMonster() {
        String dndApi = MONSTER_API_BASE_URL + ""; *//** to get information about a random monster **//*
        String response = restTemplate.getForObject(dndApi, String.class); *//** is making a GET request to the specified URL (dndApi) it is stored as a String **//*

        return ResponseEntity.ok(response); *//** Used to Construct and return a HTTP response with a status of 200 along with the response body **//*

    }*/

    public Monster getListOfMonsters(){
        try {
            return restTemplate.getForObject(MONSTER_API_BASE_URL, Monster.class);
        }  catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
