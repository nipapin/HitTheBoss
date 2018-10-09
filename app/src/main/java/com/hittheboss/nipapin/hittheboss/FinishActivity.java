package com.hittheboss.nipapin.hittheboss;

import android.content.Intent;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {
    ImageView restart;
    ImageView filledStar;
    ImageView filledStar2;
    ImageView filledStar3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        restart = (ImageView) findViewById(R.id.restart);
        Intent intent = getIntent();

        String score = intent.getStringExtra("score");
        String gold = intent.getStringExtra("gold");
        String time = intent.getStringExtra("timeout");
        int final_time;
        if(!time.equals("Times Up!"))
            final_time = Integer.parseInt(time);
        else
            final_time = 0;

        TextView result = findViewById(R.id.result);


        switch(score){

            case "zero" :
                filledStar = (ImageView) findViewById(R.id.filledStar);
                filledStar.setImageResource(android.R.color.transparent);
                filledStar.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.empty_star));
                filledStar2 = (ImageView) findViewById(R.id.filledStar2);
                filledStar2.setImageResource(android.R.color.transparent);
                filledStar2.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.empty_star));
                filledStar3 = (ImageView) findViewById(R.id.filledStar3);
                filledStar3.setImageResource(android.R.color.transparent);
                filledStar3.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.empty_star));
                restart = (ImageView) findViewById(R.id.restart);
                restart.setImageResource(android.R.color.transparent);
                restart.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.time_out));
                restart.setScaleX((float) 2.0);
                restart.setScaleY((float) 1.0);
                result.setText(getString(R.string.timeout));
                break;
            case "one" :
                filledStar = (ImageView) findViewById(R.id.filledStar);
                filledStar.setImageResource(android.R.color.transparent);
                filledStar.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.filled_star));
                filledStar2 = (ImageView) findViewById(R.id.filledStar2);
                filledStar2.setImageResource(android.R.color.transparent);
                filledStar2.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.empty_star));
                filledStar3 = (ImageView) findViewById(R.id.filledStar3);
                filledStar3.setImageResource(android.R.color.transparent);
                filledStar3.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.empty_star));
                restart = (ImageView) findViewById(R.id.restart);
                restart.setImageResource(android.R.color.transparent);
                restart.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.one_star));
                restart.setScaleX((float) 2.0);
                restart.setScaleY((float) 1.0);
                result.setText(Integer.parseInt(gold)*final_time+"");
                break;
            case "two" :
                filledStar = (ImageView) findViewById(R.id.filledStar);
                filledStar.setImageResource(android.R.color.transparent);
                filledStar.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.filled_star));
                filledStar2 = (ImageView) findViewById(R.id.filledStar2);
                filledStar2.setImageResource(android.R.color.transparent);
                filledStar2.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.filled_star));
                filledStar3 = (ImageView) findViewById(R.id.filledStar3);
                filledStar3.setImageResource(android.R.color.transparent);
                filledStar3.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.empty_star));
                restart = (ImageView) findViewById(R.id.restart);
                restart.setImageResource(android.R.color.transparent);
                restart.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.two_star));
                restart.setScaleX((float) 2.0);
                restart.setScaleY((float) 1.0);
                result.setText(Integer.parseInt(gold)*2*final_time+"");
                break;
            case "three" :
                filledStar = (ImageView) findViewById(R.id.filledStar);
                filledStar.setImageResource(android.R.color.transparent);
                filledStar.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.filled_star));
                filledStar2 = (ImageView) findViewById(R.id.filledStar2);
                filledStar2.setImageResource(android.R.color.transparent);
                filledStar2.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.filled_star));
                filledStar3 = (ImageView) findViewById(R.id.filledStar3);
                filledStar3.setImageResource(android.R.color.transparent);
                filledStar3.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.filled_star));
                restart = (ImageView) findViewById(R.id.restart);
                restart.setImageResource(android.R.color.transparent);
                restart.setBackground(ContextCompat.getDrawable(FinishActivity.this, R.drawable.three_star));
                restart.setScaleX((float) 2.0);
                restart.setScaleY((float) 1.0);
                result.setText(Integer.parseInt(gold)*3*final_time+"");
                break;
        }

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartGame();
            }
        });
    }
    public void restartGame(){
        Intent gameScreen = new Intent(this, game_screen.class);
        gameScreen.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(gameScreen);
    }
}
