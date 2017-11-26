package com.tylerdarby.charactersheet.activities;

/**
 * Created by Xilador on 11/8/2017.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.*;
import com.tylerdarby.charactersheet.models.Character;

import com.tylerdarby.charactersheet.R;

public class CharacterCreation extends AppCompatActivity implements View.OnClickListener{

    int[] stats = new int[6];
    int level,armor,hpMax,hpCurrent;
    String name,playerClass,race;
    EditText[] stringFields = new EditText[3];
    EditText[] intFields = new EditText[10];
    Character player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);

        stringFields[0] = (EditText) findViewById(R.id.characterName);
        stringFields[1] = (EditText) findViewById(R.id.classValue);
        stringFields[2] = (EditText) findViewById(R.id.raceValue);
        intFields[0] = (EditText) findViewById(R.id.levelValue);
        intFields[1] = (EditText) findViewById(R.id.strengthValue);
        intFields[2] = (EditText) findViewById(R.id.dexterityValue);
        intFields[3] = (EditText) findViewById(R.id.constitutionValue);
        intFields[4] = (EditText) findViewById(R.id.intelligenceValue);
        intFields[5] = (EditText) findViewById(R.id.wisdomValue);
        intFields[6] = (EditText) findViewById(R.id.charismaValue);
        intFields[7] = (EditText) findViewById(R.id.armorValue);
        intFields[8] = (EditText) findViewById(R.id.maxHPValue);
        intFields[9] = (EditText) findViewById(R.id.currentHPValue);

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.submit:
                name = stringFields[0].getText().toString();
                playerClass = stringFields[1].getText().toString();
                race = stringFields[2].getText().toString();
                level = Integer.parseInt(intFields[0].getText().toString());
                for (int i = 1; i < 7; i ++){
                    stats[i-1] = Integer.parseInt(intFields[i].getText().toString());
                }
                armor = Integer.parseInt(intFields[7].getText().toString());
                hpMax = Integer.parseInt(intFields[8].getText().toString());
                hpCurrent = Integer.parseInt(intFields[9].getText().toString());
                player = new Character();
                createCharacter();
                break;
        }
    }

    public void createCharacter(){
        player.setStats(stats[4],stats[3],stats[0],stats[2],stats[1],stats[5]);
        player.setArmorClass(armor);
        player.setCharacterClass(playerClass);
        player.setRace(race);
        player.setLevel(level);
        player.setName(name);
        player.setHealth(hpMax,hpCurrent);
    }
}
