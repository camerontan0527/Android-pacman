package com.example.nanton.retrogame2018s2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void StartGame(View view){
        Intent start = new Intent(this, GameActivity.class);
        startActivity(start);
    }
    public void Level(View view){
        Intent start = new Intent(this, GameActivity.class);
        startActivity(start);
    }
    public void About(View view){
        Intent about = new Intent(this, AboutAcitivity.class);
        startActivity(about);
    }
    }

