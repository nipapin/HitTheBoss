package com.hittheboss.nipapin.hittheboss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class startScreen extends AppCompatActivity {

    ImageView launch_game;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        launch_game = (ImageView) findViewById(R.id.startButton);

        launch_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }
        public void openNewActivity(){

        Intent game_process_screen = new Intent(this, game_screen.class);
        game_process_screen.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(game_process_screen);
    }
}
