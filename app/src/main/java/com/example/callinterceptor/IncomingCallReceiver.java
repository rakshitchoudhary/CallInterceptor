package com.example.callinterceptor;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class IncomingCallReceiver extends BroadcastReceiver {
    private static final String LOG_TAG = IncomingCallReceiver.class.getSimpleName();

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    @SuppressLint({
        "MissingPermission"
    }) // Permissions checked when app opened; just fail here if missing
    public void onReceive(Context context, Intent intent) {
        /*if (!TelephonyManager.ACTION_PHONE_STATE_CHANGED.equals(intent.getAction())) {
            Log.e(LOG_TAG, String.format("IncomingCallReceiver called with incorrect intent action: %s", intent.getAction()));
            return;
        }*/

        Log.e("Call", "Once - ");

        final String newState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if (TelephonyManager.EXTRA_STATE_RINGING.equals(newState)) {
            Log.e("Call", "Status - Incoming");
            AppPreferences.setInterceptCallsOnce(context, false);
        } else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(newState)) {
            Log.e("Call", "Status - Outgoing");
            if (AppPreferences.getInterceptCalls(context)) {
                Log.e(LOG_TAG, String.format("Call state changed to %s", newState));
                TelephonyManager tm =
                        (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                String countryCodeValue = tm.getNetworkCountryIso();
                Log.e("ISO", "Code - " + countryCodeValue.toUpperCase());

                final String phoneNumber =
                        intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.e("Outgoing", "Number - " + phoneNumber);

                if (phoneNumber != null
                        && !phoneNumber.isEmpty()
                        && !phoneNumber.equalsIgnoreCase("null")) {
                    if (AppPreferences.getInterceptCallsOnce(context)) {
                        PhoneNumberUtil util = PhoneNumberUtil.getInstance();
                        Phonenumber.PhoneNumber pn = null;
                        try {
                            pn =
                                    util.parseAndKeepRawInput(
                                            phoneNumber, countryCodeValue.toUpperCase());
                            Log.e(
                                    "Country",
                                    "Code - "
                                            + pn.getCountryCode()
                                            + ", "
                                            + util.getCountryCodeForRegion(
                                                    countryCodeValue.toUpperCase()));
                        } catch (NumberParseException e) {
                            e.printStackTrace();
                        }

                        /*if (pn.getCountryCode()
                        != util.getCountryCodeForRegion(countryCodeValue.toUpperCase())) {*/
                        Log.e(
                                "Package",
                                "Name - "
                                        + context.getPackageName());
                        try {
                            Class<?> activityClass =
                                    Class.forName("com.example.callinterceptor.OutgoingCallActivity");
                            Log.e(
                                    "Package",
                                    "Name - " + activityClass.getName());

                            TelecomManager telecomManager =
                                    (TelecomManager)
                                            context.getSystemService(Context.TELECOM_SERVICE);
                            telecomManager.endCall();

                            Intent i = new Intent();
                            i.setClassName(context, activityClass.getName());
                            i.putExtra("Calls", phoneNumber);
                            i.putExtra("Code", pn.getCountryCode());
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(i);

                            // DialerActivity.outgoingCall(phoneNumber);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else AppPreferences.setInterceptCallsOnce(context, true);
                }
            }
        }
    }
}
