package com.example.neslihan.fotune;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView ;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView [] imageArray;
    Handler handler;
    Runnable runnable;
    TextView textView;
    MediaPlayer ply;

    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;
    AnimationDrawable animationDrawable2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageView10 = (ImageView) findViewById(R.id.imageView10);
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        imageView12 = (ImageView) findViewById(R.id.imageView12);
        imageView13 = (ImageView) findViewById(R.id.imageView13);
        textView = (TextView)findViewById(R.id.textView);

        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);
        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(3500);
        animationDrawable.setExitFadeDuration(3500);
        animationDrawable.start();


    }

    public void baslat(View view){
        ply = MediaPlayer.create(MainActivity.this,R.raw.song);
        ply.start();
        imageView = findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageView10 = (ImageView) findViewById(R.id.imageView10);
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        imageView12 = (ImageView) findViewById(R.id.imageView12);
        imageView13 = (ImageView) findViewById(R.id.imageView13);
        textView = (TextView)findViewById(R.id.textView);

        imageArray = new ImageView[]{ imageView2, imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13};



        hideImages();

        new CountDownTimer(1800,150){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                textView = (TextView) findViewById(R.id.textView);
                textView.setText("Bugün piyango oynamalısın.");
                handler.removeCallbacks(runnable);
                for(ImageView image : imageArray)
                {
                    image.setVisibility(View.INVISIBLE);
                }
                imageView13.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);

            }
        }.start();
    }

    public void hideImages() {
        imageView.setVisibility(View.INVISIBLE);
        handler = new Handler();
        runnable = new Runnable() {
            int i = 0;
            @Override
            public void run() {
                for (ImageView image : imageArray)
                {
                    image.setVisibility(View.INVISIBLE);
                }

                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this, 150);
                i++;
            }
        };

        handler.post(runnable);

    }

}
