package com.sahilasopa.chat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    DatabaseReference reference;

    // Loading the database on splash screen so other activities can access it quick
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        reference = FirebaseDatabase.getInstance().getReference(); // initialising the database
        Objects.requireNonNull(getSupportActionBar()).hide(); // hiding the action bar for better ui on splash screen
        new Handler().postDelayed(() -> {
            //This method will be executed once the timer is over
            // Start your app main activity
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
            // close this activity
            finish();
        }, 3000);
    }
}