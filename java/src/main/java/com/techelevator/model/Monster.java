package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Creature {


    private String url;

    private String index;

    private String name;


    //POJO constructors
    public Monster(String index, String name, String size, String url, int challengeRating, List<String> specialAbilities) {
        this.index = index;
        this.name = name;
        this.url = url;



    }
    public Monster(){};

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


    //Setters

    public void setIndex(String index) {
        this.index = index;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
