package com.techelevator.dao;

import com.techelevator.model.Character;
import com.techelevator.model.CharacterDto;

import java.util.List;

public interface CharacterDao {

    int deleteCharacterById(int id);

    //We want a method that will get the characters for a specific user
    //allowing a user to click on their character list and see all their characters
    List<Character> getCharactersByUserId(int userId);

    Character getCharacterById(int userId);

    //Using Server Side APIs pt 2 as reference
    //Do we need this method at all since we are implementing this on the front end?
    Character createCharacter(Character character, int userId);

    //Allow a user to update their character
    Character updateCharacter(Character character);


    Character deleteCharacter(int userId, int characterId);
}