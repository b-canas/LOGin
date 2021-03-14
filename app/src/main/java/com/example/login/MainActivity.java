package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private UserDatabase users; //this will be initialized through onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Grab UserDatabase object from intent that was passed from Splash.java
        users = (UserDatabase) getIntent().getSerializableExtra("userDatabase");
    }

    //Onclick function that will go to activity_login
    public void goToLoginForm(View v) {
        //Create new Intent that will link to Login
        Intent i = new Intent(MainActivity.this, Login.class);

        // Pass UserDatabase along
        i.putExtra("userDatabase", users);

        //Start new activity
        startActivity(i);
        finish();
    }

    //Onclick function that will go to activity_register
    public void goToRegisterForm(View v) {
        //Create new Intent that will link to Register
        Intent i = new Intent(MainActivity.this, Register.class);

        // Pass UserDatabase along
        i.putExtra("userDatabase", users);

        //Start new activity
        startActivity(i);
        finish();
    }
}