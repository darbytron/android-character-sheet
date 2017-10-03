package com.tylerdarby.charactersheet.models;

/**
 * Created by tdarby on 10/2/17.
 */

public class Skills {
    private String modifierType;
    private String name;
    private int points;

    public String getModifierType() {
        return modifierType;
    }

    public void setModifierType(String modifierType) {
        this.modifierType = modifierType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
