package com.techelevator.controller;

import com.techelevator.dao.CharacterDao;
import com.techelevator.model.Character;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/characters")
@PreAuthorize("isAuthenticated()")
public class CharacterController {
    private CharacterDao characterDao;

    public CharacterController(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Character> getCharactersByUsername() {
        characterDao.getCharactersByUsername();
        List<Character> characters = characterDao.getCharactersByUsername();

    }




}
