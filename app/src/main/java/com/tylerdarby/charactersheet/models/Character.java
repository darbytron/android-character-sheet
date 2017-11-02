package com.tylerdarby.charactersheet.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tdarby on 10/2/17.
 */

public class Character {

    private String id;
    private String owner; //User.userName
    //Required
    private int armorClass;
    private String characterClass;
    private String featsAndTraits;
    private List<InventoryItem> inventory;
    private int level;
    private String name;
    private String race;
    private Stats stats;

    //Optional
    private String alignment;
    private String background;
    private String experiencePoints;
    private String groupName;
    private int initiative;
    private String proficiencies;
    private int speed;
    private List<Spell> spells;
    private int vision;
    private String notes;

    public Character() {
        stats = new Stats();
        inventory = new ArrayList<>();
        spells = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getFeatsAndTraits() {
        return featsAndTraits;
    }

    public void setFeatsAndTraits(String featsAndTraits) {
        this.featsAndTraits = featsAndTraits;
    }

    public List<InventoryItem> getInventory() {
        return inventory;
    }

    public void setInventory(List<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(int wisdom, int intelligence, int strength, int constitution, int dexterity, int charisma) {
        this.stats.setWisdom(wisdom);
        this.stats.setIntelligence(intelligence);
        this.stats.setStrength(strength);
        this.stats.setConstitution(constitution);
        this.stats.setDexterity(dexterity);
        this.stats.setCharisma(charisma);
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(String experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public String getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(String proficiencies) {
        this.proficiencies = proficiencies;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
