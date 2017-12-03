package com.tylerdarby.charactersheet.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.utils.AppConstants;
import com.tylerdarby.charactersheet.utils.DataManager;

public class UserRegistration extends AppCompatActivity {
    private EditText usernameText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        usernameText = (EditText) findViewById(R.id.usernameField);
        registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser(usernameText.getText().toString());
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    public void registerUser(String username) {
        DataManager.getDataManager().getData(username);
        SharedPreferences preferences = getSharedPreferences(AppConstants.SHARED_PREF_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppConstants.USERNAME_KEY, username);
        editor.commit();

    }
}
