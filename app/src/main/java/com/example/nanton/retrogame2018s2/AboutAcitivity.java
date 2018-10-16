package com.example.nanton.retrogame2018s2;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutAcitivity extends AppCompatActivity {

    private static MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_acitivity);
        mediaPlayer=MediaPlayer.create(this,R.raw.pacmanmusic);
        mediaPlayer.setVolume(100,100);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
}
