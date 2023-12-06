package com.techelevator.services;

import com.techelevator.model.Monster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    public Map<Integer, Monster> getListOfMonsters(){
    Map<Integer, Monster> monsterMap = null;
    try {
            int count = 0;
            restTemplate.getForObject(MONSTER_API_BASE_URL, Monster.class);
            //for each monster in the list of monsters
            //add each monster to a map
            //where the key is count++
            //value is Monster

            return monsterMap;
        }  catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


//    public Monster getRandomMonster() {
//        //we have an index for each monster,
//        //we want want to generate a random number
//        //and pull the monster with that index
////        return getListOfMonsters();
//    }

}
