package com.practice.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();
            //intent.getIntExtra("INT",);


            Log.d("PowerReceiver","onReceive : "+action);
            if (action.equals(Intent.ACTION_POWER_CONNECTED)){
                powerStatus.setText("Power Connected");

            }else if(action.equals(Intent.ACTION_POWER_DISCONNECTED)){
                powerStatus.setText("Power Disconnected");
            }
        }
    }

}
