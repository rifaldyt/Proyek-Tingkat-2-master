package com.example.hanifkf.lostandfound.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hanifkf.lostandfound.Fragment.HomeFragment;
import com.example.hanifkf.lostandfound.R;
import com.example.hanifkf.lostandfound.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context mContext=HomeActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: started");
        setupBottomNavigationView();
        setupFragment();
    }

    //FragmentHomesetup
    public void setupFragment(){
        Fragment homeFragment=null;
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        homeFragment= new HomeFragment();
        fragmentManager.beginTransaction().replace(R.id.content,homeFragment).commit();
    }

    //Bottom Navigation Setup
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationVIew");
        BottomNavigationViewEx bottomNavigationViewEx=(BottomNavigationViewEx)findViewById(R.id.bottom_nav_view);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext,this,bottomNavigationViewEx);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(0);
        menuItem.setChecked(true);
    }

}
