package org.ayo.robot.canvas.shape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import org.ayo.robot.observe.Observable;

public class RoundRectView extends ShapeView {
    public RoundRectView(Context context) {
        super(context);
        init();
    }

    public RoundRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundRectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RoundRectView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){

    }

    int xRadius = 30;
    int yRadius = 30;

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {
        RectF rectF = new RectF(50, 50, 250, 250);
        canvas.drawRoundRect(rectF, xRadius, yRadius, paint);
    }

    @Override
    protected void onFingerMove(int x, int y, int dx, int dy) {
        xRadius += dx;
        yRadius += dy;
        invalidate();
        observable.notifyDataChanged(this, "xRadius = " + xRadius + ", yRadius = " + yRadius);
    }

    private Observable observable = new Observable();
    public Observable getObservable(){
        return observable;
    }
}