package com.example.nanton.retrogame2018s2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {
    private Drawing drawingView;
    static GameActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        drawingView = new Drawing(this);
        setContentView(drawingView);
        activity=this;

    }
}
