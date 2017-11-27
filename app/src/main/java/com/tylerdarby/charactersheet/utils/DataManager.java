package com.tylerdarby.charactersheet.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Query;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.tylerdarby.charactersheet.models.Character;
import com.tylerdarby.charactersheet.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by tdarby on 11/26/17.
 */

public class DataManager {
    private static DataManager dataManager;
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference userReference;
    private User user;
    private HashMap<String, Character> characterMap;



    private DataManager() {}

    public static synchronized DataManager getDataManager() {
        if(dataManager == null) {
            dataManager = new DataManager();
            dataManager.characterMap = new HashMap<>();
        }
        return dataManager;
    }

    public void getData(final String username) {
        userReference = database.getReference("users/" + username);
        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
                if(user == null) {
                    user = new User(username);
                }
                if(user.getCharacters() != null) {
                    for(Character character : user.getCharacters()) {
                        characterMap.put(character.getId(), character);
                    }
                }

                userReference.setValue(user);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });
    }

    public User getUser() {
        return user;
    }

    public Character getCharacter(String id) {
        return characterMap.get(id);
    }

    public Collection<Character> getCharacters() {
        return characterMap.values();
    }
}
