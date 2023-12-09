package com.techelevator.controller;

import com.techelevator.dao.CharacterDao;
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

@RestController
@CrossOrigin
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterDao characterDao;
    private final UserService userService;

    public CharacterController(CharacterDao characterDao, UserService userService) {
        this.characterDao = characterDao;
        this.userService = userService;
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