package com.android.appfeast.utils;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;

/**
 * Created with IntelliJ IDEA.
 * User: dhiraj
 * Date: 09/11/13
 * Time: 8:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    private static float mDensityMultiplier;

    public static float getDensityMultiplier() {
         return mDensityMultiplier;
    }
    public static void setDensityMultiplier(Activity activity) {
        if (Util.mDensityMultiplier == 0.0f) {
            DisplayMetrics metrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
            Util.mDensityMultiplier = metrics.scaledDensity;
        }
    }
    public static boolean isEmulator() {
        return Build.FINGERPRINT.contains("generic");
    }

}
