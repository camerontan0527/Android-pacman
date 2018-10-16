package com.example.nanton.retrogame2018s2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer=new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /* The method to start the game */

    public void StartGame(View view){
        Intent start = new Intent(this, GameActivity.class);
        startActivity(start);
    }
    /* The method to choose the level of  the game */
    public void Level(View view){
        Intent level = new Intent(this, LevelActivity.class);
        startActivity(level);
    }
    /* The method to see the introduction of the game */
    public void About(View view){
        Intent about = new Intent(this, AboutAcitivity.class);
        startActivity(about);
    }
    }

