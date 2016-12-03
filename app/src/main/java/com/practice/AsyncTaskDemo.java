package com.practice;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.Toast;

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

            while(progress<=15) {
                try {
                    Thread.sleep(1000);
                    progress++;
                    publishProgress(progress);
                    //handl.
                    //handl.sen )_

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        return "task compleated";

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //tv.setText(result)
            Log.d("DownloadTask","onPostExecute : "+s);

            AlertDialog alertDialog = new AlertDialog.Builder(AsyncTaskDemo.this).create();

            // Setting Dialog Title
            alertDialog.setTitle("Alert Dialog");

            // Setting Dialog Message
            alertDialog.setMessage("Welcome to Dialog sample..");

            // Setting Icon to Dialog
            alertDialog.setIcon(R.drawable.small);

            // Setting OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to execute after dialog closed
                    Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_LONG).show();
                }
            });

            // Showing Alert Message
            alertDialog.show();
            // alertDialog.cancel();
        }
    }
}
