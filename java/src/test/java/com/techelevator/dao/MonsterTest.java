package com.techelevator.dao;
import com.techelevator.controller.MonsterController;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class MonsterControllerTest {

    @Test
    void testExtractRandomMonster() {

        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);


        String apiResponse = "{\"name\":\"Monster1\"},{\"name\":\"Monster2\"},{\"name\":\"Monster3\"}";
        ResponseEntity<String> responseEntity = new ResponseEntity<>(apiResponse, HttpStatus.OK);


        when(restTemplate.getForObject(any(), any())).thenReturn(responseEntity);


        MonsterController monsterController = new MonsterController(restTemplate);


        String randomMonsterDetails = monsterController.extractRandomMonster(apiResponse);


        assertNotNull(randomMonsterDetails);
        System.out.println("Random Monster Details: " + randomMonsterDetails);
    }
}
