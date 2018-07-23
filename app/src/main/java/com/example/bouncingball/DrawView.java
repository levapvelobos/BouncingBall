package com.example.bouncingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class DrawView extends View {

    ArrayList<Ball> Balls;
    private int width = 0;
    private int height = 0;
    private int count = 60;

    public DrawView(Context context) {
        super(context);
        invalidate();
        Balls = new ArrayList<>();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();

        if (Balls.size()==0)
            for(int i=1; i<=count; i++)  Balls.add(new Ball(width,height));

        for(Ball b : Balls) b.moveCircle(canvas,paint);
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = w;
        height = h;
        for(Ball b : Balls) b.setWidthHeight(w,h);
        super.onSizeChanged(w,h,oldw,oldh);
    }
}
