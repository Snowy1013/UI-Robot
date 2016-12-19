package org.ayo.robot.canvas.matrix;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import org.ayo.robot.canvas.shape.ShapeView;

import static android.R.attr.centerX;
import static android.R.attr.centerY;

/**
 * Created by Administrator on 2016/12/19.
 */

public class TranslateView extends ShapeView {
    public TranslateView(Context context) {
        super(context);
    }

    public TranslateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TranslateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TranslateView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint mPaint) {

        getObservable().notifyDataChanged(this, "translate by(" + translateX + ", " + translatey + ")");
        int rectW = 150;
        int rectH = 150;
        int left = w/2;
        int top = h/2;
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
        canvas.translate(translateX, translatey);
        canvas.drawRect(left, top, top + rectW, top + rectH, mPaint);
        canvas.drawRect(0, 0, rectW, rectH, mPaint);
        canvas.restore();
    }

    int translateX = 20;
    int translatey = 20;

    @Override
    protected void onFingerMove(int x, int y, int dx, int dy) {
        translateX += dx;
        translatey += dy;
        invalidate();
    }



}
