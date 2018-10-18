package com.example.nanton.retrogame2018s2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapImages {

    private int spriteSize, arrowSize;
    private Bitmap pacmanUp, pacmanDown, pacmanLeft, pacmanRight;
    private Bitmap arrowUp, arrowDown, arrowLeft, arrowRight;

    public BitmapImages(int blocksize, Context context){
        spriteSize = blocksize;
        arrowSize = blocksize * 3;
        pacmanUp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pacmanUp), spriteSize, spriteSize, false);
        pacmanDown = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pacmanDown), spriteSize, spriteSize, false);
        pacmanLeft = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pacmanLeft), spriteSize, spriteSize, false);
        pacmanRight = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pacmanRight), spriteSize, spriteSize, false);
        arrowUp = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.up_white), arrowSize, arrowSize, false);
        arrowDown = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.down_white), arrowSize, arrowSize, false);
        arrowLeft = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.left_white), arrowSize, arrowSize, false);
        arrowRight = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.right_white), arrowSize, arrowSize, false);
    }

    public Bitmap getPacmanUp() {
        return pacmanUp;
    }

    public Bitmap getPacmanDown() {
        return pacmanDown;
    }

    public Bitmap getPacmanLeft() {
        return pacmanLeft;
    }

    public Bitmap getPacmanRight() {
        return pacmanRight;
    }

    public Bitmap getArrowUp() {
        return arrowUp;
    }

    public Bitmap getArrowDown() {
        return arrowDown;
    }

    public Bitmap getArrowLeft() {
        return arrowLeft;
    }

    public Bitmap getArrowRight() {
        return arrowRight;
    }

}
