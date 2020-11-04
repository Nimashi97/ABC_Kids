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

public class TwentythrActivity extends Activity {

    public static final String EXTRA_NUMBER= "com.nimashi.game.EXTRA_NUMBER";
    TextView marks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twentythr);
        final MediaPlayer csound = MediaPlayer.create(this, R.raw.s1);
        final MediaPlayer wsound = MediaPlayer.create(this, R.raw.incorrect);

        ImageView correct = this.findViewById(R.id.imageView7);
        ImageView wrong = this.findViewById(R.id.imageView6);
        Intent i = getIntent();
        final int score = i.getIntExtra(OneActivity.EXTRA_NUMBER, 0);

        marks = this.findViewById(R.id.textView3);
        marks.setText("Score  " + score);


        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                csound.start();
                Toasty.success(TwentythrActivity.this, " Yes, This is a Wizard ", Toast.LENGTH_SHORT).show();
                marks.setText("Score  " + String.valueOf(score + 1));
                Intent intent = new Intent(TwentythrActivity.this, TwentyfourActivity.class);
                intent.putExtra(EXTRA_NUMBER, score + 1);
                startActivity(intent);
            }
        });

        wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wsound.start();
                Toasty.error(TwentythrActivity.this, "Try again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
