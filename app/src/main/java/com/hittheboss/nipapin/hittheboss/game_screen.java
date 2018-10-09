package com.hittheboss.nipapin.hittheboss;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class game_screen extends AppCompatActivity {

    private ImageView scaryMonster;
    private TextView time;
    private int counter = 15;
    private CountDownTimer count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_screen);

        scaryMonster = findViewById(R.id.scary_monster);
        scaryMonster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doGame();
                time = findViewById(R.id.timer);
                    count = new CountDownTimer(counter * 1000, 1000) {
                    @Override
                    public void onTick(long l) {
                        time.setText("" + l/1000);
                    }

                    @Override
                    public void onFinish() {
                        TextView goldValue = (TextView) findViewById(R.id.goldNum);
                        time.setText(getString(R.string.times_up));
                        TextView hpValue = (TextView) findViewById(R.id.startHP_enemy);
                        int hpValueDigit = Integer.parseInt(hpValue.getText().toString());
                        if(hpValueDigit == 0) {
                            count = null;
                        } else {
                            Intent intent = new Intent(game_screen.this, FinishActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            intent.putExtra("score", "zero");
                            intent.putExtra("gold", goldValue.getText().toString());
                            intent.putExtra("timeout", time.getText().toString());
                            startActivity(intent);
                        }

                    }
                }.start();
                scaryMonster.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doGame();
                    }
                });
            }
        });
    }
    @SuppressLint("SetTextI18n")
    private void doGame(){

        TextView goldValue = (TextView) findViewById(R.id.goldNum);
        TextView damage = (TextView) findViewById(R.id.current_damage);
        ViewGroup hpBar = (ViewGroup) findViewById(R.id.hp_enemy_bar);
        TextView hpValue = (TextView) findViewById(R.id.startHP_enemy);
        int hpValueNum = Integer.parseInt(hpValue.getText().toString());
        int damageNum = Integer.parseInt(damage.getText().toString());

        int goldValueNum = Integer.parseInt(goldValue.getText().toString());
        goldValueNum+=damageNum;
        goldValue.setText(goldValueNum+"");

        if(hpValueNum-damageNum == 0) {

            hpValue.setText(0 + "");
            scaryMonster.setClickable(false);

            Intent intentKill = new Intent(game_screen.this, FinishActivity.class);
            intentKill.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            TextView timer = findViewById(R.id.timer);

            String output;
            int check = Integer.parseInt(timer.getText().toString());
            if(check <= 15 && check >= 12 ) {
                output = "three";
            }else if(check <=11 && check >= 5){
                output = "two";
            }else{
                output = "one";
            }
            intentKill.putExtra("gold", goldValue.getText().toString());
            intentKill.putExtra("score", output);
            intentKill.putExtra("timeout", time.getText().toString());
            startActivity(intentKill);

        }else {
            hpValue.setText((hpValueNum - damageNum) + "");
            float currentScale = hpBar.getScaleX();
            double delta = (double) 1/(1000/40);
            hpBar.setScaleX((float) (currentScale-delta));
        }

    }
}
