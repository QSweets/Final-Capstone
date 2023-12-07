package com.techelevator.model;

import java.util.List;

public class CharacterDto {
    private byte[] portrait;
    private String background;
    private List<String> abilities;
    private String name;
    private String creature;
    private String profession;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public Character(){
    }
    public byte[] getPortrait(){
        return portrait;
    }
    public String getBackground(){
        return background;
    }
    public List<String> getAbilities() {
        return abilities;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getCreature() {
        return creature;
    }

    public String getProfession() {
        return profession;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getDexterity() {
        return dexterity;
    }

    @Override
    public int getConstitution() {
        return constitution;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public int getWisdom() {
        return wisdom;
    }

    @Override
    public int getCharisma() {
        return charisma;
    }

    public void setPortrait(byte[] portrait) {
        this.portrait = portrait;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setCreature(String creature) {
        this.creature = creature;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    @Override
    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
