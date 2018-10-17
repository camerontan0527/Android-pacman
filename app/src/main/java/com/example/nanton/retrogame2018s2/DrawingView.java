package com.example.nanton.retrogame2018s2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class DrawingView extends SurfaceView implements Runnable, SurfaceHolder.Callback {
    private Thread thread;
    private SurfaceHolder holder;
    private boolean Draw = true;
    private Paint paint;
    private int screenWidth;                // Width of the screen
    private int blockSize;                  // Size of a block on the map
    final Handler handler = new Handler();

    public DrawingView(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        paint = new Paint();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        screenWidth = metrics.widthPixels;
        blockSize = screenWidth/15;
        blockSize = (blockSize / 5) * 5;


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
            Canvas canvas = holder.lockCanvas();
            if (!holder.getSurface().isValid()) {
                continue;
            }
            if (canvas != null) {
                canvas.drawColor(Color.BLACK);
                drawMap(canvas);
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public void drawMap(Canvas canvas) {
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(2.5f);
        int x;
        int y;
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 16; j++) {
                x = j * blockSize;
                y = i * blockSize;
                if ((leveldata[i][j] & 1) != 0) // draws left
                    canvas.drawLine(x, y, x, y + blockSize + 1, paint);

                if ((leveldata[i][j] & 2) != 0) // draws top
                    canvas.drawLine(x, y, x + blockSize - 1, y, paint);

                if ((leveldata[i][j] & 4) != 0) // draws right
                    canvas.drawLine(
                            x + blockSize, y, x + blockSize, y + blockSize - 1, paint);
                if ((leveldata[i][j] & 8) != 0) // draws bottom
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

    final short leveldata[][] = new short[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {3, 10, 10, 2, 10, 10, 10, 6, 0,3, 10,10,10,2,10,10, 6},
            {5, 0, 0, 5, 0, 0, 0, 5, 0, 5, 0, 0, 0, 5, 0, 0, 5},
            {1,10,26, 0,10,2,10, 8,10, 8,10,2,10, 0,26,10, 4},
            {9,10,10, 4, 0, 9,10, 6, 0,3,10, 12, 0, 1,10,10, 12},
            {0, 0, 0, 5, 0, 0, 0, 5, 0, 5, 0, 0, 0, 5, 0, 0, 0},
            {0, 0, 0, 5, 0,3,26, 8,10, 8,26, 6, 0, 5, 0, 0, 0},
            {10,10,10, 26,10, 4, 0, 0, 0, 0, 0, 1,10, 26,10,10,10},
            {0, 0, 0, 5, 0, 1,26,10,10,10,26, 4, 0, 5, 0, 0, 0},
            {0, 0, 0, 5, 0, 5, 0, 0, 0, 0, 0, 5, 0, 5, 0, 0, 0},
            {3,10,10, 0,10, 8,10, 6, 0,3,10, 8,10, 0,10,10, 6},
            {5, 0, 0, 5, 0, 0, 0, 5, 0, 5, 0, 0, 0, 5, 0, 0, 5},
            {9, 6, 0, 5, 0, 0, 0, 1, 2, 4, 0, 0, 0, 5, 0,3, 12},
            {0, 5, 0, 1,10,10,2, 8, 8, 8,2,10,10, 4, 0, 5, 0},
            {3, 8,26, 12, 0, 0, 9,2,10,2, 12, 0, 0, 9, 26, 8, 6},
            {5, 0, 0, 0, 0, 0, 0, 5, 0, 5, 0, 0, 0, 0, 0, 0, 5},
            {9,10,10,10,10,10,10, 8,10, 8,10,10,10,10,10,10, 12},
    };
}