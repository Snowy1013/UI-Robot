package org.ayo.robot.canvas.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import org.ayo.robot.canvas.shape.ShapeView;

public class PathArcView extends ShapeView {
    public PathArcView(Context context) {
        super(context);
        init();
    }

    public PathArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PathArcView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
    }

    Path mPath;

    int startX = 30;
    int startY = 0;
    int endX = 0;
    int endY = 0;

    int rectLeft = 0;
    int rectTop = 0;
    int rectRight = 0;
    int rectBottom = 0;

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {

        if(!isInited){
            startY = h/2;
            endX = startX + 250;
            endY = startY + 200;

            rectLeft = endX - 100;
            rectTop = endY - 100;
            rectRight = endX + 50;
            rectBottom = endY + 50;

            isInited = true;
        }
        mPath = new Path();
        mPath.moveTo(startX, startY);
        RectF oval = new RectF(rectLeft, rectTop, rectRight, rectBottom);
        //RectF oval = new RectF(endX, endY, endX + 100, endY + 100);
        mPath.arcTo(oval, 0, 90, true);
        canvas.drawPath(mPath, paint);

        canvas.drawRect(oval, paint);

        float oldWidth = paint.getStrokeWidth();
        paint.setStrokeWidth(7);
        canvas.drawPoint(startX, startY, paint);
        canvas.drawPoint(endX, endY, paint);

        paint.setStrokeWidth(oldWidth);
    }

    @Override
    protected void onFingerMove(int x, int y, int dx, int dy) {
        rectRight += dx;
        rectBottom += dy;
        invalidate();
    }

    private boolean isInited = false;

    public void onRectMove(int dx, int dy){
        rectLeft += dx;
        rectRight += dx;
        rectTop += dy;
        rectBottom += dy;
        invalidate();
    }

    public void onEndMove(int dx, int dy){
        endX += dx;
        endY += dy;
        invalidate();
    }
}