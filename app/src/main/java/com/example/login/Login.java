package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private UserDatabase users; //this will be initialized through onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Grab UserDatabase object from intent that was passed from Splash.java
        users = (UserDatabase) getIntent().getSerializableExtra("userDatabase");
    }

    public void goToRegister(View v) {
        Intent i = new Intent(Login.this, Register.class);

        // Pass UserDatabase along
        i.putExtra("userDatabase", users);

        //Start new activity
        startActivity(i);
        finish();
    }

    public void login(View v) {
        EditText emailInput = (EditText)findViewById(R.id.editTextLoginEmail);
        String email = emailInput.getText().toString();

        EditText passwordInput = (EditText)findViewById(R.id.editTextPassword);
        String password = passwordInput.getText().toString();
        
        //Check for empty fields
        if (email.equals("") || password.equals("")) {
            //Display Toast informing of empty fields
            Toast toast = Toast.makeText(getApplicationContext(),
                    "All fields must be filled.", Toast.LENGTH_SHORT);
            toast.show();
            
        } else if (!ValidateField.isValidEmail(email)) {
            //is NOT a valid email
            emailInput.setError("Invalid email format");

        } else {
            //is a valid email, so check UserDatabase for matching (username, password)
            User user = users.getUser(email, password);

            if (user != null) {
                //found a valid account with matching credentials, so move to UserHomePage
                //prepare Intent to start new activity
                Intent i = new Intent(Login.this, UserHomePage.class);

                //Pass User object and users list
                i.putExtra("user", user);
                i.putExtra("userDatabase", users);

                //Start new activity
                startActivity(i);
                finish();
            } else {
                //no user was found with matching credentials
                emailInput.setError("No account found. Try again");
                passwordInput.setError("No account found. Try again");
            }
        }
    }
}