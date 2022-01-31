/*
 * Copyright (c) 2010-2019 Belledonne Communications SARL.
 *
 * This file is part of linphone-android
 * (see https://www.linphone.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.example.callinterceptor;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.view.WindowManager;

public final class MainService extends Service {
    private static MainService sInstance;

    private WindowManager mWindowManager;
    private Application.ActivityLifecycleCallbacks mActivityCallbacks;
    private boolean misLinphoneContextOwned;
    private IncomingCallReceiver receiver;

    @Override
    public void onCreate() {
        super.onCreate();

        misLinphoneContextOwned = false;

        receiver = new IncomingCallReceiver();

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PHONE_STATE");
        filter.addAction(android.telephony.TelephonyManager.ACTION_PHONE_STATE_CHANGED);
        filter.addAction("android.intent.action.NEW_OUTGOING_CALL"); // further more
        registerReceiver(receiver, filter);

        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Service", "Started");
        return START_STICKY;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
    }

    @Override
    public void onDestroy() {
        android.util.Log.e("Linphone", "Receiver - Destroy");
        unregisterReceiver(receiver);

        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static boolean isReady() {
        return sInstance != null;
    }

    public static MainService instance() {
        if (isReady()) return sInstance;

        throw new RuntimeException("MainService not instantiated yet");
    }
}
