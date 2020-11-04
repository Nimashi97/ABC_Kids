package com.nimashi.game;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ServiceActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }
    public void Start(View v)
    {
        Intent intent=new Intent(this,SoundService.class);
        startService(intent);

    }
    public void Stop(View v)
    {
        Intent intent=new Intent(this,SoundService.class);
        stopService(intent);

    }


}
