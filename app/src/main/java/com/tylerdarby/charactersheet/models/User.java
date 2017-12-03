package com.tylerdarby.charactersheet.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tdarby on 10/2/17.
 */

public class User {
    private Map<String, Character> characters;
    private String username;
    private String firstName;

    public User(String username) {
        this.username = username;
        this.characters = new HashMap<>();
    }

    public User() { }

    public Map<String, Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Map<String, Character> characters) {
        this.characters = characters;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
