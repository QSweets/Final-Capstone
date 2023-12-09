package com.techelevator.dao;

import com.techelevator.model.Character;

import java.util.List;

public interface CharacterDao {

    Character getCharacterById(int characterId);

    Character createCharacter(Character character);

    Character updateCharacter(Character character);

    void deleteCharacterById(int id);

    List<Character> getCharactersByUserId(int userId);

    boolean doesCharacterBelongToUser(int characterId, int userId);

    void deleteCharacter(int characterId);
}
