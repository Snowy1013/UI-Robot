package org.ayo.robot.canvas.shape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

public class OvalView extends ShapeView {
    public OvalView(Context context) {
        super(context);
        init();
    }

    public OvalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OvalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public OvalView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){

    }




    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {
        RectF rectF = new RectF(50, 50, 50+rectW, 50+rectH);
        canvas.drawOval(rectF, paint);

        //画外接矩形，并回复paint
        Paint.Style oldStyle = paint.getStyle();
        float oldWidth = paint.getStrokeWidth();
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawRect(rectF, paint);

        paint.setStyle(oldStyle);
        paint.setStrokeWidth(oldWidth);
    }


    int rectW = 250;
    int rectH = 150;

    @Override
    protected void onFingerMove(int x, int y, int dx, int dy) {
        rectW += dx;
        rectH += dy;
        invalidate();
        getObservable().notifyDataChanged(this, "横半径 = " + rectW + ", 竖半径 = " + rectH);
    }

}