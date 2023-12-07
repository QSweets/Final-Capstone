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
    public Monster[] getAllMonsters() {
        return monsterService.fetchMonsters();

    }
    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public Monster randomMonster() {
        monsterService.fetchMonsters();
        Map<String, Object> randomMonster = monsterService.getRandomMonsterFromList();

        if (randomMonster != null) {
            String index = (String) randomMonster.get("index");
            Map<String, Object> monsterDetails = monsterService.fetchMonsterDetails(index);

            if (monsterDetails != null) {
                randomMonster.put("details", monsterDetails);
            }
        }
        return randomMonster;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path="/details", method = RequestMethod.GET)
    public Monster monsterDetails() {
        monsterService.fetchMonsters();
        monsterService.getRandomMonsterFromList();
        return monsterService.getMonsterDetails();
    }
}


