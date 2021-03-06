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

public class TwentytwoActivity extends Activity {

    public static final String EXTRA_NUMBER= "com.nimashi.game.EXTRA_NUMBER";
    TextView marks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twentytwo);
        final MediaPlayer csound = MediaPlayer.create(this, R.raw.s1);
        final MediaPlayer wsound = MediaPlayer.create(this, R.raw.incorrect);

        ImageView correct = this.findViewById(R.id.imageView6);
        ImageView wrong = this.findViewById(R.id.imageView7);
        Intent i = getIntent();
        final int score = i.getIntExtra(OneActivity.EXTRA_NUMBER, 0);

        marks = this.findViewById(R.id.textView3);
        marks.setText("Score  " + score);


        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                csound.start();
                Toasty.success(TwentytwoActivity.this, " Yes, It is a Violin ", Toast.LENGTH_SHORT).show();
                marks.setText("Score  " + String.valueOf(score + 1));
                Intent intent = new Intent(TwentytwoActivity.this, TwentythrActivity.class);
                intent.putExtra(EXTRA_NUMBER, score + 1);
                startActivity(intent);
            }
        });

        wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wsound.start();
                Toasty.error(TwentytwoActivity.this, "Try again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
