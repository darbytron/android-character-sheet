package com.tylerdarby.charactersheet.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.helpers.BottomNavigationViewHelper;


public class MainActivity extends AppCompatActivity {

    private TextView textFavorites;
    private TextView textSchedules;
    private TextView textMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWindowAnimations();


        //Sample Firebase code for syncing data, please don't delete.
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message1");
//
//        myRef.setValue("Hello, World!");


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
                                Intent i = new Intent(MainActivity.this, Test.class);
                                startActivity(i);
                                break;
                        }
                        return false;
                    }
                });

    }

    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);

        Slide slide = new Slide();
        slide.setDuration(1000);
        getWindow().setReturnTransition(slide);
    }

    public void newAct(View view){
        Intent i = new Intent(MainActivity.this, Test.class);
        startActivity(i);
    }
}
