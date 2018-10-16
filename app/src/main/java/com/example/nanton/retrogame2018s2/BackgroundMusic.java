package com.example.nanton.retrogame2018s2;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;



public class BackgroundMusic extends Service {
    MediaPlayer mediaPlayer;

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override

    public void onCreate() {
        super.onCreate();
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100, 100);
        mediaPlayer.start();
    }

    @Override

    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

}
