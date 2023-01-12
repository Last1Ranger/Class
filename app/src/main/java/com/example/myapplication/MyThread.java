package com.example.myapplication;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.GRAY;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import java.util.Random;

public class MyThread extends Thread{

    private final Paint paint;

    private final SurfaceHolder surfaceHolder;

    private long redrawTime;

    MyThread(SurfaceHolder holder){
        this.surfaceHolder = holder;
        paint = new Paint();
        paint.setColor(RED);
        paint. setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    public long getTime(){
        return System.nanoTime()*10000;
    }

    public void drawCircle(Canvas canvas){
        Random r = new Random();
        int x = r.nextInt(1000);
        int y = r.nextInt(10000);
        canvas.drawColor(Color.parseColor("#000000"));
        canvas.drawCircle(x,y,(float)(500 * Math.random()), paint);
        paint.setColor(Color.rgb(r.nextInt(225),r.nextInt(225),r.nextInt(225)));
        x = r.nextInt(1000);
        y = r.nextInt(10000);
        canvas.drawCircle(x,y,(float)(500 * Math.random()), paint);
        paint.setColor(Color.rgb(r.nextInt(225),r.nextInt(225),r.nextInt(225)));
        x = r.nextInt(1000);
        y = r.nextInt(10000);
        canvas.drawCircle(x,y,(float)(500 * Math.random()), paint);
        paint.setColor(Color.rgb(r.nextInt(225),r.nextInt(225),r.nextInt(225)));
        x = r.nextInt(1000);
        y = r.nextInt(10000);
        canvas.drawCircle(x,y,(float)(500 * Math.random()), paint);

    }



    @Override
    public void run() {
        Canvas canvas;
        while (true){
            long currentTime = getTime();
            long elapsedTime = currentTime - redrawTime;
            if (elapsedTime < 500000 ){
                continue;
            }
            canvas = surfaceHolder.lockCanvas();
            drawCircle(canvas);
            surfaceHolder.unlockCanvasAndPost(canvas);
            redrawTime = getTime();
        }

    }}

