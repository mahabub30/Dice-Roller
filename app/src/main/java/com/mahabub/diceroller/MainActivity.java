package com.mahabub.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    Button button;
    ImageView imageDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        button = findViewById(R.id.button);
        imageDice = findViewById(R.id.imageDice);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                int score = random.nextInt(6) + 1;

                startAnimation();

                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        textView1.setText(String.valueOf(score));
                        switch (score){

                            case 1:
                                imageDice.setImageResource(R.drawable.dice1);
                                break;
                            case 2:
                                imageDice.setImageResource(R.drawable.dice2);
                                break;
                            case 3:
                                imageDice.setImageResource(R.drawable.dice3);
                                break;
                            case 4:
                                imageDice.setImageResource(R.drawable.dice4);
                                break;
                            case 5:
                                imageDice.setImageResource(R.drawable.dice5);
                                break;
                            case 6:
                                imageDice.setImageResource(R.drawable.dice6);
                                break;
                        }


                    }
                },1000);




            }
        });

    }

    // Animation Function
    public void startAnimation(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageDice,"rotation",0f,360f);
        animator.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.start();
    }
}