package com.practice;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MemoryLeakActivity extends AppCompatActivity {
    TextView textView;
    private static final String TAG = "MemoryLeakActivity";

    BackgroundTask myTask  = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_leak);
        textView = (TextView) findViewById(R.id.textView5);

        Log.d(TAG,"onCreate");


       ///example 1
        /*myTask = new BackgroundTask();
        myTask.execute();*/

        //example 2
       // exampleTwo();

        //exampleTwoAvoidLead
       // exampleTwoAvoidLead();

        //handler Leak
        exampleFour();

        //example Five
        //exampleFive();
    }



    private final  Handler mLeakyHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.d("","handleMessage ");
        }
    };


    private void exampleFour() {
        // Post a message and delay its execution for 10 minutes.
      mLeakyHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                try {
                    Log.d("MemoryLeakActivity","run  ");
                    Thread.sleep(5000);
                    new BackgroundTask().execute();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, 2000 );


    }


    private  static class BackgroundTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            Log.d("BackgroundTask","doInBackground");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "some string";
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d("BackgroundTask","onPostExecute : "+result);
        }
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy");

        if(myTask!=null) {
            myTask.cancel(true);
        }
        super.onDestroy();

    }

      private void exampleTwo() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    SystemClock.sleep(1000);
                }
            }
        }.start();
    }

    private void exampleTwoAvoidLead(){
        new MyThread().start();
    }
    private static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                SystemClock.sleep(1000);
            }
        }
    }



    MyThread2 mThread ;
    private void exampleThree(){
        mThread = new MyThread2();
        mThread.start();
    }


    private static class MyThread2 extends Thread {
        private boolean mRunning = false;

        @Override
        public void run() {
            mRunning = true;
            while (mRunning) {
                SystemClock.sleep(1000);
            }
        }

        public void close() {
            mRunning = false;
        }
    }





    private static Drawable sBackground;

    private void exampleFive(){
        TextView label = new TextView(this);
        label.setText("Leaks are bad");

        if (sBackground == null) {
            sBackground =getResources().getDrawable(R.drawable.small);
        }
        label.setBackgroundDrawable(sBackground);

        setContentView(label);
    }


}
