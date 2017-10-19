package com.tylerdarby.charactersheet.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.helpers.BottomNavigationViewHelper;

import java.lang.reflect.Field;

public class DiceRoller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);
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
                                Intent charCreation = new Intent(getApplicationContext(), CharacterCreation.class);
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
