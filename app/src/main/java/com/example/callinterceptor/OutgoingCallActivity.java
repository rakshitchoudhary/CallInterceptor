package com.example.callinterceptor;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.util.Locale;

public class OutgoingCallActivity extends AppCompatActivity {

    String code = "", number = "", country = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outgoingcallactivity);

        if (getIntent() != null) {
            Log.e("Intent", "Not Null");
            number = getIntent().getStringExtra("Calls");
            code = String.valueOf(getIntent().getIntExtra("Code", 0));

            PhoneNumberUtil util = PhoneNumberUtil.getInstance();
            util.getRegionCodeForCountryCode(Integer.parseInt(code));

            Locale l = new Locale("", util.getRegionCodeForCountryCode(Integer.parseInt(code)));
            country = l.getDisplayCountry();

            // Log.e("Outgoing", "Call - " + number + ", Country - " + country);
            if (AppPreferences.getAlwaysInternational(OutgoingCallActivity.this)) {
                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(
                        new Runnable() {
                            @Override
                            public void run() {
                                //Place calls here
                                finish();
                            }
                        },
                        1000);
            } else {
                outgoingDialog();
            }
        } else Log.e("Intent", "Is Null");
    }

    private void outgoingDialog() {
        final Dialog dialog = new Dialog(OutgoingCallActivity.this);
        // Include dialog.xml file
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.outgoingdialog);
        dialog.getWindow()
                .setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView txt_title = dialog.findViewById(R.id.txt_title);
        TextView txt_title_msg = dialog.findViewById(R.id.txt_title_msg);
        TextView txt_amount = dialog.findViewById(R.id.txt_amount);
        Button btn_yes = dialog.findViewById(R.id.btn_yes);
        Button btn_no = dialog.findViewById(R.id.btn_no);
        final CheckBox chk_always = dialog.findViewById(R.id.chk_always);
        RelativeLayout rel_always = dialog.findViewById(R.id.rel_always);

        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String countryCodeValue = tm.getNetworkCountryIso();

        final String phoneNumber = number;
        Log.e("Outgoing", "Number - " + phoneNumber);

        if (phoneNumber != null
                && !phoneNumber.isEmpty()
                && !phoneNumber.equalsIgnoreCase("null")) {
            PhoneNumberUtil util = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber pn = null;
            try {
                pn = util.parseAndKeepRawInput(phoneNumber, countryCodeValue.toUpperCase());
                Log.e(
                        "Country",
                        "Code - "
                                + pn.getCountryCode()
                                + ", "
                                + util.getCountryCodeForRegion(countryCodeValue.toUpperCase()));
            } catch (NumberParseException e) {
                e.printStackTrace();
            }

            if (pn.getCountryCode()
                    != util.getCountryCodeForRegion(countryCodeValue.toUpperCase())) {
                txt_title.setText(getString(R.string.inter_title));
            } else txt_title.setText(getString(R.string.inter_local_title));
        }

        rel_always.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chk_always.performClick();
                    }
                });

        txt_title_msg.setText(
                Html.fromHtml(
                        "Call <font color='#1A7BF9'>"
                                + number
                                + "</font> in <font color='#1A7BF9'>"
                                + country
                                + "</font> with VR Mobi?"));
        txt_amount.setText("3 mins left");
        txt_amount.setVisibility(View.GONE);

        btn_yes.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("Outgoing", "Call - " + number + ", Country - " + country);
                        dialog.dismiss();

                        //Place calls
                        finish();
                    }
                });

        btn_no.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        AppPreferences.setInterceptCallsOnce(OutgoingCallActivity.this, false);
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + number));
                        startActivity(intent);
                        finish();
                    }
                });

        chk_always.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked)
                            AppPreferences.setAlwaysInternational(OutgoingCallActivity.this, true);
                        else
                            AppPreferences.setAlwaysInternational(OutgoingCallActivity.this, false);
                        Log.e("Always", "Check - " + isChecked);
                    }
                });

        dialog.show();
    }
}
