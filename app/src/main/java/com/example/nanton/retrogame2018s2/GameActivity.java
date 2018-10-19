package com.example.nanton.retrogame2018s2;

import android.graphics.Color;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    public enum Direction{ UP,DOWN,RIGHT,LEFT}
    Direction monsDirect = Direction.DOWN;
    Direction pacDirect = Direction.RIGHT;

    ConstraintLayout ly;
    int[][] myMap;
    int blockSize;

    ImageView monster;
    int monsX = 13, monsY = 4;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ly = findViewById(R.id.myLayout);
        monster = findViewById(R.id.monster);
        newMap();
        handler.postDelayed(myRunnable, 200);
    }

    Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            updateUI();
            handler.postDelayed(myRunnable, 200);
        }
    };
    private void updateUI(){
        clearCoins();
        drawCoins();
        moveMonster();
    }
    private void moveMonster(){
        if(monsDirect==Direction.DOWN){
            if(myMap[monsX][monsY+1] == -1){
                monsDirect = Direction.UP;
                monsY = monsY - 1;
            }else{
                monsY = monsY + 1;
            }
        }else if(monsDirect==Direction.UP){
            if(myMap[monsX][monsY-1] == -1){
                monsDirect = Direction.DOWN;
                monsY = monsY + 1;
            }else{
                monsY = monsY - 1;
            }
        }
        monster.setX(blockSize*monsX);
        monster.setY(blockSize*monsY);
    }

    ArrayList<TextView> coins = new ArrayList();
    private void clearCoins(){
        for(TextView tv : coins){
            ly.removeView(tv);
        }
        coins.clear();
    }
    private void drawCoins(){
        for(int i = 0; i < Value.dividedSize; i++){
            for(int j = 0; j < Value.dividedSize; j++){
                if(myMap[i][j] == 1){
                    TextView tv = new TextView(this);
                    tv.setBackgroundColor(Color.WHITE);
                    tv.setHeight(10);
                    tv.setWidth(10);
                    tv.setX(blockSize*i + blockSize / 2 - 5);
                    tv.setY(blockSize*j + blockSize / 2 - 5);
                    coins.add(tv);
                    ly.addView(tv);
                }
            }
        }
    }

    private void newMap(){
        myMap = Value.map.clone();
        blockSize = Value.screenWidth/Value.dividedSize;
        for(int i = 0; i < Value.dividedSize; i++){
            for(int j = 0; j < Value.dividedSize; j++){
                if(myMap[i][j] == -1){
                    TextView tv = new TextView(this);
                    tv.setBackgroundColor(Color.WHITE);
                    tv.setHeight(blockSize);
                    tv.setWidth(blockSize);
                    tv.setX(blockSize*i);
                    tv.setY(blockSize*j);
                    ly.addView(tv);
                }
            }
        }
        monster.setX(blockSize*monsX);
        monster.setY(blockSize*monsY);
    }


}



