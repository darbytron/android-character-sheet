package com.tylerdarby.charactersheet.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.utils.AppConstants;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getSharedPreferences(AppConstants.SHARED_PREF_KEY, Context.MODE_PRIVATE);
        String username = preferences.getString(AppConstants.USERNAME_KEY, "");
        if(username.isEmpty()) {
            //TODO: Navigate to user registration;
        }
        TextView usernameView = (TextView) findViewById(R.id.usernameLabel);
        usernameView.setText(username);

    }
}
