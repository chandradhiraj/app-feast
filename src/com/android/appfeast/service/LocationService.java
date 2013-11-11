package com.android.appfeast.service;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import com.android.appfeast.utils.SharedPrefrenceUtil;
import com.android.appfeast.utils.Util;
import com.google.android.gms.location.LocationClient;

/**
 * Created with IntelliJ IDEA.
 * User: dhiraj
 * Date: 09/11/13
 * Time: 11:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class LocationService extends IntentService {

    private String TAG = this.getClass().getSimpleName();

    public LocationService() {
        super("Fused Location");
    }

    public LocationService(String name) {
        super("Fused Location");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent.getAction().equalsIgnoreCase("com.android.appfeast.pi.location")) {
            if (Util.isEmulator()) {
                ComponentName myService = new ComponentName(this, this.getClass());
                try {
                    Bundle data = getPackageManager().getServiceInfo(myService, PackageManager.GET_META_DATA).metaData;
                    String latlng = data.getString("emulator_location");
                    String[] latlngarray = latlng.split(",");
                    Location location = intent.getParcelableExtra(LocationClient.KEY_LOCATION_CHANGED);
                    location.setLatitude(Double.parseDouble(latlngarray[0]));
                    location.setLongitude(Double.parseDouble(latlngarray[1]));
                    Log.i(TAG, "onHandleIntent for emu " + location.getLatitude() + "," + location.getLongitude());
                    SharedPrefrenceUtil.setLocation(location.getLatitude(), location.getLongitude(), this);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            } else {
                Location location = intent.getParcelableExtra(LocationClient.KEY_LOCATION_CHANGED);
                if (location != null) {
                    Log.i(TAG, "onHandleIntent " + location.getLatitude() + "," + location.getLongitude());
                    SharedPrefrenceUtil.setLocation(location.getLatitude(), location.getLongitude(), this);
                }
            }
        }
    }

}