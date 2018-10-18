package com.example.nanton.retrogame2018s2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class DrawingView extends SurfaceView implements Runnable, SurfaceHolder.Callback, View.OnTouchListener {
    private Thread thread;
    private SurfaceHolder holder;
    private boolean Draw = true;
    private Paint paint;
    private int screenWidth;
    private int blockSize;
    private int level;
    final Handler handler = new Handler();
    private BitmapImages bitmap;
    private short[][] currentMap;
    private Movement movement;
    private Pacman pacman;
    private float x1, y1, x2, y2;

    public DrawingView(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        paint = new Paint();

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        screenWidth = metrics.widthPixels;
        blockSize = screenWidth / 15;
        blockSize = (blockSize / 5) * 5;
        bitmap = new BitmapImages(blockSize, context);
        currentMap = getMap(level);
        movement = new Movement(currentMap, blockSize);
        pacman = movement.getPacman();
        this.setOnTouchListener(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    @Override
    public void run() {
        while (Draw) {
            if (!holder.getSurface().isValid()) {
                continue;
            }
            Canvas canvas = holder.lockCanvas();
            if (canvas != null) {
                canvas.drawColor(Color.BLACK);
                drawMap(canvas);
                pacman.drawPacman(bitmap, canvas, movement, paint, getContext());
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public void drawMap(Canvas canvas) {
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(8.5f);
        int x;
        int y;
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 16; j++) {
                x = j * blockSize;
                y = i * blockSize;
                if ((getMap(level)[i][j] & 1) != 0) // draws left
                    canvas.drawLine(x, y, x, y + blockSize + 1, paint);

                if ((getMap(level)[i][j] & 2) != 0) // draws top
                    canvas.drawLine(x, y, x + blockSize - 1, y, paint);

                if ((getMap(level)[i][j] & 4) != 0) // draws right
                    canvas.drawLine(
                            x + blockSize, y, x + blockSize, y + blockSize - 1, paint);
                if ((getMap(level)[i][j] & 8) != 0) // draws bottom
                    canvas.drawLine(
                            x, y + blockSize, x + blockSize + 1, y + blockSize, paint);
            }
        }

    }

    public void pause() {
        Draw = false;
        thread = null;
    }

    public void resume() {
        if (thread != null) {
            thread.start();
        }
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
        Draw = true;
    }

    public short[][] getMap(int level) {
        this.level=level;
        switch (level) {
            case (1):
                return getLevel1();
            case (2):
                return getLevel2();
            case (3):
                return getLevel3();
            default:
                return getLevel1();
        }
    }

    private static short[][] getLevel1() {
        return new short[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {19, 26, 26, 18, 26, 26, 26, 26, 0, 19, 26, 26, 26, 18, 26, 26, 22},
                {21, 0, 0, 21, 0, 0, 0, 21, 0, 21, 0, 0, 0, 21, 0, 0, 21},
                {17, 26, 26, 16, 26, 18, 26, 24, 26, 24, 26, 18, 26, 16, 26, 26, 20},
                {25, 26, 26, 20, 0, 25, 26, 22, 0, 19, 26, 28, 0, 17, 26, 26, 28},
                {0, 0, 0, 21, 0, 0, 0, 21, 0, 21, 0, 0, 0, 21, 0, 0, 0},
                {0, 0, 0, 21, 0, 19, 26, 24, 26, 24, 26, 22, 0, 21, 0, 0, 0},
                {26, 26, 26, 16, 26, 20, 0, 0, 0, 0, 0, 17, 26, 16, 26, 26, 26},
                {0, 0, 0, 21, 0, 17, 26, 26, 26, 26, 26, 20, 0, 21, 0, 0, 0},
                {0, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 21, 0, 21, 0, 0, 0},
                {19, 26, 26, 16, 26, 24, 26, 22, 0, 19, 26, 24, 26, 16, 26, 26, 22},
                {21, 0, 0, 21, 0, 0, 0, 21, 0, 21, 0, 0, 0, 21, 0, 0, 21},
                {25, 22, 0, 21, 0, 0, 0, 17, 2, 20, 0, 0, 0, 21, 0, 19, 28},
                {0, 21, 0, 17, 26, 26, 18, 24, 24, 24, 18, 26, 26, 20, 0, 21, 0},
                {19, 24, 26, 28, 0, 0, 25, 18, 26, 18, 28, 0, 0, 25, 26, 24, 22},
                {21, 0, 0, 0, 0, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 21},
                {26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 28}
        };
    }

    private static short[][] getLevel2() {
        return new short[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {19, 10, 26, 18, 10, 26, 10, 22, 0, 19, 10, 26, 10, 18, 26, 10, 22},
                {21, 0, 0, 21, 0, 0, 0, 21, 0, 21, 0, 0, 0, 21, 0, 0, 21},
                {17, 26, 10, 16, 26, 18, 10, 24, 10, 24, 26, 18, 10, 16, 10, 26, 20},
                {25, 10, 10, 20, 0, 25, 26, 22, 0, 19, 26, 28, 0, 17, 26, 26, 28},
                {0, 0, 0, 5, 0, 0, 0, 21, 0, 21, 0, 0, 0, 5, 0, 0, 0},
                {0, 0, 0, 5, 0, 19, 26, 24, 26, 24, 26, 22, 0, 5, 0, 0, 0},
                {10, 10, 10, 0, 26, 20, 0, 0, 0, 0, 0, 17, 26, 0, 10, 10, 10},
                {0, 0, 0, 5, 0, 17, 26, 10, 10, 10, 26, 20, 0, 5, 0, 0, 0},
                {0, 0, 0, 5, 0, 21, 0, 0, 0, 0, 0, 21, 0, 5, 0, 0, 0},
                {19, 10, 10, 0, 10, 24, 10, 22, 0, 19, 10, 24, 10, 0, 10, 10, 22},
                {21, 0, 0, 5, 0, 0, 0, 21, 0, 21, 0, 0, 0, 5, 0, 0, 21},
                {25, 22, 0, 5, 0, 0, 0, 17, 2, 20, 0, 0, 0, 5, 0, 19, 28},
                {0, 21, 0, 1, 10, 10, 2, 12, 12, 12, 2, 10, 10, 20, 0, 21, 0},
                {19, 24, 26, 12, 0, 0, 25, 2, 10, 2, 28, 0, 0, 25, 26, 24, 22},
                {21, 0, 0, 0, 0, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 21},
                {25, 26, 10, 10, 10, 10, 10, 24, 10, 24, 10, 10, 10, 10, 10, 10, 28},
        };
    }

    private static short[][] getLevel3() {
        return new short[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 10, 10, 2, 10, 10, 10, 6, 0, 3, 10, 10, 10, 2, 10, 10, 6},
                {5, 0, 0, 5, 0, 0, 0, 5, 0, 5, 0, 0, 0, 5, 0, 0, 5},
                {1, 10, 26, 0, 10, 2, 10, 8, 10, 8, 10, 2, 10, 0, 26, 10, 4},
                {9, 10, 10, 4, 0, 9, 10, 6, 0, 3, 10, 12, 0, 1, 10, 10, 12},
                {0, 0, 0, 5, 0, 0, 0, 5, 0, 5, 0, 0, 0, 5, 0, 0, 0},
                {0, 0, 0, 5, 0, 3, 26, 8, 10, 8, 26, 6, 0, 5, 0, 0, 0},
                {10, 10, 10, 26, 10, 4, 0, 0, 0, 0, 0, 1, 10, 26, 10, 10, 10},
                {0, 0, 0, 5, 0, 1, 26, 10, 10, 10, 26, 4, 0, 5, 0, 0, 0},
                {0, 0, 0, 5, 0, 5, 0, 0, 0, 0, 0, 5, 0, 5, 0, 0, 0},
                {3, 10, 10, 0, 10, 8, 10, 6, 0, 3, 10, 8, 10, 0, 10, 10, 6},
                {5, 0, 0, 5, 0, 0, 0, 5, 0, 5, 0, 0, 0, 5, 0, 0, 5},
                {9, 6, 0, 5, 0, 0, 0, 1, 2, 4, 0, 0, 0, 5, 0, 3, 12},
                {0, 5, 0, 1, 10, 10, 2, 8, 8, 8, 2, 10, 10, 4, 0, 5, 0},
                {3, 8, 26, 12, 0, 0, 9, 2, 10, 2, 12, 0, 0, 9, 26, 8, 6},
                {5, 0, 0, 0, 0, 0, 0, 5, 0, 5, 0, 0, 0, 0, 0, 0, 5},
                {9, 10, 10, 10, 10, 10, 10, 8, 10, 8, 10, 10, 10, 10, 10, 10, 12},
        };
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
            case (MotionEvent.ACTION_DOWN):{
                x1 = motionEvent.getX();
                y1 = motionEvent.getY();
                break;
            }
            case (MotionEvent.ACTION_UP):{
                x2 = motionEvent.getX();
                y2 = motionEvent.getY();
                getTouchDirection();
                break;
            }
        }
        return true;
    }

    public void getTouchDirection(){
        if (Math.abs(x2 - x1) > Math.abs(y2 - y1)){
            if (x2 - x1 < 0)
                pacman.setNextDir(3);
            else
                pacman.setNextDir(1);
        }
        else {
            if (y2 - y1 < 0)
                pacman.setNextDir(0);
            else
                pacman.setNextDir(2);
        }
    }
}