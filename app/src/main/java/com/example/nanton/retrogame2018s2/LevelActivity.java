package com.example.nanton.retrogame2018s2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
    }
    public void EasyMode(View view){
        Intent EM = new Intent(this, Easymode.class);
        startActivity(EM);
    }
    public void HardMode(View view){
        Intent HM = new Intent(this, Hardmode.class);
        startActivity(HM);
    }
}
