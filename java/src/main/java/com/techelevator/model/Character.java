package com.techelevator.model;

import java.util.List;

public class Character extends Creature{
    private byte[] portrait;
    private String background;
    private List<String> abilities;

    public Character(){
    }
    public byte[] getPortrait(){
        return portrait;
    }
    public String getBackground(){
        return background;
    }
    public List<String> getAbilities() {
        return abilities;
    }
}
