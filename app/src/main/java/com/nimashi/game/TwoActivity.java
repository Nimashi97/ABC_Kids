package com.nimashi.game;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;


public class TwoActivity extends Activity {

    public static final String EXTRA_NUMBER= "com.nimashi.game.EXTRA_NUMBER";
    TextView marks;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        final MediaPlayer csound = MediaPlayer.create(this, R.raw.s1);
        final MediaPlayer wsound = MediaPlayer.create(this, R.raw.incorrect);

        ImageView correct = this.findViewById(R.id.imageView7);
        ImageView wrong = this.findViewById(R.id.imageView6);
        Intent i =getIntent();
        final int score=i.getIntExtra(OneActivity.EXTRA_NUMBER,0);

         marks =this.findViewById(R.id.textView3);
        marks.setText("Score  " + score);


        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                csound.start();
                Toasty.success(TwoActivity.this," Yes, It is a Ball ", Toast.LENGTH_SHORT).show();
                marks.setText("Score  "+ String.valueOf(score+1));
                Intent intent =new Intent(TwoActivity.this, ThreeActivity.class);
                intent.putExtra(EXTRA_NUMBER, score+1);
                startActivity(intent);
            }
        });

        wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wsound.start();
                Toasty.error(TwoActivity.this, "Try again",Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*
    public void Correct(View v)
    {
        Intent i =new Intent(TwoActivity.this,ThreeActivity.class);
        Toasty.success(this, " Yes, It is a Ball ", Toast.LENGTH_SHORT).show();
        startActivity(i);
    }

    public void Wrong(View v)
    {

        Toasty.error(this, "Try again",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        SharedPreferences pref =getSharedPreferences("store",MODE_PRIVATE);
        score=pref.getInt("score",score);
        marks.setText("Score  "+ score);


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
        SharedPreferences.Editor editor= getSharedPreferences("store", MODE_PRIVATE).edit();
        editor.putInt("score",score);
        editor.commit();


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
        System.out.println("<<<<<<<< destroyed");
    }
*/
}
