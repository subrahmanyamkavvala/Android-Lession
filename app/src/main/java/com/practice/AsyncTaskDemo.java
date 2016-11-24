package com.practice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

public class AsyncTaskDemo extends AppCompatActivity {

    String TAG = "";

    SeekBar seekBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        seekBar = (SeekBar)findViewById(R.id.seekBar2);
        seekBar.setProgress(30);
        new DownloadTask().execute();
    }


    class  DownloadTask extends AsyncTask<Void,Integer,String>{

        private int progress = 0;
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d("DownloadTask","onprogressUopdate"+values[0]);
            seekBar.setProgress(values[0]);
        }

        @Override
        protected String doInBackground(Void... voids) {
            Log.d("DownloadTask","doinprogress");

            while(progress<=100) {
                try {
                    Thread.sleep(1000);
                    progress++;
                    publishProgress(progress);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        return "task compleated";

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("DownloadTask","onPostExecute : "+s);
        }
    }
}
