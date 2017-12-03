package com.tylerdarby.charactersheet.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.helpers.BottomNavigationViewHelper;
import com.tylerdarby.charactersheet.models.Character;
import com.tylerdarby.charactersheet.utils.DataManager;

public class CharacterEditDisplayActivity extends AppCompatActivity {

    // Declare the fields
    private EditText characterNameEditText;
    private EditText characterRaceEditText;
    private EditText characterClassEditText;
    private EditText characterExperienceEditText;
    private EditText characterBackgroundEditText;
    private EditText characterAlignmentEditText;
    private EditText characterLevelEditText;
    private TextView characterFeatsStrengthsLabel;
    private TextView characterSpellsLabel;
    private Character character;
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
        setContentView(R.layout.activity_character_display_edit);

        // Create the character
        character = new Character();

        // Set the Character values
        character.setName("Faelina Lunala");
        character.setLevel(60);
        character.setBackground("Keeper of the Moon");
        character.setAlignment("Lawful Good");
        character.setExperiencePoints("0/4,000,000");
        character.setRace("Miqo'te");
        character.setCharacterClass("Paladin");
        character.setStats(10, 10, 10, 10, 10, 10);

        // Initialize the views
        characterNameEditText = (EditText) findViewById(R.id.characterNameEditText);
        characterRaceEditText = (EditText) findViewById(R.id.characterRaceEditText);
        characterClassEditText = (EditText) findViewById(R.id.characterClassEditText);
        characterExperienceEditText = (EditText) findViewById(R.id.characterExperienceEditText);
        characterBackgroundEditText = (EditText) findViewById(R.id.characterBackgroundEditText);
        characterAlignmentEditText = (EditText) findViewById(R.id.characterAlignmentEditText);
        characterLevelEditText = (EditText) findViewById(R.id.characterLevelEditText);
        characterFeatsStrengthsLabel = (TextView) findViewById(R.id.characterFeatsStrengthsLabel);
        characterSpellsLabel = (TextView) findViewById(R.id.characterSpellsLabel);
        Button saveButton = findViewById(R.id.saveButton);

        // Populate the views
        characterNameEditText.setText(" " + character.getName());
        characterRaceEditText.setText(" " + character.getRace());
        characterClassEditText.setText(" " + character.getClass()); //getCharacterClass
        characterExperienceEditText.setText(" " + character.getExperiencePoints());
        characterBackgroundEditText.setText(" " + character.getBackground());

        characterLevelEditText.setText(" " + character.getLevel());

        // Set up the listeners
        characterFeatsStrengthsLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CharacterEditDisplayActivity.this, FeatsAndStrengths.class);
                startActivity(intent);
            }
        });

        characterSpellsLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CharacterEditDisplayActivity.this, Spells.class);
                startActivity(intent);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataManager dataManager = DataManager.getDataManager();
                dataManager.saveCharacter(character);
            }
        });


    }
}
