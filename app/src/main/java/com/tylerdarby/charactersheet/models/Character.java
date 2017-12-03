package com.tylerdarby.charactersheet.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tdarby on 10/2/17.
 */

@IgnoreExtraProperties
public class Character {

    private String id;
    //Required
    private int armorClass;
    private String characterClass;
    private String featsAndTraits;
    private int level;
    private String name;
    private String race;
    private Stats stats;
    private HealthPoints health;

    //Optional
    private List<InventoryItem> inventory;
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
        health = new HealthPoints();
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

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
//        result.put("id", id);
//        result.put("armorClass", armorClass);
//        result.put("characterClass", characterClass);
//        result.put("featsAndTraits", featsAndTraits);
//        result.put("name", name);
//        result.put("race", race);
//        result.put("stats", stats);
        result.put("armorClass", 10);
        result.put("characterClass", "Test Character Class");
        result.put("featsAndTraits", "Test Features");
        result.put("name", "Test Name");
        result.put("race", "Test Race");

        return result;
    }
}
