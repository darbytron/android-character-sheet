package com.tylerdarby.charactersheet.models;

/**
 * Created by savio_000 on 11/26/2017.
 */

public class Proficiencies {

    private String name;
    private String description;
    private int level;

    public Proficiencies(String name, String description, int level) {
        this.name = name;
        this.description = description;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
