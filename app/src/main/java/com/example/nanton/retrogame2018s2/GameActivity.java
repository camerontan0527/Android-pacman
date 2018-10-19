package com.example.nanton.retrogame2018s2;

import android.graphics.Color;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class GameActivity extends AppCompatActivity {
    public enum Direction{ UP,DOWN,RIGHT,LEFT}
    Direction monsDirect = Direction.DOWN;
    Direction pacDirect = null;

    ConstraintLayout ly;
    int[][] myMap;
    int blockSize;

    TextView score;
    int scoreValue = 0;
    ImageView monster;
    int monsX = 13, monsY = 4;
    ImageView pacman;
    int pacX = Value.dividedSize-2, pacY = Value.dividedSize-2;
    HashMap<String,TextView> coins = new HashMap<>();

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ly = findViewById(R.id.myLayout);
        monster = findViewById(R.id.monster);
        pacman = findViewById(R.id.pacman);
        score = findViewById(R.id.score);
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
        moveMonster();
        movePacman();
    }
    private void movePacman(){
        if(pacDirect == null){
            return;
        }else if(pacDirect == Direction.RIGHT){
            if(myMap[pacX+1][pacY] == -1){
                return;
            }else{
                pacX++;
                pacman.setX(pacX*blockSize);pacman.setY(pacY*blockSize);
                if(myMap[pacX][pacY] == 1){
                    myMap[pacX][pacY] = 0;
                    ly.removeView(coins.get(""+pacX+" "+pacY));
                    coins.remove(""+pacX+" "+pacY);
                    scoreValue = scoreValue + 10;
                }
                score.setText(""+scoreValue);
            }
        }else if(pacDirect == Direction.LEFT){
            if(myMap[pacX-1][pacY] == -1){
                return;
            }else{
                pacX--;
                pacman.setX(pacX*blockSize);pacman.setY(pacY*blockSize);
                if(myMap[pacX][pacY] == 1){
                    myMap[pacX][pacY] = 0;
                    ly.removeView(coins.get(""+pacX+" "+pacY));
                    coins.remove(""+pacX+" "+pacY);
                    scoreValue = scoreValue + 10;
                }
                score.setText(""+scoreValue);
            }
        }else if(pacDirect == Direction.UP){
            if(myMap[pacX][pacY-1] == -1){
                return;
            }else{
                pacY--;
                pacman.setX(pacX*blockSize);pacman.setY(pacY*blockSize);
                if(myMap[pacX][pacY] == 1){
                    myMap[pacX][pacY] = 0;
                    ly.removeView(coins.get(""+pacX+" "+pacY));
                    coins.remove(""+pacX+" "+pacY);
                    scoreValue = scoreValue + 10;
                }
                score.setText(""+scoreValue);
            }
        }else if(pacDirect == Direction.DOWN){
            if(myMap[pacX][pacY+1] == -1){
                return;
            }else{
                pacY++;
                pacman.setX(pacX*blockSize);pacman.setY(pacY*blockSize);
                if(myMap[pacX][pacY] == 1){
                    myMap[pacX][pacY] = 0;
                    ly.removeView(coins.get(""+pacX+" "+pacY));
                    coins.remove(""+pacX+" "+pacY);
                    scoreValue = scoreValue + 10;
                }
                score.setText(""+scoreValue);
            }
        }
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


    private void newMap(){
        myMap = Value.map.clone();
        blockSize = Value.screenWidth/Value.dividedSize;

        // add wall and coins
        for(int i = 0; i < Value.dividedSize; i++){
            for(int j = 0; j < Value.dividedSize; j++){
                if(myMap[i][j] == -1){ // add wall
                    TextView tv = new TextView(this);
                    tv.setBackgroundColor(Color.WHITE);
                    tv.setHeight(blockSize);
                    tv.setWidth(blockSize);
                    tv.setX(blockSize*i);
                    tv.setY(blockSize*j);
                    ly.addView(tv);
                }else if(myMap[i][j] == 1){ // add coins
                    TextView tv = new TextView(this);
                    tv.setBackgroundColor(Color.WHITE);
                    tv.setHeight(10);
                    tv.setWidth(10);
                    tv.setX(blockSize*i + blockSize / 2 - 5);
                    tv.setY(blockSize*j + blockSize / 2 - 5);
                    coins.put(""+i+" "+j,tv);
                    ly.addView(tv);
                }
            }
        }

        // add monster
        monster.setX(blockSize*monsX);
        monster.setY(blockSize*monsY);

        // add pacman
        pacman.setX(blockSize*pacX);
        pacman.setY(blockSize*pacY);

        // set score
        score.setText(""+scoreValue);
    }

    public void clickLeft(View v){
        pacDirect = Direction.LEFT;
    }
    public void clickRight(View v){
        pacDirect = Direction.RIGHT;
    }
    public void clickUp(View v){
        pacDirect = Direction.UP;
    }
    public void clickDown(View v){
        pacDirect = Direction.DOWN;
    }
}



