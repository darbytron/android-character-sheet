package com.tylerdarby.charactersheet.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.helpers.BottomNavigationViewHelper;


public class MainActivity extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.menu_settings:
                startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private TextView textFavorites;
    private TextView textSchedules;
    private TextView textMusic;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        super.onCreate(savedInstanceState);
        if(pref.getString("themePref","").equals("Light")) {
            setTheme(R.style.AppTheme);
        }
        else if(pref.getString("themePref","").equals("Dark")){
            setTheme(R.style.AppThemeDark);
        }
        setContentView(R.layout.activity_main);

        //Sample Firebase code for syncing data, please don't delete.
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message1");
//
//        myRef.setValue("Hello, World!");

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper viewHelper = new BottomNavigationViewHelper();
        viewHelper.disableShiftMode(bottomNavigationView);
        if(pref.getString("themePref","").equals("Light")) {
            bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
        }
        else if(pref.getString("themePref","").equals("Dark")){
            bottomNavigationView.setItemBackgroundResource(R.color.frenchPuce);
        }

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
                        finish();
                        return false;
                    }
                });

    }
}
