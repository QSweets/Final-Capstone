package com.techelevator.dao;

import com.techelevator.model.Character;
import com.techelevator.model.CharacterDto;

import java.util.List;

public interface CharacterDao {

    //We want a method that will get the characters for a specific user
    //allowing a user to click on their character list and see all their characters
<<<<<<< HEAD
    List<CharacterDto> getCharactersByUserId(int userId);
=======
    List<Character> getCharactersByUserId(int userId);

    Character getCharacterById(int userId);
>>>>>>> 90fc6a00c00082abf84942be417cddf7a393fa91

    //Using Server Side APIs pt 2 as reference
    //Do we need this method at all since we are implementing this on the front end?
    Character createCharacter(Character character);

    //Allow a user to update their character
    Character updateCharacter(Character character);


    //Allow a user to delete their character
    int deleteCharacterById(int id);

<<<<<<< HEAD
}
=======
    boolean doesCharacterBelongToUser(int characterId, int userId);

    void deleteCharacter(int characterId);
}
>>>>>>> 90fc6a00c00082abf84942be417cddf7a393fa91
