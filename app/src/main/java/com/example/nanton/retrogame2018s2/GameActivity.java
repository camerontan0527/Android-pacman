package com.example.nanton.retrogame2018s2;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    ConstraintLayout ly;
    ArrayList<TextView> map = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ly = findViewById(R.id.myLayout);
        initLines();
        drawLines();

    }

    int numOfLines = 28; // modify number
    int height = 50; // modify number
    int width = 300; // modify number
    static private int[] xs = {0,
            300,
            600,
            900,
            1200,
            0,
            0,
            0,
            250,
            350,
            450,
            300,
            500,
            1200,
            900,
            600,
            300,
            0,
            0,
            300,
            50,
            600,
            350,
            0,
            300,
            600,
            350,
            700



    }; // modify number
    static private int[] ys = {0,
            0,
            0,
            0,
            0,
            150,
            200,
            0,
            0,
            0,
            0,
            350,
            650,
            1400,
            1400,
            1400,
            1400,
            1400,
            1400,
            1400,
            350,
            350,
            50,
            900,
            900,
            900,
            200,
            900


    }; // modify number

    static private int[] rots = {0,
            0,
            0,
            0,
            0,
            90,
            90,
            90,
            90,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            90,
            0,
            0,
            0,
            90,
            90




    }; // modify number

    private void initLines() {
        for (int i = 0; i < numOfLines; i++) {
            TextView tv = new TextView(this);
            tv.setBackgroundColor(Color.BLUE);
            tv.setHeight(height);
            tv.setWidth(width);
            ly.addView(tv);
            map.add(tv);
        }
    }

    private void drawLines() {
        for (int i = 0; i < numOfLines; i++) {
            TextView tv = map.get(i);
            tv.setX(xs[i]);
            tv.setY(ys[i]);
            tv.setRotation(rots[i]);
        }

    }


}



