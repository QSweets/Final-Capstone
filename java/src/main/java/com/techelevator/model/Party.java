package com.techelevator.model;

public class Party {
    private int partyId;
    private int characterId;

    public Party(int partyId, int characterId){
        this.partyId = partyId;
        this.characterId = characterId;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }
}
