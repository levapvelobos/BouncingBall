package com.example.bouncingball;

import android.graphics.Canvas;
//import android.graphics.Color;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
//import android.os.Build;
//import android.support.annotation.RequiresApi;

import java.util.Random;

public class Ball
{
    private float x = 51.0f;
    private float y = 51.0f;
    private float DELTAX = 10f;
    private float DELTAY = 10f;
    private float radius = 10;
    private int width = 0;
    private int height = 0;
    private int color;

    public Ball(int width, int height)
    {
        this.width = width;
        this.height = height;

        Random R = new Random();
        DELTAX = R.nextInt(2)+15;
        DELTAY = R.nextInt(2)+15;

        radius = R.nextInt(10)+20;
        x = R.nextFloat()*(width-100) + 50; //  [0,1]*width -> [0,width-100]+50-> [50,width+50]     50     width-50
        y = R.nextFloat()*(height-100) + 50; // [0,1] => [0,height-100] => [50, height-50]

        color = getRandomColor();
    }

    public void setWidthHeight(int w, int h)
    {
        width = w;
        height = h;
    }

    private int getRandomColor()
    {
        Random R = new Random();
        return Color.argb(R.nextInt(256),R.nextInt(256),R.nextInt(256),R.nextInt(256));
    }

    public void moveCircle(Canvas canvas, Paint paint)
    {
        paint.setColor(color);

        if (x >= width-50 || x <= 50) DELTAX = -DELTAX;
        if (y >= height-50 || y <= 50) DELTAY = -DELTAY;

        canvas.drawCircle(x,y,radius,paint);
        x += DELTAX;
        y += DELTAY;
    }
}