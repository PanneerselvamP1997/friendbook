package com.example.aishafarheen.frienbookfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Toast temp = Toast.makeText(MainActivity.this, "Welcome to Friendbook", Toast.LENGTH_SHORT);
        temp.show();
    }
    public void onButtonClick(View v) {
        if (v.getId() == (R.id.button)) {

            EditText a = (EditText) findViewById(R.id.editText);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.editText2);
            if((!a.getText().toString().equals(""))&&(!b.getText().toString().equals(""))) {
                Intent i = new Intent(MainActivity.this, Newsfeed.class);
                startActivity(i);
            }
            else
            {
                Toast temp = Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT);
                temp.show();
            }
        }
        if (v.getId() == (R.id.button3)) {
            Intent i = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(i);
            Toast temp = Toast.makeText(MainActivity.this, "Fill in your details", Toast.LENGTH_SHORT);
            temp.show();
        }
        else {
           // Toast temp = Toast.makeText(MainActivity.this, "password and username don't match", Toast.LENGTH_SHORT);
            //temp.show();
            Toast temp = Toast.makeText(MainActivity.this, "You are loggged in", Toast.LENGTH_SHORT);
            temp.show();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
