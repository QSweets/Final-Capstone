package com.techelevator.model;

import java.util.List;

public class CharacterDto {
    private Byte image;
    private String name;
    private String background;
    private String abilities;
    private String creature;
    private String profession;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public CharacterDto(Byte image, String name, String background, String abilities, String creature, String profession, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.image = image;
        this.name = name;
        this.background = background;
        this.abilities = abilities;
        this.creature = creature;
        this.profession = profession;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }
    public CharacterDto(){}

    public String getBackground(){
        return background;
    }
    public String getAbilities() {
        return abilities;
    }

    public String getName() {
        return name;
    }

    public Byte getImage() {
        return image;
    }

    public String getCreature() {
        return creature;
    }

    public String getProfession() {
        return profession;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }



    public void setBackground(String background) {
        this.background = background;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(Byte image) {
        this.image = image;
    }

    public void setCreature(String creature) {
        this.creature = creature;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
