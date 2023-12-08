package com.techelevator.dao;

import java.util.List;

public interface CharacterDao {

    //We want a method that will get the characters for a specific user
    //allowing a user to click on their character list and see all their characters
    List<Character> getCharactersByUsername();

    //Allow a user to locate a specific character by id
    Character getCharacterById(int characterId);

    //Using Server Side APIs pt 2 as reference
    //Do we need this method at all since we are implementing this on the front end?
    Character createCharacter(Character character);

    //Allow a user to update their character
    Character updateCharacter(Character character);

    //Allow a user to delete their character
    int deleteCharacterById(int id);










}
