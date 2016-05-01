package com.example.aishafarheen.frienbookfinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Aisha Farheen on 4/18/2016.
 */

public class Newsfeed extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent serviceIntent2 = new Intent(this, Recognition.class);
        startService(serviceIntent2);
       Intent serviceIntent = new Intent(this, Loca.class);
       startService(serviceIntent);
        //  Intent serviceIntent3 = new Intent(this, Usage.class);
        // startService(serviceIntent3);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsfeeds);
        Button button = (Button) findViewById(R.id.Name);
        button.setOnClickListener(new MyClass());
        Button button1 = (Button) findViewById(R.id.Name2);
        button1.setOnClickListener(new MyClass());
        Button button2 = (Button) findViewById(R.id.Name3);
        button2.setOnClickListener(new MyClass());




    }
    public class MyClass implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.Name) {
                Uri uri = Uri.parse("https://www.facebook.com/lakshmi.sree.77");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

            if (v.getId() == R.id.Name2) {
                Uri uri = Uri.parse("https://www.facebook.com/leroy.j.vargis");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

            if (v.getId() == R.id.Name3) {
                Uri uri = Uri.parse("https://www.facebook.com/bony.kuriakose.1");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        }
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
