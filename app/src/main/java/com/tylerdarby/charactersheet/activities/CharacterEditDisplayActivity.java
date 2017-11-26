package com.tylerdarby.charactersheet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.helpers.BottomNavigationViewHelper;
import com.tylerdarby.charactersheet.models.Character;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_display);

        // Create the character
        Character character = new Character();

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

        // Populate the views
        characterNameEditText.setText(" " + character.getName());
        characterRaceEditText.setText(" " + character.getRace());
        characterClassEditText.setText(" " + character.getClass());
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
                                Intent charCreation = new Intent(getApplicationContext(), CharacterEditDisplayActivity.class);
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
}
