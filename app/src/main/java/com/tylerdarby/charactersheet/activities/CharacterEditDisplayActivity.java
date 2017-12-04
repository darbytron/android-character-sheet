package com.tylerdarby.charactersheet.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.helpers.BottomNavigationViewHelper;
import com.tylerdarby.charactersheet.models.Character;
import com.tylerdarby.charactersheet.utils.AppConstants;
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

        // Initialize the views
        characterNameEditText = (EditText) findViewById(R.id.characterNameEditText);
        characterRaceEditText = (EditText) findViewById(R.id.characterRaceEditText);
        characterClassEditText = (EditText) findViewById(R.id.characterClassEditText);
        characterExperienceEditText = (EditText) findViewById(R.id.characterExperienceEditText);
        characterBackgroundEditText = (EditText) findViewById(R.id.characterBackgroundEditText);
        characterAlignmentEditText = (EditText) findViewById(R.id.characterAlignmentEditText);
        characterLevelEditText = (EditText) findViewById(R.id.characterLevelEditText);
        Button saveButton = findViewById(R.id.saveButton);

        // Create the character
        String id = getIntent().getStringExtra(AppConstants.CHARACTER_ID);
        if(id == null) {
            character = new Character();
        } else {
            character = DataManager.getDataManager().getCharacter(id);
            // Populate the views
            characterNameEditText.setText(character.getName());
            characterRaceEditText.setText(character.getRace());
            characterClassEditText.setText(character.getCharacterClass()); //getCharacterClass
            characterExperienceEditText.setText(character.getExperiencePoints());
            characterBackgroundEditText.setText(character.getBackground());
            characterLevelEditText.setText(character.getLevel());
            //TODO: Finish character prefill
        }



        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataManager dataManager = DataManager.getDataManager();
                setValues();
                dataManager.saveCharacter(character);
                //TODO: Enter Toast
                finish();
            }
        });


    }

    private void setValues() {
        
    }
}
