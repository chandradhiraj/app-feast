package com.android.appfeast.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.appfeast.R;

/**
 * Created with IntelliJ IDEA.
 * User: dhiraj
 * Date: 10/11/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstance) {

    }

}
