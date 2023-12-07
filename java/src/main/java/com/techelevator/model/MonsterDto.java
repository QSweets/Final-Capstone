package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

public class MonsterDto extends Creature {

    private String url;

    private String index;

    private String name;

    private String size;
    private double challengeRating;
    private List<String> specialAbilities;
    private String image;


    //POJO constructors
    public MonsterDto(String index, String name, String size, String url, double challengeRating, List<String> specialAbilities, String image) {
        this.index = index;
        this.name = name;
        this.url = url;
        this.size = size;
        this.challengeRating = challengeRating;
        this.specialAbilities = specialAbilities;
        this.image = image;
    }

    //Maybe separate constructors for index/name/url and name/size/challengerating/specialabilities/image
    public MonsterDto(){};
<<<<<<< HEAD
    public String getName() {
        return name;
    }
    public String getSize() {
        return size;
    }
    public int getChallengeRating() {
        return challengeRating;
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
    public void setChallengeRating(int challengeRating) {
        this.challengeRating = challengeRating;
    }
    public void setSpecialAbilities(List<String> specialAbilities) {
        this.specialAbilities = specialAbilities;
=======

    //Getters

    public String getIndex() {
        return index;
    }

    public String getUrl() {
        return url;
    }


    public String getName(){
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double getChallengeRating() {
        return challengeRating;
    }

    @Override
    public void setChallengeRating(double challengeRating) {
        this.challengeRating = challengeRating;
    }

    @Override
    public List<String> getSpecialAbilities() {
        return specialAbilities;
    }

    @Override
    public void setSpecialAbilities(List<String> specialAbilities) {
        this.specialAbilities = specialAbilities;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String getImage() {
        return image;
    }

    //Setters

    public void setIndex(String index) {
        this.index = index;
>>>>>>> 5ff9724892be829efb14f2ce00ce4b6a4fccbaea
    }
    public void setName(String name) {
        this.name = name;
    }



}
