package com.example.myapplication;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class MySurface extends SurfaceView implements SurfaceHolder.Callback{

    public MySurface(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        /// Старт потока отрисовки
        MyThread myThread = new MyThread(getHolder());
        myThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        /// Когда изменяется размер
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        ///завершение потока отрисовки
    }
}
