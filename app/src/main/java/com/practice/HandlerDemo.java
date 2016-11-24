package com.practice;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandlerDemo extends AppCompatActivity {

    Button btn_execute;
    TextView tv_counter;
    int counter = 0;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv_counter.setText(String.valueOf(counter));

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_demo);
        tv_counter = (TextView)findViewById(R.id.textView4);
        btn_execute = (Button) findViewById(R.id.btn_counter);

        btn_execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Counter().start();

            }
        });
    }


    class Counter extends Thread {
        @Override
        public void run() {
            super.run();
            Log.d("Counter","run");

            while (counter<100){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
                handler.sendEmptyMessage(0);
                tv_counter.setText(String.valueOf(counter));
            }

        }
    }


}
