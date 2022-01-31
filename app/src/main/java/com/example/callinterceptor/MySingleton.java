package com.example.callinterceptor;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

public class MySingleton extends Application {

    private static MySingleton mInstance;
    private static Context mCtx;

    @Override
    public void onCreate() {
        super.onCreate();
        // Log
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)
                || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public MySingleton() {
        super();
    }

    private MySingleton(Context context) {
        mCtx = context;
    }
}
