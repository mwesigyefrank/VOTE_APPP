package com.example.amustvote;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

public class LOGO extends AppCompatActivity {
    private DrawerLayout mydrawer;
    private ActionBarDrawerToggle mtoggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        mydrawer =(DrawerLayout) findViewById(R.id.loadpage);
        mtoggle = new ActionBarDrawerToggle(this, mydrawer, R.string.open, R.string.close);
        mydrawer.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mtoggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
