package com.tylerdarby.charactersheet.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.MenuItem;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.models.Character;
import com.tylerdarby.charactersheet.helpers.BottomNavigationViewHelper;

public class CharacterDisplayActivity extends AppCompatActivity {

    private TextView characterNameView;
    private TextView characterRaceView;
    private TextView characterClassView;
    private TextView characterExperienceView;
    private TextView characteBackgroundView;
    private TextView characterAlignmentView;
    private TextView characterLevelView;
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
        setContentView(R.layout.activity_character_display);

        Character character = new Character();

        character.setName("Faelina Lunala");
        character.setLevel(60);
        character.setBackground("Keeper of the Moon");
        character.setAlignment("Lawful Good");
        character.setExperiencePoints("0/4,000,000");
        character.setRace("Miqo'te");
        character.setCharacterClass("Paladin");
        character.setStats(10, 10, 10, 10, 10, 10);

        characterNameView = (TextView) findViewById(R.id.characterNameView);
        characterRaceView = (TextView) findViewById(R.id.characterRaceView);
        characterClassView = (TextView) findViewById(R.id.characterClassView);
        characterExperienceView = (TextView) findViewById(R.id.characterExperienceView);
        characteBackgroundView = (TextView) findViewById(R.id.characterBackgroundView);
        characterAlignmentView = (TextView) findViewById(R.id.characterAlignmentView);
        characterLevelView = (TextView) findViewById(R.id.characterLevelView);

        characterLevelView.setText("" + character.getLevel());


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
                        finish();
                        return false;
                    }
                });

    }
}
