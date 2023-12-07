package com.techelevator.controller;

import com.techelevator.model.Monster;
import com.techelevator.services.MonsterService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/monsters")
@CrossOrigin
public class MonsterController {
    private MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Map<String, Object>> getAllMonsters() {
        monsterService.fetchMonsters();
        return monsterService.getAllMonsters();
    }
    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public Map<String, Object> randomMonster() {
        monsterService.fetchMonsters();
        return monsterService.getRandomMonsterFromList();
    }
}

