package com.tylerdarby.charactersheet.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tylerdarby.charactersheet.R;
import com.tylerdarby.charactersheet.models.User;

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
                registerUser();
            }
        });
    }

    public void registerUser() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("users");
        String username = usernameText.getText().toString();
        if(!username.isEmpty() && isUsernameUnique()) {
            User user = new User(username);
            ref.child(username).setValue(user);
        } else {
            //TODO: Throw error
        }

    }

    public boolean isUsernameUnique(){ return true;}
}
