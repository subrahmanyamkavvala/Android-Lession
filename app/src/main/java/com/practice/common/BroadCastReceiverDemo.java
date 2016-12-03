package com.practice.common;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.R;

public class BroadCastReceiverDemo extends AppCompatActivity {

    public static TextView powerStatus = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_receiver);
        powerStatus = (TextView)findViewById(R.id.textView3);
        powerStatus.setText("Power Status");
    }


    public static class PowerChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, Intent intent) {

            String action = intent.getAction();
            //intent.getIntExtra("INT",);


            Log.d("PowerReceiver","onReceive : "+action);
            if (action.equals(Intent.ACTION_POWER_CONNECTED)){
                powerStatus.setText("Power Connected");

            }else if(action.equals(Intent.ACTION_POWER_DISCONNECTED)){
                powerStatus.setText("Power Disconnected");
            }
            AlertDialog alertDialog = new AlertDialog.Builder(context.getApplicationContext()).create();

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
                    Toast.makeText(context, "You clicked on OK", Toast.LENGTH_LONG).show();
                }
            });

            // Showing Alert Message
            alertDialog.show();
            // alertDialog.cancel();
        }
    }

}
