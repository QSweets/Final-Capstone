package com.techelevator.controller;

import com.techelevator.dao.CharacterDao;
<<<<<<< HEAD
import com.techelevator.exception.DaoException;
import com.techelevator.model.Character;
import com.techelevator.services.CharacterService;
import com.techelevator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Map;
=======
import com.techelevator.model.Character;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> b222d202c6c84733e3c94c3ab1dd6f0485273af7

import java.util.List;

@RestController
<<<<<<< HEAD
@CrossOrigin
@RequestMapping("/characters")
=======
@RequestMapping("/users/characters")
@PreAuthorize("isAuthenticated()")
>>>>>>> b222d202c6c84733e3c94c3ab1dd6f0485273af7
public class CharacterController {
    private CharacterDao characterDao;

    public CharacterController(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Character> getCharactersByUsername() {
        characterDao.getCharactersByUsername();
        List<Character> characters = characterDao.getCharactersByUsername();

<<<<<<< HEAD
    private final CharacterDao characterDao;
    private final UserService userService;

    public CharacterController(CharacterDao characterDao, UserService userService) {
        this.characterDao = characterDao;
        this.userService = userService;
=======
>>>>>>> b222d202c6c84733e3c94c3ab1dd6f0485273af7
    }

    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public List<Character> getCharactersByUserId(@PathVariable int user_id) {
        try {
            return characterDao.getCharactersByUserId(user_id);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/{user_id}", method = RequestMethod.POST)
    public ResponseEntity<Character> createCharacter(@RequestBody Character character, Principal principal) {
        try {
            int userId = userService.getUserIdByUsername(principal.getName());
            character.setUser_id(userId);

            Character createdCharacter = characterDao.createCharacter(character);

            return new ResponseEntity<>(createdCharacter, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "/user_id/{characterId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCharacter(@PathVariable int characterId, Principal principal) {
        try {
            int userId = userService.getUserIdByUsername(principal.getName());

            if (characterDao.doesCharacterBelongToUser(characterId, userId)) {
                characterDao.deleteCharacter(characterId);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}