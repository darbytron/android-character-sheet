package com.tylerdarby.charactersheet.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.models.Character;
import com.tylerdarby.charactersheet.models.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Xilador on 11/28/2017.
 */

public class CharacterSelect extends AppCompatActivity {

    ListView characterList;
    ArrayList<HashMap<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select);
        characterList = findViewById(R.id.character_search);
        list = new ArrayList<>();
        getInformation(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setFocusable(true);
        searchView.setFocusableInTouchMode(true);
        searchView.requestFocus();
        searchView.requestFocusFromTouch();
        searchView.setIconified(false);
        searchView.setQueryHint("Search for a character...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                getInformation(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    //send null instead to not filter it
    public void getInformation(String s){
        list.clear();
        if(s != null && !s.isEmpty()) {
            final String queryString = s.toLowerCase();
            final DatabaseReference db = FirebaseDatabase.getInstance().getReference("users");
            Query queryRef = db.orderByChild("characters/name");
            queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                        User user = childSnapshot.getValue(User.class);
                        if(user != null && user.getCharacters() != null) {
                            for(Character character : user.getCharacters().values()) {
                                if(character.getName().toLowerCase().contains(queryString)) {
                                    HashMap<String,String> temp = new HashMap<>();
                                    temp.put("User", user.getUsername());
                                    temp.put("Character Name", character.getName());
                                    temp.put("Class", character.getCharacterClass());
                                    temp.put("Level", String.format(Locale.getDefault(), "lv %d", character.getLevel()));
                                    list.add(temp);
                                }
                            }
                        }
                    }
                    updateList();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    list.clear();
                }
            });

        }

    }

    private void updateList() {
        SimpleAdapter adapter = new SimpleAdapter(this,
                list,
                R.layout.list_character_select,
                new String[] {"User","Character Name", "Class", "Level"},
                new int[] {R.id.list_user,R.id.list_character_name, R.id.list_class, R.id.list_level});
        characterList.setAdapter(adapter);
    }

}
