package com.tylerdarby.charactersheet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.helpers.BottomNavigationViewHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Xilador on 11/28/2017.
 */

public class CharacterSelect extends AppCompatActivity {

    ListView characterList;
    SimpleAdapter adapter;
    ArrayList<HashMap<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select);
        characterList = (ListView) findViewById(R.id.character_search);
        list = new ArrayList<HashMap<String,String>>();
        getInformation(null);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper viewHelper = new BottomNavigationViewHelper();
        viewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_new_char:
                                Intent charCreation = new Intent(getApplicationContext(), CharacterDisplayActivity.class);
                                startActivity(charCreation);
                                break;
                            case R.id.action_dice:
                                Intent diceRoller = new Intent(getApplicationContext(), DiceRoller.class);
                                startActivity(diceRoller);
                                break;
                            case R.id.action_home:
                                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(mainActivity);
                                break;
                            case R.id.action_new_user:
                                Intent userReg = new Intent(getApplicationContext(), UserRegistration.class);
                                startActivity(userReg);
                                break;
                            case R.id.action_reserved:
                                break;
                        }
                        return false;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                getInformation(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    //send null instead to not filter it
    public void getInformation(String s){
        // example of how to input info into the list
        //No need to filter results based on the text,  The bottom should do that for us
        /*
        if (the data exists){
            while(getNextDataSet){
                HashMap<String,String> temp = new HashMap<String, String>();
                temp.put("User", getUser);
                temp.put("Character Name", getName);
                temp.put("Class", getClass());
                temp.put("Level", getLevel());
                list.add(temp);
            }
        }
         */
        if (s == null){
            //#NoFilter
        }
        else{
            //#filtered
        }
        SimpleAdapter adapter = new SimpleAdapter(this,
                list,
                R.layout.list_character_select,
                new String[] {"User","Character Name", "Class", "Level"},
                new int[] {R.id.list_user,R.id.list_character_name, R.id.list_class, R.id.list_level});
        //characterList.setAdapter(adapter);
    }

}
