package com.example.amustvote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class LOAD_PAGE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load__page);
    }

    @Override
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

}
