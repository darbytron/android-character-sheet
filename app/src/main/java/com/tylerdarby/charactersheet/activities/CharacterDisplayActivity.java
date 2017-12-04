package com.tylerdarby.charactersheet.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.models.Character;
import com.tylerdarby.charactersheet.utils.AppConstants;
import com.tylerdarby.charactersheet.utils.DataManager;

public class CharacterDisplayActivity extends AppCompatActivity {

    // Declare the fields
    private TextView characterNameView;
    private TextView characterRaceView;
    private TextView characterClassView;
    private TextView characterExperienceView;
    private TextView characterBackgroundView;
    private TextView characterAlignmentView;
    private TextView characterLevelView;
    private TextView characterFeatsStrengthsLabel;
    private TextView characterSpellsLabel;
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

        // Create the character
        String id = getIntent().getStringExtra(AppConstants.CHARACTER_ID);
        Character character = DataManager.getDataManager().getCharacter(id);

        // Initialize the views
        characterNameView = (TextView) findViewById(R.id.characterNameView);
        characterRaceView = (TextView) findViewById(R.id.characterRaceView);
        characterClassView = (TextView) findViewById(R.id.characterClassView);
        characterExperienceView = (TextView) findViewById(R.id.characterExperienceView);
        characterBackgroundView = (TextView) findViewById(R.id.characterBackgroundView);
        characterAlignmentView = (TextView) findViewById(R.id.characterAlignmentView);
        characterLevelView = (TextView) findViewById(R.id.characterLevelView);
        characterFeatsStrengthsLabel = (TextView) findViewById(R.id.characterFeatsStrengthsLabel);
        characterSpellsLabel = (TextView) findViewById(R.id.characterSpellsLabel);

        // Populate the views
        characterNameView.setText(character.getName());
        characterRaceView.setText(character.getRace());
        characterClassView.setText(character.getCharacterClass());
        characterExperienceView.setText(character.getExperiencePoints());
        characterBackgroundView.setText(character.getBackground());
        characterAlignmentView.setText(character.getAlignment());
        characterLevelView.setText(character.getLevel());


        characterFeatsStrengthsLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CharacterDisplayActivity.this, FeatsAndStrengths.class);
                startActivity(intent);
            }
        });



        characterSpellsLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CharacterDisplayActivity.this, Spells.class);
                startActivity(intent);
            }
        });

    }
}
