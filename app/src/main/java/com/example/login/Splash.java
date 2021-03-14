package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    //Duration of Splash screen
    private final int SPLASH_LENGTH = 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /* Create default user account and add to user database
        *  UserDatabase contains an ArrayList that holds User objects
        * */
        UserDatabase users = new UserDatabase();
        User defaultUser = new User("canasb1@gmail.com", "LOGinpassword",
                "Brian", "Canas", "05/16/1998");
        users.addUser(defaultUser);

        /* Initial TextViews in splash screen will fade out */
        TextView tvWelcome = (TextView)findViewById(R.id.welcomeText);
        TextView tvAppName = (TextView)findViewById(R.id.appName);

        //Create Animation to Fade-out TextViews
        Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        animFadeOut.setFillAfter(true);

        tvWelcome.startAnimation(animFadeOut);
        tvAppName.startAnimation(animFadeOut);

        /* New Handler to start next activity and close the splash screen after some time */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // Create Intent to move to next activity
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);

                // Pass UserDatabase along
                mainIntent.putExtra("userDatabase", users);

                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_LENGTH);
    }
}
