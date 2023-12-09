package com.techelevator.model;

import java.util.List;

public class Character extends Creature {

    private int user_id;

    private String background;

    //Spells is an ability
   private String abilities;
   //Creature is race
    private String creature;
    //Profession is character class
    private String profession;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public Character(int id, String name, Byte image, int user_id, String background, String abilities, String creature, String profession, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(id, name, image);
        this.user_id = user_id;
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

    public Character() {
    }

    public String getBackground() {
        return background;
    }

    public String getAbilities() {
        return abilities;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getCreature() {
        return creature;
    }

    public void setCreature(String creature) {
        this.creature = creature;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

}
