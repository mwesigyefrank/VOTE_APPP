package com.example.amustvote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class Examplebroadcoastreciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
boolean noConnectivity=intent.getBooleanExtra(
        ConnectivityManager.EXTRA_NO_CONNECTIVITY,false
);
if(noConnectivity){
    Toast.makeText(context,"disconnected",Toast.LENGTH_SHORT).show();
}
else {
    Toast.makeText(context,"login in successful",Toast.LENGTH_SHORT).show();
}
    }
}
