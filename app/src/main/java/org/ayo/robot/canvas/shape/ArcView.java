package org.ayo.robot.canvas.shape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class ArcView extends ShapeView {
    public ArcView(Context context) {
        super(context);
        init();
    }

    public ArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ArcView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(onClickCanceled) {
                    onClickCanceled = false;
                    return;
                }
                useCenter = !useCenter;
                invalidate();
                getObservable().notifyDataChanged(this, "起始角 = " + startAngle + ", 跨度 = " + sweepAngle + ", " + (useCenter ? "扇形" : "弧线"));
            }
        });
    }

    private int startAngle = 0;
    private int sweepAngle = 90;
    private boolean useCenter = true;

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {
        RectF rectF = new RectF(10, 10, 200, 200);
        canvas.drawArc(rectF, startAngle, sweepAngle, useCenter, paint);
        //drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)

        //画外接矩形，并回复paint
        Paint.Style oldStyle = paint.getStyle();
        float oldWidth = paint.getStrokeWidth();
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawRect(rectF, paint);

        paint.setStyle(oldStyle);
        paint.setStrokeWidth(oldWidth);

        ///---------------------
        rectF = new RectF(200, 200, 100, 150);
        canvas.drawArc(rectF, 0, 180, true, paint);
    }



    @Override
    protected void onFingerMove(int x, int y, int dx, int dy) {
        sweepAngle += dx;
        startAngle += dy;
        invalidate();
        if(System.currentTimeMillis() - downMiils >= 500) onClickCanceled = true;
        getObservable().notifyDataChanged(this, "起始角 = " + startAngle + ", 跨度 = " + sweepAngle + ", " + (useCenter ? "扇形" : "弧线"));
    }

    private long downMiils = 0;
    private boolean onClickCanceled = false;
    @Override
    protected void onFingerDown(int x, int y) {
        downMiils = System.currentTimeMillis();
    }

    @Override
    protected void onFingerUp(int x, int y) {
        downMiils = 0;
    }
}