package com.example.gocode.detetive.activites;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.gocode.detetive.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        ImageView imageView = (ImageView) findViewById(R.id.imageViewSplashScreen);
        imageView.setImageResource(R.drawable.onlinelogomaker_111116_2211_8437);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
