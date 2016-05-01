package com.example.aishafarheen.frienbookfinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import java.util.logging.Handler;

/**
 * Created by Aisha Farheen on 4/19/2016.
 */
public class Splash extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }}


