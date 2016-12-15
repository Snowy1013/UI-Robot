package org.ayo.robot.canvas.shape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

public class LineView extends ShapeView {
    public LineView(Context context) {
        super(context);
        init();
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LineView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){

    }

    int startX = 10;
    int startY = 10;
    int endX = 30;
    int endY = 30;

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {
        canvas.drawLine(startX, startY, endX, endY, paint);
    }

    @Override
    protected void onFingerMove(int x, int y, int dx, int dy) {
        endX += dx;
        endY += dy;
        invalidate();
    }
}