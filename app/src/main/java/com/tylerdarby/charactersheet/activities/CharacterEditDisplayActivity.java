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

import java.util.Locale;

public class CharacterEditDisplayActivity extends AppCompatActivity {

    // Declare the fields
    private EditText characterNameEditText;
    private EditText characterRaceEditText;
    private EditText characterClassEditText;
    private EditText characterExperienceEditText;
    private EditText characterBackgroundEditText;
    private EditText characterAlignmentEditText;
    private EditText characterLevelEditText;
    private EditText characterStrengthEditText;
    private EditText characterConstitutionEditText;
    private EditText characterDexterityEditText;
    private EditText characterIntelligenceEditText;
    private EditText characterWisdomEditText;
    private EditText characterCharismaEditText;
    private EditText characterArmorClassEditText;
    private EditText characterSpeedEditText;
    private EditText characterInitiativeEditText;
    private EditText characterVisionEditText;
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

        characterStrengthEditText = findViewById(R.id.characterStrengthEditText);
        characterConstitutionEditText = findViewById(R.id.characterConstitutionEditText);
        characterDexterityEditText = findViewById(R.id.characterDexterityEditText);
        characterIntelligenceEditText = findViewById(R.id.characterIntelligenceEditText);
        characterWisdomEditText = findViewById(R.id.characterWisdomEditText);
        characterCharismaEditText = findViewById(R.id.characterCharismaEditText);
        characterArmorClassEditText = findViewById(R.id.characterArmorClassEditText);
        characterSpeedEditText = findViewById(R.id.characterSpeedEditText);

        characterInitiativeEditText = findViewById(R.id.characterInitiativeEditText);
        characterVisionEditText = findViewById(R.id.characterVisionEditText);


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
            characterClassEditText.setText(character.getCharacterClass());
            characterExperienceEditText.setText(character.getExperiencePoints());
            characterBackgroundEditText.setText(character.getBackground());
            characterAlignmentEditText.setText(character.getAlignment());
            characterLevelEditText.setText(String.format(Locale.getDefault(), "%d", character.getLevel()));
            characterStrengthEditText.setText(String.format(Locale.getDefault(), "%d", character.getStats().getStrength()));
            characterConstitutionEditText.setText(String.format(Locale.getDefault(), "%d", character.getStats().getConstitution()));
            characterDexterityEditText.setText(String.format(Locale.getDefault(), "%d", character.getStats().getDexterity()));
            characterIntelligenceEditText.setText(String.format(Locale.getDefault(), "%d", character.getStats().getIntelligence()));
            characterWisdomEditText.setText(String.format(Locale.getDefault(), "%d", character.getStats().getWisdom()));
            characterCharismaEditText.setText(String.format(Locale.getDefault(), "%d", character.getStats().getCharisma()));
            characterArmorClassEditText.setText(String.format(Locale.getDefault(), "%d", character.getArmorClass()));
            characterSpeedEditText.setText(String.format(Locale.getDefault(), "%d", character.getSpeed()));
            characterInitiativeEditText.setText(String.format(Locale.getDefault(), "%d", character.getInitiative()));
            characterVisionEditText.setText(String.format(Locale.getDefault(), "%d", character.getVision()));

        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataManager dataManager = DataManager.getDataManager();
                setValues();
                dataManager.saveCharacter(character);
                finish();
            }
        });
    }

    private void setValues() {
        character.setName(characterNameEditText.getText().toString());
        character.setRace(characterRaceEditText.getText().toString());
        character.setCharacterClass(characterClassEditText.getText().toString());
        character.setExperiencePoints(characterExperienceEditText.getText().toString());
        character.setBackground(characterBackgroundEditText.getText().toString());
        character.setAlignment(characterAlignmentEditText.getText().toString());
        character.setLevel(Integer.parseInt(characterLevelEditText.getText().toString()));
        character.getStats().setStrength(Integer.parseInt(characterStrengthEditText.getText().toString()));
        character.getStats().setConstitution(Integer.parseInt(characterConstitutionEditText.getText().toString()));
        character.getStats().setDexterity(Integer.parseInt(characterDexterityEditText.getText().toString()));
        character.getStats().setIntelligence(Integer.parseInt(characterIntelligenceEditText.getText().toString()));
        character.getStats().setWisdom(Integer.parseInt(characterWisdomEditText.getText().toString()));
        character.getStats().setCharisma(Integer.parseInt(characterCharismaEditText.getText().toString()));

        character.setArmorClass(characterArmorClassEditText.getText().toString().isEmpty() ? 0 : Integer.parseInt(characterArmorClassEditText.getText().toString()));
        character.setSpeed(characterSpeedEditText.getText().toString().isEmpty() ? 0 : Integer.parseInt(characterSpeedEditText.getText().toString()));
        character.setInitiative(characterInitiativeEditText.getText().toString().isEmpty() ? 0 : Integer.parseInt(characterInitiativeEditText.getText().toString()));
        character.setVision(characterVisionEditText.getText().toString().isEmpty() ? 0 : Integer.parseInt(characterVisionEditText.getText().toString()));
    }
}
