package com.tylerdarby.charactersheet.models;

import java.util.ArrayList;

/**
 * Created by tdarby on 10/2/17.
 */

public class User {
    private ArrayList<Character> characters;
    private String username;
    private String firstName;

    public User(String username) {
        this.username = username;
    }

    public User() {

    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacter(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public void addCharacter(Character character) {
        if(characters == null) {
            characters = new ArrayList<>();
        }
        //TODO: Maybe check firebase to verify character exists before pushing to list.
        characters.add(character);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
