package com.nimashi.game;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import es.dmoral.toasty.Toasty;

import static es.dmoral.toasty.Toasty.success;

public class OneActivity extends Activity {
    public static final String EXTRA_NUMBER= "com.nimashi.game.EXTRA_NUMBER";


    TextView marks;
    int score =1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        final MediaPlayer csound = MediaPlayer.create(this, R.raw.s1);
        final MediaPlayer wsound = MediaPlayer.create(this, R.raw.incorrect);

        ImageView correct = this.findViewById(R.id.imageView6);
        ImageView wrong = this.findViewById(R.id.imageView7);
        marks =this.findViewById(R.id.textView3);

        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                csound.start();
                Toasty.success(OneActivity.this," Yes, It is an Apple ", Toast.LENGTH_SHORT).show();
                marks.setText("Score  "+ String.valueOf(score));
                Intent intent =new Intent(OneActivity.this, TwoActivity.class);
                intent.putExtra(EXTRA_NUMBER, score);
                startActivity(intent);
            }
        });

        wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wsound.start();
                Toasty.error(OneActivity.this, "Try again",Toast.LENGTH_SHORT).show();
            }
        });

    }

  /*  public void Correct(View v)
    {
        Intent intent =new Intent(OneActivity.this, TwoActivity.class);
        Toasty.success(this, " Yes, It is an Apple ", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void Wrong(View v)
    {

        Toasty.error(this, "Try again",Toast.LENGTH_SHORT).show();

    }
*/
    @Override
    protected void onStart()
    {
        super.onStart();
      /*  SharedPreferences pref =getSharedPreferences("store",MODE_PRIVATE);
        score=pref.getInt("score",0);
        marks.setText("Score  "+ score);*/


    }
    @Override
    protected void onResume()
    {
        super.onResume();
        System.out.println("<<<<<<<< resume");
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        System.out.println("<<<<<<<< paused");
    }
    @SuppressLint("SdCardPath")
    @Override
    protected void onStop()
    {

        super.onStop();
        /* SharedPreferences.Editor editor= getSharedPreferences("store", MODE_PRIVATE).edit();
        editor.putInt("score",score);
        editor.commit();*/



    }
    @Override
    protected void onRestart()
    {
        super.onRestart();
        System.out.println("<<<<<<<< restarting");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();

    }

}
