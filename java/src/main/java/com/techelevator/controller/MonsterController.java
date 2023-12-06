package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin
public class MonsterController {

    private final String MONSTER_API_BASE_URL = "https://www.dnd5eapi.co/api/monsters";
    private final RestTemplate restTemplate;

    @Autowired //used for automatic dependency injection
    public MonsterController(RestTemplate restTemplate) { /** This is the dependency that Spring will inject **/
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getRandomMonster() {
        String dndApi = MONSTER_API_BASE_URL + ""; /** to get information about a random monster **/
        String response = restTemplate.getForObject(dndApi, String.class); /** is making a GET request to the specified URL (dndApi) it is stored as a String **/

        return ResponseEntity.ok(response); /** Used to Construct and return a HTTP response with a status of 200 along with the response body **/
    }


}
