package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Splash extends AppCompatActivity {

    //Duration of Splash screen
    private final int SPLASH_LENGTH = 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

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
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_LENGTH);
    }
}
