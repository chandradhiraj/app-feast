package com.android.appfeast.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.ListView;
import com.android.appfeast.R;

/**
 * Created with IntelliJ IDEA.
 * User: dhiraj
 * Date: 10/11/13
 * Time: 6:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginActivity extends BaseActivity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout  ;
    private ActionBarDrawerToggle mDrawerToggle;

    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.login);
        getSupportActionBar().setTitle(getString(R.string.login_title));
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);


        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        );
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        mDrawerToggle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);
        mDrawerToggle.onConfigurationChanged(config);
    }

    public void onPostCreate(Bundle b) {
        mDrawerToggle.syncState();
        super.onPostCreate(b);

    }
}
