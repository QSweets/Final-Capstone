package com.techelevator.dao;

import com.techelevator.model.CharacterDto;

import java.util.List;

public interface CharacterDao {

    //We want a method that will get the characters for a specific user
    //allowing a user to click on their character list and see all their characters
    List<CharacterDto> getCharactersByUserId(int id);

    //Using Server Side APIs pt 2 as reference
    //Do we need this method at all since we are implementing this on the front end?
    CharacterDto createCharacter(CharacterDto characterDto);

    //Allow a user to update their character
    CharacterDto updateCharacter(CharacterDto characterDto);

    //Allow a user to delete their character
    int deleteCharacterById(int id);










}
