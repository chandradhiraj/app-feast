package com.android.appfeast.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import com.android.appfeast.utils.SharedPrefrenceUtil;

/**
 * Created with IntelliJ IDEA.
 * User: Dhiraj
 * Date: 11/9/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseActivity extends ActionBarActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    public final String TAG = getClass().getSimpleName();
    public void onCreate(Bundle savedInstace) {
        super.onCreate(savedInstace);
        getSharedPreferences(SharedPrefrenceUtil.PREF_NAME, Context.MODE_PRIVATE).registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Log.d(TAG, "Pref changed for key ["+s+"]");
    }
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
        getSharedPreferences(SharedPrefrenceUtil.PREF_NAME, Context.MODE_PRIVATE).unregisterOnSharedPreferenceChangeListener(this);

    }
}
