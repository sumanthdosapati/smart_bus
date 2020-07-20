package com.ds.bus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class Welcome extends AppCompatActivity {

    private static int SPLASH_TIME_OUT =2000;
    MediaPlayer oursound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        MediaPlayer oursound=MediaPlayer.create(this,R.raw.splashsound);
        oursound.start();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent n=new Intent(getApplicationContext(),Login.class);
                startActivity(n);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();

    }
}