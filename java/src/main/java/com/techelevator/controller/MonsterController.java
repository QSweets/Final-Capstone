package com.techelevator.controller;

import com.techelevator.dao.MonsterDao;
import com.techelevator.model.Monster;
import com.techelevator.services.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping
public class MonsterController {
    private final String MONSTER_API_BASE_URL = "https://www.dnd5eapi.co/api/monsters";

    private MonsterService monsterService;
//    private MonsterDao monsterDao;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
//        this.monsterDao = monsterDao;
    }

    @RequestMapping(path = "/monsters", method = RequestMethod.GET)
    public Monster randomMonster() {
        return monsterService.getRandomMonster();
    }



}
