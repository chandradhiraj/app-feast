package com.android.appfeast.fragments;

import android.app.PendingIntent;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.android.appfeast.R;
import com.android.appfeast.service.LocationService;
import com.android.appfeast.utils.Util;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;
import eu.inmite.android.lib.dialogs.SimpleDialogFragment;

/**
 * Created with IntelliJ IDEA.
 * User: dhiraj
 * Date: 10/11/13
 * Time: 12:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class SplashFragment extends Fragment implements GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener {
    private LocationClient mLocationclient;

    public void onCreate(Bundle b) {
        super.onCreate(b);

    }

    public void onViewCreated(View view, Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        int resp = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
        if (resp == ConnectionResult.SUCCESS) {
            mLocationclient = new LocationClient(getActivity(), this, this);
            mLocationclient.connect();
        } else {
            if (!Util.isEmulator())
                SimpleDialogFragment.createBuilder(getActivity(), getFragmentManager()).setTitle(R.string.title).
                        setMessage(R.string.gps_message).show();
            else {
                Intent startIntentService = new Intent(getActivity(), LocationService.class);
                startIntentService.setAction("com.android.appfeast.pi.location");
                Location loc = new Location("custom");
                startIntentService.putExtra(LocationClient.KEY_LOCATION_CHANGED, loc);
                getActivity().startService(startIntentService);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.splash_fragment, container, false);
    }

    @Override
    public void onConnected(Bundle bundle) {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(300 * 1000)
                .setFastestInterval(300 * 1000)
                .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        Intent intent = new Intent(getActivity(), LocationService.class);
        intent.setAction("com.android.appfeast.pi.location");
        PendingIntent pi = PendingIntent.getService(getActivity(), 1, intent, 0);
        mLocationclient.requestLocationUpdates(locationRequest, pi);

        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onDisconnected() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(getActivity(), "Unable to connect to location provider", Toast.LENGTH_LONG).show();
    }
}
