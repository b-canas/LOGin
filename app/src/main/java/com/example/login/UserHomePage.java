package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserHomePage extends AppCompatActivity {
    private UserDatabase users;
    private User userAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpage);

        //Grab user account and UserDatabase from Intent
        userAccount = (User)getIntent().getSerializableExtra("user");
        users = (UserDatabase)getIntent().getSerializableExtra("userDatabase");

        //Create variables for relevant user information
        String userFirstName, userLastName, userBirthday, userEmail;
        TextView tvFirstName, tvLastName, tvBirthday, tvEmail;

        //Fetch user information
        userFirstName = userAccount.getFirstName();
        userLastName = userAccount.getLastName();
        userBirthday = userAccount.getBirthday();
        userEmail = userAccount.getEmail();

        /* Display user information to screen */
        //TextView first name
        tvFirstName = (TextView)findViewById(R.id.tvUserInfoFirstName);
        tvFirstName.setText(userFirstName);

        //TextView last name
        tvLastName = (TextView)findViewById(R.id.tvUserInfoLastName);
        tvLastName.setText(userLastName);

        //TextView birthday
        tvBirthday = (TextView)findViewById(R.id.tvUserInfoBirthday);
        tvBirthday.setText(userBirthday);

        //TextView email
        tvEmail = (TextView)findViewById((R.id.tvUserInfoEmail));
        tvEmail.setText(userEmail);
    }

    public void logout(View v)
    {
        //prepare Intent to LOGout and go to MainActivity
        Intent i = new Intent(UserHomePage.this, MainActivity.class);

        //Pass UserDatabase along Intent but NOT this unique user
        i.putExtra("userDatabase", users);

        //Start new activity
        startActivity(i);
        finish();
    }
}
