package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

public class Monster extends Creature {
    private int challenegeRating;
    private String size;
    private List<String> specialAbilities;


    //POJO constructors
    public Monster(String name, String size, int challenegeRating, List<String> specialAbilities) {
        this.name = name;
        this.size = size;
        this.challenegeRating = challenegeRating;
        this.specialAbilities = specialAbilities;

    }
    public Monster(){};

    //Getters
    public String getName(){
        return name;
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

    //Setters

    public void setName(String name) {
        this.name = name;
    }
    public void setChallenegeRating(int challenegeRating) {
        this.challenegeRating = challenegeRating;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSpecialAbilities(List<String> specialAbilities) {
        this.specialAbilities = specialAbilities;
    }
}
