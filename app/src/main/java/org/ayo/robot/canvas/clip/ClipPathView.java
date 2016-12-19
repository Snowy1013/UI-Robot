package org.ayo.robot.canvas.clip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import org.ayo.robot.canvas.shape.ShapeView;

public class ClipPathView extends ShapeView {
    public ClipPathView(Context context) {
        super(context);
        init();
    }

    public ClipPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClipPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClipPathView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    Path path;

    private void init(){
        path = new Path();
        path.moveTo(50, 50);
        path.lineTo(200, 200);
        path.lineTo(100, 300);
        path.close();
    }

    private boolean nowYouCanClip = true;
    private boolean isFirst = true;

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        canvas.drawPath(path, paint);

        if(nowYouCanClip || isFirst){
            canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(Color.parseColor("#55000000"));
            canvas.restore();
            nowYouCanClip = false;
            isFirst = false;
        }
    }


    @Override
    protected void onFingerMove(int x, int y, int dx, int dy) {
        path.rLineTo(dx, dy);
        invalidate();
    }

    int startX = 0;
    int startY = 0;

    @Override
    protected void onFingerDown(int x, int y) {
        startX = x;
        startY = y;
        path.reset();
        path.moveTo(x, y);
        invalidate();
    }

    @Override
    protected void onFingerUp(int x, int y) {
        super.onFingerUp(x, y);
        nowYouCanClip = true;
        invalidate();
    }
}