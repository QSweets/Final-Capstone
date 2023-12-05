package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

public class Monster extends Creature {
    private int challenegeRating;
    private String size;
    private List<String> specialAbilities;

    public Monster() {

    }
    public int getChallenegeRating(){
        return challenegeRating;
    }
    public String getSize() {
        return size;
    }
    public List<String> getSpecialAbilities() {
        return specialAbilities;
    }
}
