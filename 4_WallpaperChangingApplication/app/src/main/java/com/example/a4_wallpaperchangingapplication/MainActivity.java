package com.example.a4_wallpaperchangingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer myTimer;
    Drawable drawable;
    WallpaperManager wpm;
    int next = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTimer=new Timer();
        wpm=WallpaperManager.getInstance(this);
    }
    public void changeWallpaper(View v)
    {
        setWallPaper();
    }
    public void setWallPaper()
    {
        myTimer.schedule(new TimerTask() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void run() {
                if(next == 1)
                {
                    drawable=getResources().getDrawable(R.drawable.one);
                    next = 2;
                }
                else if(next == 2)
                {
                    drawable = getResources().getDrawable(R.drawable.two);
                    next = 3;
                }
                else if(next == 3)
                {
                    drawable = getResources().getDrawable(R.drawable.three);
                    next = 4;
                }
                else if(next == 4)
                {
                    drawable = getResources().getDrawable(R.drawable.four);
                    next = 5;
                }
                else if(next == 5)
                {
                    drawable = getResources().getDrawable(R.drawable.five);
                    next = 6;
                }
                else if(next == 6)
                {
                    drawable = getResources().getDrawable(R.drawable.six);
                    next = 7;
                }
                else if(next == 7)
                {
                    drawable = getResources().getDrawable(R.drawable.seven);
                    next = 8;
                }
                else if(next == 8)
                {
                    drawable = getResources().getDrawable(R.drawable.eight);
                    next = 9;
                }
                else if(next == 9)
                {
                    drawable = getResources().getDrawable(R.drawable.nine);
                    next = 10;
                }
                else if(next == 10)
                {
                    drawable = getResources().getDrawable(R.drawable.ten);
                    next = 1;
                }
                Bitmap img = ((BitmapDrawable)drawable).getBitmap();
                try {
                    wpm.setBitmap(img);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        },5000,10000);
    }
}