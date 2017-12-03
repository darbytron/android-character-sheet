package com.tylerdarby.charactersheet.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.utils.AppConstants;
import com.tylerdarby.charactersheet.utils.DataManager;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getSharedPreferences(AppConstants.SHARED_PREF_KEY, Context.MODE_PRIVATE);
        String username = preferences.getString(AppConstants.USERNAME_KEY, "");
        DataManager dataManager = DataManager.getDataManager();
        if(username.isEmpty()) {
            startActivity(new Intent(getApplicationContext(), UserRegistration.class));
        } else {
            dataManager.getData(username);
        }

        username = dataManager.getUser().getUsername();
        setContentView(R.layout.activity_main);
        TextView usernameView = (TextView) findViewById(R.id.usernameLabel);
        usernameView.setText(username);
    }
}
