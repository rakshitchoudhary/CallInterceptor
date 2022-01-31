package com.example.callinterceptor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ServiceWaitThreadListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(
                    (Activity) MainActivity.this,
                    Manifest.permission.ANSWER_PHONE_CALLS)
                    != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(
                    (Activity) MainActivity.this,
                    Manifest.permission.READ_PHONE_STATE)
                    != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(
                    (Activity) MainActivity.this,
                    Manifest.permission.READ_CALL_LOG)
                    != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(
                    (Activity) MainActivity.this,
                    Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(
                    (Activity) MainActivity.this,
                    Manifest.permission.PROCESS_OUTGOING_CALLS)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermission();
            } else {
                try {
                    startService(
                            new Intent()
                                    .setClass(MainActivity.this, MainService.class));
                    new ServiceWaitThread(MainActivity.this).start();
                } catch (IllegalStateException ise) {
                    Log.e("Linphone", "Exception raised while starting service: " + ise);
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestPermission() {
        if (shouldShowRequestPermissionRationale(Manifest.permission.PROCESS_OUTGOING_CALLS)) {
            requestPermissions(
                    new String[]{
                            Manifest.permission.ANSWER_PHONE_CALLS,
                            Manifest.permission.READ_CALL_LOG,
                            Manifest.permission.CALL_PHONE,
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.PROCESS_OUTGOING_CALLS
                    },
                    1);
        } else {
            requestPermissions(
                    new String[]{
                            Manifest.permission.ANSWER_PHONE_CALLS,
                            Manifest.permission.READ_CALL_LOG,
                            Manifest.permission.CALL_PHONE,
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.PROCESS_OUTGOING_CALLS
                    },
                    1);
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    try {
                        startService(
                                new Intent()
                                        .setClass(MainActivity.this, MainService.class));
                        new ServiceWaitThread(MainActivity.this).start();
                    } catch (IllegalStateException ise) {
                        Log.e("Linphone", "Exception raised while starting service: " + ise);
                    }
                    // askRecordPermission(); // Method for enabling/disabling call record option
                } else {
                    try {
                        startService(
                                new Intent()
                                        .setClass(MainActivity.this, MainService.class));
                        new ServiceWaitThread(MainActivity.this).start();
                    } catch (IllegalStateException ise) {
                        Log.e("Linphone", "Exception raised while starting service: " + ise);
                    }
                    // askRecordPermission(); // Method for enabling/disabling call record option
                }
                break;
            case 2323:
                break;
        }
    }

    @Override
    public void onServiceReady() {

    }
}