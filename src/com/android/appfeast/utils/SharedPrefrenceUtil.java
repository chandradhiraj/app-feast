package com.android.appfeast.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created with IntelliJ IDEA.
 * User: dhiraj
 * Date: 10/11/13
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class SharedPrefrenceUtil {

    public static final String APP_LAT_VAL = "app_lat_val";
    public static final String APP_LNG_VAL = "app_lng_val";
    public static final String PREF_NAME = "com.android.appfeast";

    public static void setLocation(double lat, double lng, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(APP_LAT_VAL,  ""+lat);
        editor.putString(APP_LNG_VAL, ""+lng);
        editor.commit();
    }

    public static double [] getLocation(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        double [] loc = new double[2];
        loc[0] = Double.parseDouble(pref.getString(APP_LAT_VAL, "0"));
        loc[1] = Double.parseDouble(pref.getString(APP_LNG_VAL, "0"));
        return loc;
    }
}
