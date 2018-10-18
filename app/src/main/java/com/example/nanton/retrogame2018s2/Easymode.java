package com.example.nanton.retrogame2018s2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Easymode extends AppCompatActivity {

    static Easymode activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easymode);

        activity=this;
    }

}
