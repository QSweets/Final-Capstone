package com.techelevator.model;

import java.util.List;

public abstract class Creature {
    private int id;
    public String name;
    private Byte image;

    public Creature(int id, String name, Byte image){
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public Creature(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getImage() {
        return image;
    }

    public void setImage(Byte image) {
        this.image = image;
    }


}
