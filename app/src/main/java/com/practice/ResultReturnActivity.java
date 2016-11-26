package com.practice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;

public class ResultReturnActivity extends Activity {

    TextView one;
    Button Back;
    String ActivityResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_return);

        one = (TextView)findViewById(R.id.textView1);
        Back = (Button)findViewById(R.id.button1);


        Intent intent = getIntent();

        one.setText(intent.getStringExtra("name"));
        ActivityResult = getIntent().getStringExtra("name");

        Back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent BackIntent = new Intent();
                BackIntent.putExtra("ActivityResult",ActivityResult);
                setResult(RESULT_OK,BackIntent);
                finish();
            }
        });


    }
}

