package com.tylerdarby.charactersheet.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.helpers.BottomNavigationViewHelper;
import com.tylerdarby.charactersheet.utils.ShakeDetector;

public class DiceRoller extends AppCompatActivity implements OnClickListener {

    // Get references to widgets
    private Spinner diceSpinner;
    private Spinner sideSpinner;
    private Button calculateButton;
    private TextView displayValueLabel;
    private TextView displayTotalLabel;

    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);

        // Get widget references
        diceSpinner = (Spinner) findViewById(R.id.diceSpinner);
        sideSpinner = (Spinner) findViewById(R.id.sideSpinner);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        displayValueLabel = (TextView) findViewById(R.id.displayValueLabel);
        displayTotalLabel = (TextView) findViewById(R.id.displayTotalLabel);

        // Create array adapter for specified array and layout
        ArrayAdapter<CharSequence> diceAdapter = ArrayAdapter.createFromResource(this, R.array.diceArray, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> sideAdapter = ArrayAdapter.createFromResource(this, R.array.sideArray, android.R.layout.simple_spinner_item);

        // Set the layout for the drop-down list
        diceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sideAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter for the spinner
        diceSpinner.setAdapter(diceAdapter);
        sideSpinner.setAdapter(sideAdapter);

        // Set the listener for the button
        calculateButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                diceRoll();

            }
        });

        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {

                diceRoll();

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

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    @Override
    public void onClick(View view) {

    }

    // Method for rolling the dice
    public void diceRoll() {

        String diceRolls = (String) diceSpinner.getSelectedItem();
        String diceSides = (String) sideSpinner.getSelectedItem();
        String rolledValues = "";
        int total = 0;

        int diceRollsInt = Integer.parseInt(diceRolls);
        int diceSidesInt = Integer.parseInt(diceSides);

        for (int i = 0; i < diceRollsInt; i ++) {
            int random = (int)(Math.random() * diceSidesInt + 1);
            total += random;
            int diceNumber = i + 1;
            rolledValues += " Die " + diceNumber + ": " + random + "\n";
        }

        String stringTotal = " ";
        stringTotal += total;

        displayValueLabel.setText(rolledValues);
        displayTotalLabel.setText(stringTotal);

    }
}

