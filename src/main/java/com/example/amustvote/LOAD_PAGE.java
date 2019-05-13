package com.example.amustvote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class LOAD_PAGE extends AppCompatActivity {
private DrawerLayout drawer;
    private ActionBarDrawerToggle mtoggle;
    private FrameLayout frameLayout;
    private campaign campaign;
    TextView textView;
    String uemail;
  Examplebroadcoastreciever broad= new Examplebroadcoastreciever();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load__page);
        drawer =findViewById(R.id.drawer_layout);

        NavigationView  navigationView=findViewById(R.id.nav_view);
        campaign=new campaign();
        TextView textView=(TextView)findViewById ( R.id.pass );

        uemail=getIntent().getExtras().getString("Email");
        textView.setText ( "EMAIL" );



        mtoggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawer.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout,new report()).commit();






        //setting an onclick listener to the navigation
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nominate:
                       Intent intent=new Intent (LOAD_PAGE.this,nominees_display.class);
                       startActivity (intent);
//                        Toast.makeText ( LOAD_PAGE.this , "Nominate" , Toast.LENGTH_SHORT ).show ();
                     return true;
                    case R.id.campaign:
                        Intent inten=new Intent (LOAD_PAGE.this,post_activity.class);
                       startActivity (inten);
                        return true;
                    case R.id.vote:
                        Intent inte=new Intent (LOAD_PAGE.this,VoteActivity.class);
                        startActivity (inte);
                        return true;



                    default:
                        return false;
                }
           }
        });

        }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter= new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broad,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broad);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int x=item.getItemId();
        switch (x){
            case R.id.app:
                Toast.makeText(getApplicationContext(),"The is the App setting",Toast.LENGTH_SHORT).show();
                break;
            case R.id.privacy:
                Toast.makeText(getApplicationContext(),"under maintenance",Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Toast.makeText(getApplicationContext(),"service coming soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.vibe:
                Toast.makeText(getApplicationContext(), "service coming soon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.vote:
                Toast.makeText(getApplicationContext(),"service coming soon",Toast.LENGTH_SHORT).show();
                break;
            case R.id.post:
                Toast.makeText(getApplicationContext(),"service coming soon",Toast.LENGTH_SHORT).show();
                break;
                default:
                    return false;

        }

        return super.onOptionsItemSelected(item);
    }
    public void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout,fragment).commit();

    }

}
