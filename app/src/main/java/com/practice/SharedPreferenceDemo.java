package com.practice;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.practice.common.StorageUtil;

import org.w3c.dom.Text;

public class SharedPreferenceDemo extends AppCompatActivity {

    Button save,show,remove;
    TextView desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shared_preference_demo);

        save = (Button)findViewById(R.id.pref_save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //savePreferences();
                //saveInternal("this is text been stored in intarnal stoareage");
               /* saveExternal("this is text been stored in intarnal stoareage " +
                        "this is text been stored in intarnal stoareage" +
                        "this is text been stored in intarnal stoareage" +
                        "this is text been stored in intarnal stoareage" +
                        "this is text been stored in intarnal stoareage" +
                        "this is text been stored in intarnal stoareage" +
                        "this is text been stored in intarnal stoareage" +
                        "this is text been stored in intarnal stoareage" +
                        "");*/


                saveBitmap();

            }
        });


        show = (Button)findViewById(R.id.sr_show);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPreferences();
            }
        });

        remove = (Button)findViewById(R.id.remove);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeKey();
            }
        });


        desc = (TextView)findViewById(R.id.st_desc);
        desc.setText("Student Description :");



    }




    private void savePreferences(){

        SharedPreferences pref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();


/**************** Storing data as KEY/VALUE pair *******************/


        editor.putInt("ST_ID", 1247);        // Saving integer
        editor.putString("ST_NAME", "john");    // Saving float
        editor.putLong("ST_GPA", 979787887);      // Saving long
        editor.putString("ST_COURCE", "Computers");  // Saving string

        // Save the changes in SharedPreferences
        editor.commit(); // commit changes

    }

    private void getPreferences(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
       int st_iud =  pref.getInt("ST_ID",-1);        // Saving integer
        String st_name = pref.getString("ST_NAME", null);    // Saving float
        long st_gpa = pref.getLong("ST_GPA", 0);      // Saving long
        String st_courcce = pref.getString("ST_COURCE", null);  // Saving string

        StringBuilder st_details = new StringBuilder("ST_ID : ");
        st_details.append(st_iud);
        st_details.append("ST_NAME :"+st_name);
        st_details.append("ST_GPA "+st_gpa);
        st_details.append("ST_COURCE:"+st_courcce);

        Log.d("SharedPreferences",st_details.toString());
        desc.setText(st_details.toString());

        /*String s1 = new String("abc");
        String concat = s1.concat("xyz");

        String s2 = "hello";
        String s4 = new String("hello");

        String s5 = "hello";*/


        // s2==s4 //false
      //  s2 == s5 // true



    }



    private void removeKey(){

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.remove("ST_ID");
        editor.remove("ST_NAME");
        editor.remove("ST_GPA");
        editor.remove("ST_COURCE");


        // Save the changes in SharedPreferences
        editor.commit(); // commit changes
    }


    private void saveInternal(String data ){

        StorageUtil storageUtil = new StorageUtil(this);
        storageUtil.savaTointarnalStorage(data);
    }

    private void saveExternal(String data ){

        StorageUtil storageUtil = new StorageUtil(this);
        storageUtil.saveToExtarnalStorage(data);
    }

    private void saveBitmap(){
        StorageUtil storageUtil = new StorageUtil(this);
        Bitmap icon = BitmapFactory.decodeResource(getResources(),
                R.drawable.small);
        storageUtil.saveImage(icon);
    }

}
