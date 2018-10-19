package com.example.nanton.retrogame2018s2;
/*Author :Weinan Zhang
UniID:U5687862
 */

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutAcitivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_acitivity);
        MainActivity.getPlayer().start();
    }


}
