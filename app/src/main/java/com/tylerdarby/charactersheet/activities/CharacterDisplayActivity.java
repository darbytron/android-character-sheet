package com.tylerdarby.charactersheet.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.MenuItem;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.models.Character;
import com.tylerdarby.charactersheet.helpers.BottomNavigationViewHelper;
import com.tylerdarby.charactersheet.utils.AppConstants;
import com.tylerdarby.charactersheet.utils.DataManager;

import org.w3c.dom.Text;

public class CharacterDisplayActivity extends AppCompatActivity {

    // Declare the fields
    private TextView characterNameView;
    private TextView characterRaceView;
    private TextView characterBackgroundView;
    private TextView characterLevelView;
    private TextView characterExperienceView;
    private TextView characterClassView;
    private TextView characterAlignmentView;
    private TextView characterStrView;
    private TextView characterConView;
    private TextView characterDexView;
    private TextView characterIntView;
    private TextView characterWisView;
    private TextView characterChaView;
    private TextView characterArmorClassView;
    private TextView characterSpeedView;
    private TextView characterInitiativeView;
    private TextView characterVisionView;
    private TextView characterSkillsLabel;
    private TextView characterProficienciesLabel;
    private TextView characterSpellsLabel;
    private TextView characterInventoryLabel;
    private TextView characterHistoryLabel;
    private SharedPreferences pref;
    private boolean showMenu = true;

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
        characterBackgroundView = (TextView) findViewById(R.id.characterBackgroundView);
        characterLevelView = (TextView) findViewById(R.id.characterLevelView);
        characterExperienceView = (TextView) findViewById(R.id.characterExperienceView);
        characterClassView = (TextView) findViewById(R.id.characterClassView);
        characterAlignmentView = (TextView) findViewById(R.id.characterAlignmentView);
        characterStrView = (TextView) findViewById(R.id.characterStrengthView);
        characterConView = (TextView) findViewById(R.id.characterConstitutionView);
        characterDexView = (TextView) findViewById(R.id.characterDexterityView);
        characterIntView = (TextView) findViewById(R.id.characterIntelligenceView);
        characterWisView = (TextView) findViewById(R.id.characterWisdomView);
        characterChaView = (TextView) findViewById(R.id.characterCharismaView);
        characterArmorClassView = (TextView) findViewById(R.id.characterArmorClassView);
        characterSpeedView = (TextView) findViewById(R.id.characterSpeedView);
        characterInitiativeView = (TextView) findViewById(R.id.characterInitiativeView);
        characterVisionView = (TextView) findViewById(R.id.characterVisionView);
        characterSkillsLabel = (TextView) findViewById(R.id.characterSkillsLabel);
        characterProficienciesLabel = (TextView) findViewById(R.id.characterProficienciesLabel);
        characterSpellsLabel = (TextView) findViewById(R.id.characterSpellsLabel);
        characterInventoryLabel = (TextView) findViewById(R.id.characterInventoryLabel);
        characterHistoryLabel = (TextView) findViewById(R.id.characterHistoryLabel);


        // Populate the views
        characterNameView.setText(character.getName());
        characterRaceView.setText(character.getRace());
        characterBackgroundView.setText(character.getBackground());
        characterLevelView.setText(character.getLevel());
        characterExperienceView.setText(character.getExperiencePoints());
        characterClassView.setText(character.getCharacterClass());
        characterAlignmentView.setText(character.getAlignment());
        characterStrView.setText(character.getStats().getStrength());
        characterConView.setText(character.getStats().getConstitution());
        characterDexView.setText(character.getStats().getDexterity());
        characterIntView.setText(character.getStats().getIntelligence());
        characterWisView.setText(character.getStats().getWisdom());
        characterChaView.setText(character.getStats().getStrength());
        characterArmorClassView.setText(character.getArmorClass());
        characterSpeedView.setText(character.getSpeed());
        characterInitiativeView.setText(character.getInitiative());
        characterVisionView.setText(character.getArmorClass());



        characterSkillsLabel.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.character_display_activity_menu, menu);
        MenuItem editItem = menu.findItem(R.id.editCharacter);

        if (showMenu == false) {
            editItem.setVisible(false);
        }

        return true;
    }
}
