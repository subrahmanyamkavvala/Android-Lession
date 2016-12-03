package com.practice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ServiceDemoActivity extends AppCompatActivity {


    BoundService mBoundService;
    boolean mServiceBound = false;
    TextView srv_sum;
    Button srv_start;
    Button srv_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);
         srv_sum = (TextView) findViewById(R.id.srv_sum);
         srv_start = (Button) findViewById(R.id.srv_start);
         srv_add = (Button) findViewById(R.id.srv_add);

        srv_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   startBoundSetvice();

            }
        });

        srv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = mBoundService.add(100,200);
                srv_sum.setText("Sum is : "+sum);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        unBindBoundService();

    }


    private void startBoundSetvice(){
        Intent intent = new Intent(this, BoundService.class);
        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private void unBindBoundService(){
        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
        Intent intent = new Intent(ServiceDemoActivity.this,
                BoundService.class);
        stopService(intent);
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }
    };
}
