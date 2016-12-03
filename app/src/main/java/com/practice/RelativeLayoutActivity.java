package com.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RelativeLayoutActivity extends AppCompatActivity implements View.OnClickListener{
    Button cancel,submit;
    EditText userName,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        cancel = (Button)findViewById(R.id.button) ;
        submit = (Button)findViewById(R.id.button2) ;
        userName = (EditText)findViewById(R.id.userName) ;
        password = (EditText)findViewById(R.id.editText2) ;

        userName.setText("enter your user name");
        password.setText("enter your user pass");

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("MainActivity","onclicke what u want to do ?");
                String username= userName.getText().toString();
                String pass = password.getText().toString();
                Log.d("MainActivity","username "+username);
                Log.d("MainActivity","passs  "+pass);


            }
        });

        submit.setOnClickListener(this);


        Log.d("MainActivity","OnCreate Called");

    }
    @Override
    public void onClick(View v) {
        Log.d("MainActivity","summit clicked ");
        String username= userName.getText().toString();
        String pass = password.getText().toString();
        Log.d("MainActivity","username "+username);
        Log.d("MainActivity","passs  "+pass);

    }
}
