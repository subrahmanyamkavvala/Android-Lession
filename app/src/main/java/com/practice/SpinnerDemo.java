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
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerDemo extends Activity {

    private static final String TAG = "SpinnerDemo";
    private android.widget.Spinner spinner1;
    private Button btnSubmit;



    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"SpinnerDemo : onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"SpinnerDemo oncreate");
        setContentView(R.layout.activity_spinner);
        spinner1 = (Spinner) findViewById(R.id.spinner1);

        List<String> list = new ArrayList<String>();
        list.add("Android");
        list.add("Java");
        list.add("SpinnerDemo Data");
        list.add("SpinnerDemo Adapter");
        list.add("SpinnerDemo Example");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);

        // SpinnerDemo item selection Listener
        addListenerOnSpinnerItemSelection();

        // Button click Listener
        addListenerOnButton();



    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"SpinnerDemo : onresume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"SpinnerDemo : onPause");

    }

    @Override
    protected void onStop() {
        Log.d(TAG,"SpinnerDemo : onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"SpinnerDemo : onDestroy");
    }

    // Add spinner data

    public void addListenerOnSpinnerItemSelection(){

        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    //get the selected dropdown list value

    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(SpinnerDemo.this,
                        "On Button Click : " +
                                "\n" + String.valueOf(spinner1.getSelectedItem()) ,
                        Toast.LENGTH_LONG).show();
            }

        });

    }

    class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,
                                   long id) {

            Toast.makeText(parent.getContext(),
                    "On Item Select : \n" + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }

    }

    public void launchArrayAdapterDemo(View view){
        Intent intent = new Intent(this,CustomAdapterDemo.class);
        startActivity(intent);
    }
}
