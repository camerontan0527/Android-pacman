package com.example.nanton.retrogame2018s2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Pacman {

    private int xPos, yPos, currentDir, nextDir;

    public Pacman(int blockSize){
        xPos = 8 * blockSize;
        yPos = 13 * blockSize;
        currentDir = 1;
        nextDir = -1;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getCurrentDir() {
        return currentDir;
    }

    public int getNextDir() {
        return nextDir;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos){
        this.yPos = yPos;
    }

    public void setCurrentDir(int currentDir){
        this.currentDir = currentDir;
    }

    public void setNextDir(int nextDir) {
        this.nextDir = nextDir;
    }

    public void drawPacman(BitmapImages bitmap, Canvas canvas, Movement movement, Paint p, Context context){
        movement.movePacman();
        if (this.getCurrentDir() == 0)
            canvas.drawBitmap(bitmap.getPacmanUp(), this.getxPos(), this.getyPos(), p);
        else if (this.getCurrentDir() == 1)
            canvas.drawBitmap(bitmap.getPacmanRight(), this.getxPos(), this.getyPos(), p);
        else if (this.getCurrentDir() == 2)
            canvas.drawBitmap(bitmap.getPacmanDown(), this.getxPos(), this.getyPos(), p);
        else if (this.getCurrentDir() == 3)
            canvas.drawBitmap(bitmap.getPacmanLeft(), this.getxPos(), this.getyPos(), p);
        movement.updatePacman();
    }
}
