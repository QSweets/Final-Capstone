package com.techelevator.model;

public abstract class Creature {
    private int id;
    private String character_name;
    private int image_id;
    public Creature(int id, String character_name, int image_id) {
        this.id = id;
        this.character_name = character_name;
        this.image_id = image_id;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public Creature() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacter_name() {
        return character_name;
    }

    public void setName(String name) {
        this.character_name = character_name;
    }

    public Object getImage() {
        return null;
    }
}

