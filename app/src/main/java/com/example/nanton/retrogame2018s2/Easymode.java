package com.example.nanton.retrogame2018s2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Easymode extends AppCompatActivity {
    private DrawingView drawingView;
    static Easymode activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easymode);
        drawingView = new DrawingView(this);
        drawingView.getMap(2);
        setContentView(drawingView);
        activity=this;
    }
    @Override
    protected void onPause() {
        super.onPause();
        drawingView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        drawingView.resume();
    }
}
