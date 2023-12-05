package com.techelevator.model;

import java.util.List;

public class MonsterDto {
    private String name;
    private String size;
    private int challenegeRating;
    private List<String> specialAbilities;

    public MonsterDto(String name, String size, int challenegeRating, List<String> specialAbilities) {
        this.name = name;
        this.size = size;
        this.challenegeRating = challenegeRating;
        this.specialAbilities = specialAbilities;

    }
    public MonsterDto(){};

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getChallenegeRating() {
        return challenegeRating;
    }

    public List<String> getSpecialAbilities() {
        return specialAbilities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setChallenegeRating(int challenegeRating) {
        this.challenegeRating = challenegeRating;
    }

    public void setSpecialAbilities(List<String> specialAbilities) {
        this.specialAbilities = specialAbilities;
    }
}
