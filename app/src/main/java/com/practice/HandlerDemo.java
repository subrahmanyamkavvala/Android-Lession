package com.practice;

import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
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
            int local_counter = msg.arg1;

            super.handleMessage(msg);
            Log.d("Handler","thread name"+Thread.currentThread().getName());
            Log.d("Handler","WHAT : "+msg.what);
            Log.d("Handler","ARG! : "+msg.arg1);
            Log.d("Handler","ARG2 : "+msg.arg2);
            Log.d("Handler","OBJ : "+msg.obj);


            tv_counter.setText(msg.obj+String.valueOf(local_counter));

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
            Log.d("Counter","run"+Thread.currentThread().getName() );
         //http;;
        ///  images 50 sec
            // main 50n
            // main can 10 long runng
            while (counter<100){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;

              // Message msg = handler.obtainMessage(100,counter,20);
                Message ms1 = new Message();
                ms1.what = 100;
                ms1.arg1 = counter;
                ms1.arg2 = 20;
                ms1.obj= "hello";

               handler.sendMessage(ms1);
                handler.removeCallbacks(null);
                //tv_counter.setText(String.valueOf(counter));
            }

        }
    }


}
