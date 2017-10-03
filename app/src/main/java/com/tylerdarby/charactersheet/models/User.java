package com.tylerdarby.charactersheet.models;

/**
 * Created by tdarby on 10/2/17.
 */

public class User {
    private Character character;
    private String userName;

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
