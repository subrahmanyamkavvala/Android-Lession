package com.practice;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);
/*
        if (savedInstanceState == null) {
           Fragmennt getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root_layout, new TitleFragment(), "booklist")
                    .commit();
        }*/


        FragmentManager fm =  getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.root_layout,new TitleFragment(),"book List");
        ft.commit();

    }
}
