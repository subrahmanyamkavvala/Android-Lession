package com.practice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener{
    private static final String TAG = "MainActivity";
    private String[] planets = new String[] { "Relative Layout", "Linear Layout", "Activities , LifeCycle"," Adapters, " +
            "Custom Adapters", "ListView, Spinner","Views, layouts and Common UI components",
            "Communicating data among Activities", "Toast , Dialog", "Status bar Notifications"};
    private ArrayList<String> planetList = new ArrayList<String>();

    ListView practiceListView;

    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planetList.addAll( Arrays.asList(planets));

        practiceListView = (ListView)findViewById(R.id.mainListView) ;

        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);
        // Set the ArrayAdapter as the ListView's adapter.
        practiceListView.setAdapter( listAdapter );
        practiceListView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Log.d(TAG,"onitemClicekd : "+position);
        switch (position){
            case 0:
                Intent intent = new Intent(this,RelativeLayoutActivity.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent2 = new Intent(this,ToastDialog.class);
                startActivity(intent2);
                break;
        }

    }
}
