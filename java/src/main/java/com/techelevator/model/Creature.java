package com.techelevator.model;

public abstract class Creature {
    private int id;
    private String name;
    private Byte image;
    private Integer image_id;  // New property for image ID

    public Creature(int id, String name, Byte image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public Creature() {}

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

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }
}

