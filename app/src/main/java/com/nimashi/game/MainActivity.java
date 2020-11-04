package com.nimashi.game;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle SavedInstanceState)
    {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Start(View v)
    {
        Intent intent =new Intent(MainActivity.this, OneActivity.class);
        startActivity(intent);
    }
    public void Set(View v)
    {
        Intent intent =new Intent(MainActivity.this, MyActivity.class);
        startActivity(intent);
    }


}
