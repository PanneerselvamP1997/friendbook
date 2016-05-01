package com.example.aishafarheen.frienbookfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class SignupActivity extends Update{
    //  DatabaseHelper helper= new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onsignupClick(View v)
    {
        if(v.getId()==(R.id.button2))

        {
            EditText name=(EditText)findViewById(R.id.editText3);
            EditText email=(EditText)findViewById(R.id.editText4);
            EditText uname=(EditText)findViewById(R.id.editText5);
            EditText pass1=(EditText)findViewById(R.id.editText6);
            EditText pass2=(EditText)findViewById(R.id.editText7);

            String namestr=name.getText().toString();
            String emailstr=email.getText().toString();
            String unamestr=uname.getText().toString();
            String pass1str=pass1.getText().toString();
            String pass2str=pass2.getText().toString();

            if(!pass1str.equals(pass2str))
            {
                Toast pass= Toast.makeText(SignupActivity.this,"password don't match",Toast.LENGTH_SHORT);
                pass.show();


            }
            else
            {
                if((!namestr.equals(""))&&(!emailstr.equals(""))&&(!unamestr.equals(""))) {
                    //insert into db
                    Contact c = new Contact();
                    c.setName(namestr);
                    c.setEmail(emailstr);
                    c.setUname(unamestr);
                    c.setPass(pass1str);
                    // helper.insertContact(c);
                    Intent i1 = new Intent(SignupActivity.this, Update.class);
                    startActivity(i1);
                }
                else
                {
                    Toast pass= Toast.makeText(SignupActivity.this,"fill all the fields",Toast.LENGTH_SHORT);
                    pass.show();
                }

            }


        }

    }
}
