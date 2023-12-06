package com.techelevator;

import com.techelevator.model.Monster;
import com.techelevator.services.MonsterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    private final MonsterService monsterService = new MonsterService();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }





//    private void handleListAllMonsters(){
//            System.out.println(monsterService.getListOfMonsters());
//
//    }
}
