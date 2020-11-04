package com.nimashi.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity {
    public void Sound(View v)
    {
        Intent intent=new Intent(this,ServiceActivity.class);
        startActivity(intent);
    }
    public void Br(View v)
    {
        Intent intent=new Intent(this,BrActivity.class);
        startActivity(intent);
    }




    @Override
    protected void onCreate(Bundle bundle) // create wena welawedi wenna ona de
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my);
    }


}
