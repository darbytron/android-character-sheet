package com.tylerdarby.charactersheet.utils;

import android.content.SharedPreferences;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.tylerdarby.charactersheet.models.Character;
import com.tylerdarby.charactersheet.models.User;

import java.util.ArrayList;
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
        }
        return dataManager;
    }

    private void getData(String username) {
        userReference = database.getReference("users/" + username);
        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });
    }

    public User getUser() {
        return user;
    }

    public Character getCharacter(String id) {
        if(characterMap != null && characterMap.get(id) != null) {
            return characterMap.get(id);
        } else {
            if(characterMap == null) {
                characterMap = new HashMap<>();
            }

            DatabaseReference characterReference = userReference.child("characters");

            Query query =  characterReference.orderByChild("id").equalTo(id);
            query.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Character character = dataSnapshot.getValue(Character.class);
                    characterMap.put(character.getId(), character);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    Character character = dataSnapshot.getValue(Character.class);
                    characterMap.put(character.getId(), character);
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    Character character = dataSnapshot.getValue(Character.class);
                    characterMap.remove(character.getId());
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    Character character = dataSnapshot.getValue(Character.class);
                    characterMap.put(character.getId(), character);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) { }
            });
        }

        return characterMap.get(id);
    }
}
