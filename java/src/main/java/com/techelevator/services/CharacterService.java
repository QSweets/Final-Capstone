package com.techelevator.services;

import com.techelevator.dao.CharacterDao;
import com.techelevator.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class CharacterService {

    private final CharacterDao characterDao;
    private final UserService userService;

    @Autowired
    public CharacterService(CharacterDao characterDao, UserService userService) {
        this.characterDao = characterDao;
        this.userService = userService;
    }

    public List<Character> getCharactersByUserId(int userId) {
        return characterDao.getCharactersByUserId(userId);
    }

    public void deleteCharacter(int characterId, Principal principal) {
        try {
            int userId = userService.getUserIdByUsername(principal.getName());
            if (characterDao.doesCharacterBelongToUser(characterId, userId)) {
                characterDao.deleteCharacter(characterId);
            } else {
                throw new Exception("Character does not belong to the authenticated user");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


