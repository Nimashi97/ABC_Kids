package com.nimashi.game;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class BrActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_br);
    }

    MyReciever myReceiver;

    public void register(View v){
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PHONE_STATE");

        myReceiver = new MyReciever();
        registerReceiver(myReceiver, filter); }

    public void unregister(View v){
        myReceiver = new MyReciever();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver); }


}
