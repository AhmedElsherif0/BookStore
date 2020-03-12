package com.example.bookstore.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.bookstore.R;

public class SplashScreen extends AppCompatActivity {

    private static final int Splash_Time = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //FSLKDDFLK
                Intent i1 = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i1);
                finish();
            }
        }, Splash_Time);
    }
}
