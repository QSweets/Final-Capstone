package com.techelevator.controller;

import com.techelevator.dao.CharacterDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Character;
import com.techelevator.model.CharacterDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users/characters")
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class CharacterController {
    private CharacterDao characterDao;
    private UserDao userDao;
    private CharacterDto characterDto;

    public CharacterController(CharacterDao characterDao, CharacterDto characterDto, UserDao userDao) {
        this.characterDao = characterDao;
        this.userDao = userDao;
        this.characterDto = characterDto;
    }


    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public List<CharacterDto> getCharactersByUserId(@Valid @PathVariable int user_id) {
        try {
            return characterDao.getCharactersByUserId(user_id);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
