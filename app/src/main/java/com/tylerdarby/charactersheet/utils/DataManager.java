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
import java.util.Map;

/**
 * Created by tdarby on 11/26/17.
 */

public class DataManager {
    private static DataManager dataManager;
    private User user;

    public interface OnDataUpdateListener {
        void onDataUpdate();
    }



    private DataManager() {}

    public static synchronized DataManager getDataManager() {
        if(dataManager == null) {
            dataManager = new DataManager();
            dataManager.loadSampleData();
        }
        return dataManager;
    }

    public void getData(final String username) {
        final DatabaseReference userReference = FirebaseDatabase.getInstance().getReference("users/" + username);
        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
                if(user == null) {
                    user = new User(username);
                }
                userReference.setValue(user);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });
    }

    private void loadSampleData() {
        user = new User("Loading...");

    }

    public User getUser() {
        if(user.getCharacters() == null) {
            user.setCharacters(new HashMap<String, Character>());
        }
        return user;
    }

    public Character getCharacter(String id) {
        return getUser().getCharacters().get(id);
    }

    public Collection<Character> getCharacters() {
        return getUser().getCharacters().values();
    }

    public void saveCharacter(Character character) {
        final DatabaseReference userReference = FirebaseDatabase.getInstance().getReference("users/" + user.getUsername());
        DatabaseReference characterDb = userReference.child("characters");
        String key = characterDb.push().getKey();
        Map<String, Object> charValues = character.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(key, charValues);
        characterDb.updateChildren(childUpdates);
    }
}
