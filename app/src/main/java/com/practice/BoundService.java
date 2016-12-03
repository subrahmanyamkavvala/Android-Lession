package com.practice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;

/**
 * Created by inskavvala on 11/28/2016.
 */

public class BoundService extends Service {

    private static String LOG_TAG = "BoundService";
    private IBinder mBinder = new MyBinder();


    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(LOG_TAG, "in onCreate");


    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(LOG_TAG, "in onBind");
        return mBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.v(LOG_TAG, "in onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(LOG_TAG, "in onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(LOG_TAG, "in onDestroy");

    }


    public int add(int number1, int number2) {
        Log.v(LOG_TAG, "add");

        return number1 + number2;
    }

    public class MyBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }
    }
}
