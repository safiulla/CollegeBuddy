package com.developer.safi.collegebuddy;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.coordinatorLayout)CoordinatorLayout mCoordinatorLayout;
    @Bind(R.id.drawerLayout)DrawerLayout mDrawerLayout;
    @Bind(R.id.navigationView)NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setUpDrawerContent();



    }

    private void setUpDrawerContent() {
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        selectDrawerItem(item);
                        return true;
                    }
                });
    }

    private void selectDrawerItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_first_fragment:
                Snackbar.make(mCoordinatorLayout,"first item",Snackbar.LENGTH_LONG).show();
                break;
            case R.id.nav_sec_fragment:
                Snackbar.make(mCoordinatorLayout,"second item",Snackbar.LENGTH_LONG).show();
                break;
            case R.id.nav_third_fragment:
                Snackbar.make(mCoordinatorLayout,"third item",Snackbar.LENGTH_LONG).show();
                break;
            case R.id.nav_sub1:
                Snackbar.make(mCoordinatorLayout,"sub1 item",Snackbar.LENGTH_LONG).show();
                break;
            case R.id.nav_sub2:
                Snackbar.make(mCoordinatorLayout,"sub2 item",Snackbar.LENGTH_LONG).show();
                break;
        }
        item.setChecked(true);
        setTitle(item.getTitle());
        mDrawerLayout.closeDrawers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
