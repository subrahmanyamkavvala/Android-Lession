package com.practice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;

public class ActivityResultDemo extends Activity {

    EditText SendingName;
    Button SendName;
    TextView HoldName;
    String Name;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_demo);

        SendingName = (EditText)findViewById(R.id.editText1);
        SendName = (Button)findViewById(R.id.button1);
        HoldName = (TextView)findViewById(R.id.textView1);

        SendName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Name = SendingName.getText().toString();
                intent = new Intent(ActivityResultDemo.this,ResultReturnActivity.class);
                intent.putExtra("name", Name);
                startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            HoldName.setText(data.getStringExtra("ActivityResult"));
        }

    }
}