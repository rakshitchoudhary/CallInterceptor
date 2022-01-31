package com.example.callinterceptor;

import android.content.Context;
import android.preference.PreferenceManager;

/** @author itgc */
public class AppPreferences {

    public static void setIsLogin(Context ctx, boolean isLogin) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("isLogin", isLogin)
                .apply();
    }

    public static boolean getIsLogin(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean("isLogin", false);
    }

    public static void setIsVerified(Context ctx, boolean isVerified) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("isVerified", isVerified)
                .commit();
    }

    public static boolean getIsVerified(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean("isVerified", false);
    }

    public static void setUserName(Context ctx, String username) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("username", username)
                .commit();
    }

    public static String getUserName(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("username", "");
    }

    public static void setEmail(Context ctx, String email) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("email", email)
                .commit();
    }

    public static String getEmail(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("email", "");
    }

    public static void setPhone(Context ctx, String phone) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("phone", phone)
                .commit();
    }

    public static String getPhone(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("phone", "");
    }

    public static void setAddress(Context ctx, String address) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("address", address)
                .commit();
    }

    public static String getAddress(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("address", "");
    }

    public static void setZip(Context ctx, String zip) {
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putString("zip", zip).commit();
    }

    public static String getZip(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("zip", "");
    }

    public static void setUserId(Context ctx, String userid) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("userid", userid)
                .commit();
    }

    public static String getUserId(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("userid", "");
    }

    public static void setCountry(Context ctx, String country) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("country", country)
                .commit();
    }

    public static String getCountry(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("country", "");
    }

    public static String getProfilePic(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("pic", "");
    }

    public static void setProfilePic(Context ctx, String pic) {
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putString("pic", pic).commit();
    }

    public static String getToken(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("token", "");
    }

    public static void setToken(Context ctx, String token) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("token", token)
                .commit();
    }

    public static String getSessionID(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("sessionid", "");
    }

    public static void setSessionID(Context ctx, String sessionid) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("sessionid", sessionid)
                .commit();
    }

    public static String getNotiToken(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("notitoken", "");
    }

    public static void setNotiToken(Context ctx, String notitoken) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("notitoken", notitoken)
                .commit();
    }

    public static String getTokenType(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("tokentype", "");
    }

    public static void setTokenType(Context ctx, String tokentype) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("tokentype", tokentype)
                .commit();
    }

    public static String getState(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("state", "");
    }

    public static void setState(Context ctx, String state) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("state", state)
                .commit();
    }

    public static void setTitle(Context ctx, String title) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("title", title)
                .commit();
    }

    public static String getTitle(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("title", "");
    }

    public static void setGender(Context ctx, String gender) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("gender", gender)
                .commit();
    }

    public static String getGender(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("gender", "");
    }

    public static void setName(Context ctx, String uname) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("uname", uname)
                .commit();
    }

    public static String getName(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("uname", "");
    }

    public static void setFName(Context ctx, String fname) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("fname", fname)
                .commit();
    }

    public static String getFName(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("fname", "");
    }

    public static void setLName(Context ctx, String lname) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("lname", lname)
                .commit();
    }

    public static String getLName(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("lname", "");
    }

    public static void setLoginPassword(Context ctx, String login_password) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("login_password", login_password)
                .commit();
    }

    public static String getLoginPassword(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("login_password", "");
    }

    public static void setWallet(Context ctx, String wallet) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("wallet", wallet)
                .commit();
    }

    public static String getWallet(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("wallet", "");
    }

    public static void setContactType(Context ctx, String contacttype) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("contacttype", contacttype)
                .commit();
    }

    public static String getContactType(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("contacttype", "");
    }

    public static void setSIMEnabled(Context ctx, boolean simEnabled) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("simEnabled", simEnabled)
                .commit();
    }

    public static boolean getSIMEnabled(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean("simEnabled", false);
    }

    public static void setOTPVerified(Context ctx, boolean otpVerified) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("otpVerified", otpVerified)
                .apply();
    }

    public static boolean getOTPVerified(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean("otpVerified", false);
    }

    public static void setIsIncoming(Context ctx, boolean isIncoming) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("isIncoming", isIncoming)
                .commit();
    }

    public static boolean getIsIncoming(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean("isIncoming", false);
    }

    public static void setLowData(Context ctx, boolean isLowData) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("isLowData", isLowData)
                .commit();
    }

    public static boolean getLowData(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean("isLowData", false);
    }

    public static void setEmailNotifications(Context ctx, boolean notif) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("notif", notif)
                .commit();
    }

    public static boolean getEmailNotifications(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean("notif", false);
    }

    public static void setShortcutAdded(Context ctx, boolean isShortcutAdded) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("isShortcutAdded", isShortcutAdded)
                .commit();
    }

    public static boolean getShortcutAdded(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
                .getBoolean("isShortcutAdded", false);
    }

    public static void setProfileDetails(Context ctx, boolean isProfileDetails) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("isProfileDetails", isProfileDetails)
                .commit();
    }

    public static boolean getProfileDetails(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
                .getBoolean("isProfileDetails", false);
    }

    public static void setContactFirst(Context ctx, boolean isContactFirst) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("isContactFirst", isContactFirst)
                .commit();
    }

    public static boolean getContactFirst(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
                .getBoolean("isContactFirst", true);
    }

    public static void setTariffId(Context ctx, String tariffid) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("tariffid", tariffid)
                .commit();
    }

    public static String getTariffId(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("tariffid", "");
    }

    public static void setCurrency(Context ctx, String currency) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("currency", currency)
                .commit();
    }

    public static String getCurrency(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("currency", "");
    }

    public static void setIsFirstTime(Context ctx, boolean isFirstTime) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("isFirstTime", isFirstTime)
                .commit();
    }

    public static boolean getIsFirstTime(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean("isFirstTime", true);
    }

    public static void setCallScreen(Context ctx, String callscreen) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("callscreen", callscreen)
                .commit();
    }

    public static String getCallScreen(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("callscreen", "");
    }

    public static void setAddParticipant(Context ctx, String addparticipant) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("addparticipant", addparticipant)
                .commit();
    }

    public static String getAddParticipant(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("addparticipant", "");
    }

    public static void setAlwaysInternational(Context ctx, boolean always) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("always", always)
                .commit();
    }

    public static boolean getAlwaysInternational(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean("always", false);
    }

    public static void setInterceptCalls(Context ctx, boolean intercept) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("intercept", intercept)
                .commit();
    }

    public static boolean getInterceptCalls(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean("intercept", true);
    }

    public static void setInterceptCallsOnce(Context ctx, boolean interceptonce) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("interceptonce", interceptonce)
                .commit();
    }

    public static boolean getInterceptCallsOnce(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean("interceptonce", true);
    }

    public static void setLanguage(Context ctx, String lang) {
        PreferenceManager.getDefaultSharedPreferences(ctx).edit().putString("lang", lang).commit();
    }

    public static String getLanguage(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("lang", "en");
    }

    public static void setOverlay(Context ctx, String overlay) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putString("overlay", overlay)
                .commit();
    }

    public static String getOverlay(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).getString("overlay", "");
    }

    public static void setAllowRecording(Context ctx, boolean isrecordingallowed) {
        PreferenceManager.getDefaultSharedPreferences(ctx)
                .edit()
                .putBoolean("isrecordingallowed", isrecordingallowed)
                .commit();
    }

    public static boolean getAllowRecording(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
                .getBoolean("isrecordingallowed", false);
    }
}
