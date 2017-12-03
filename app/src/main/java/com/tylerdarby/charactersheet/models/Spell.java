package com.tylerdarby.charactersheet.models;

/**
 * Created by tdarby on 10/2/17.
 */

public class Spell {
    private String description;
    private String name;
    private String school;
    private String uses;

    public Spell(String name, String school, String uses, String description) {
        this.description = description;
        this.name = name;
        this.school = school;
        this.uses = uses;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }
}
