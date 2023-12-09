package com.techelevator.dao;

<<<<<<< HEAD
import com.techelevator.model.Character;
=======
import com.techelevator.model.CharacterDto;
>>>>>>> b222d202c6c84733e3c94c3ab1dd6f0485273af7

import java.util.List;

public interface CharacterDao {

<<<<<<< HEAD
    Character getCharacterById(int characterId);

    Character createCharacter(Character character);

    Character updateCharacter(Character character);
=======
    //We want a method that will get the characters for a specific user
    //allowing a user to click on their character list and see all their characters
    List<CharacterDto> getCharactersByUserId(int id);

    //Using Server Side APIs pt 2 as reference
    //Do we need this method at all since we are implementing this on the front end?
    CharacterDto createCharacter(CharacterDto characterDto);

    //Allow a user to update their character
    CharacterDto updateCharacter(CharacterDto characterDto);
>>>>>>> b222d202c6c84733e3c94c3ab1dd6f0485273af7

    void deleteCharacterById(int id);

    List<Character> getCharactersByUserId(int userId);

    boolean doesCharacterBelongToUser(int characterId, int userId);

    void deleteCharacter(int characterId);
}
