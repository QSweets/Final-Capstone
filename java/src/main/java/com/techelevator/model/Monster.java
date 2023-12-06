package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Creature {
    private int challengeRating;
    private String size;
    private List<String> specialAbilities;
    private int index;


    //POJO constructors
    public Monster(int index, String name, String size, int challengeRating, List<String> specialAbilities) {
        this.index = index;
        this.name = name;
        this.size = size;
        this.challengeRating = challengeRating;
        this.specialAbilities = specialAbilities;

    }
    public Monster(){};

    //Getters

    public int getIndex() {
        return index;
    }

    public String getName(){
        return name;
    }
    public int getChallengeRating(){
        return challengeRating;
    }
    public String getSize() {
        return size;
    }
    public List<String> getSpecialAbilities() {
        return specialAbilities;
    }

    //Setters

    public void setIndex(int index) {
        this.index = index;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setChallengeRating(int challengeRating) {
        this.challengeRating = challengeRating;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSpecialAbilities(List<String> specialAbilities) {
        this.specialAbilities = specialAbilities;
    }
}
