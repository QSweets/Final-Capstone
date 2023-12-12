package com.techelevator.model;

public class Party {
    private int partyId;
    private int characterId;

    private String partyName;

    public Party(int partyId, int characterId, String partyName){
        this.partyId = partyId;
        this.characterId = characterId;
        this.partyName = partyName;
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

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

}
