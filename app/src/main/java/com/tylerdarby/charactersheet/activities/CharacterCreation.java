package com.tylerdarby.charactersheet.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.models.Character;

public class CharacterCreation extends AppCompatActivity {

    private TextView characterNameView;
    private TextView characterRaceView;
    private TextView characterClassView;
    private TextView characterExperienceView;
    private TextView characteBackgroundView;
    private TextView characterAlignmentView;
    private TextView characterLevelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);

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


    }
}
