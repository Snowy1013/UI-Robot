package org.ayo.robot.canvas.matrix;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import org.ayo.robot.canvas.shape.ShapeView;

/**
 * Created by Administrator on 2016/12/19.
 */

public class ScaleView extends ShapeView {
    public ScaleView(Context context) {
        super(context);
    }

    public ScaleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScaleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ScaleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint mPaint) {

        getObservable().notifyDataChanged(this, "圆心(" + centerX + ", " + centerY + ") \n当前scale(" + sx + ", " + sy + ")");
        int rectW = 150;
        int rectH = 150;
        int left = w/2;
        int top = h/2;
        if(!isInited){
            centerX = w/2;
            centerY = h/2;
            isInited = true;
        }
        /*
         * 绘制一个红色矩形
         */
        mPaint.setColor(Color.RED);
        canvas.drawRect(left, top, top + rectW, top + rectH, mPaint);
        canvas.drawCircle(centerX, centerY, 10, mPaint);

        /*
         * 保存画布并绘制一个黑色的矩形
         */
        canvas.save();
        mPaint.setColor(Color.BLACK);
        canvas.scale(sx, sy, centerX, centerY);
        canvas.drawRect(left, top, top + rectW, top + rectH, mPaint);
        canvas.drawRect(0, 0, rectW, rectH, mPaint);
        canvas.restore();


    }

    float sx = 2;
    float sy = 2;
    int centerX = 20;
    int centerY = 20;
    private boolean isInited = false;

    @Override
    protected void onFingerMove(int x, int y, int dx, int dy) {
        sx += dx/50f;
        sy += dy/50f;
        invalidate();
    }

    public void changeCenter(int dx, int dy){
        centerX += dx;
        centerY += dy;
        invalidate();
    }


}
