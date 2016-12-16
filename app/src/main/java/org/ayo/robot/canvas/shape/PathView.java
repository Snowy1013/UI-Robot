package org.ayo.robot.canvas.shape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

public class PathView extends ShapeView {
    public PathView(Context context) {
        super(context);
        init();
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PathView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        path = new Path();
        path.moveTo(90, 330);
        path.lineTo(150, 330);
        path.lineTo(120, 270);
        path.close();
    }

    Path path;


    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);
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
        path.close();
        invalidate();
    }
}