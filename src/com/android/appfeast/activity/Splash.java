package com.android.appfeast.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import com.android.appfeast.R;
import com.android.appfeast.utils.SharedPrefrenceUtil;
import com.android.appfeast.utils.Util;

/**
 * Created with IntelliJ IDEA.
 * User: Dhiraj
 * Date: 11/9/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Splash extends BaseActivity {

    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.splash);
        Util.setDensityMultiplier(this);
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Fragment f = Splash.this.getSupportFragmentManager().findFragmentById(R.id.splashFragment);
                if (null != f && f.isAdded())   {
                    f.getView().findViewById(R.id.pb).setVisibility(View.GONE);
                    finish();
                }
            }
        }, 1000 * 5);
    }
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Log.d(TAG, "Pref changed for key ["+s+"] in Splash");
        if(s.equalsIgnoreCase(SharedPrefrenceUtil.APP_LNG_VAL)) {

            Fragment f = getSupportFragmentManager().findFragmentById(R.id.splashFragment);
            if(null != f && f.isAdded()) {
                f.getView().findViewById(R.id.pb).setVisibility(View.GONE);
                finish();
            }
        }
    }

    public void finish() {
        super.finish();
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
    }



}
