package com.techelevator.controller;

import com.techelevator.dao.CharacterDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Character;
import com.techelevator.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/characters")
@PreAuthorize("isAuthenticated()")
public class CharacterController {

    private final CharacterDao characterDao;
    private UserDao userDao;

    public CharacterController(CharacterDao characterDao, UserDao userDao) {
        this.characterDao = characterDao;
        this.userDao = userDao;

    }
    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public List<Character> getCharactersByUserId(@PathVariable int user_id) {
        try {
            return characterDao.getCharactersByUserId(user_id);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Character createCharacter(@Valid @RequestBody Character character, Principal principal) {
        try {
            return characterDao.createCharacter(character, getCurrentUserId(principal));
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{userId}/{characterId}")
    @ResponseStatus(HttpStatus.OK)
    public Character updateCharacter(@PathVariable int userId, @PathVariable int characterId, @Valid @RequestBody Character updatedCharacter
    ) {
        updatedCharacter.setId(characterId);

        try {
            return characterDao.updateCharacter(updatedCharacter);
        } catch (DaoException e) {

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating character", e);
        }
    }
    @DeleteMapping("/{userId}/{characterId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCharacter(@PathVariable int userId, @PathVariable int characterId) {
        try {
            characterDao.deleteCharacter(userId, characterId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting character", e);
        }
    }

    private int getCurrentUserId(Principal principal){
        return userDao.getUserByUsername(principal.getName()).getId();
    }
}