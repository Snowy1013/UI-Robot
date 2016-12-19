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

public class SaveView extends ShapeView {
    public SaveView(Context context) {
        super(context);
    }

    public SaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SaveView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint mPaint) {
        int rectW = 100;
        int rectH = 100;
        /*
         * 绘制一个红色矩形
         */
        mPaint.setColor(Color.RED);
        canvas.drawRect(10, 10, 10 + rectW, 10 + rectH, mPaint);

        /*
         * 保存画布并绘制一个蓝色的矩形
         */
        canvas.save();
        mPaint.setColor(Color.BLUE);
        canvas.translate(100, 100);
        canvas.rotate(30);
        canvas.drawRect(10, 10, 10 + rectW, 10 + rectH, mPaint);
        canvas.restore();

        /*
         * 保存画布并绘制一个黑色的矩形
         */
        canvas.save();
        mPaint.setColor(Color.BLACK);
        canvas.translate(200, 200);
        canvas.rotate(60);
        canvas.drawRect(10, 10, 10 + rectW, 10 + rectH, mPaint);
        canvas.restore();


        /*
         * 保存画布并绘制一个CYAN的矩形
         */
        canvas.save();
        mPaint.setColor(Color.CYAN);
        canvas.rotate(90);
        canvas.drawRect(10, 10, 10 + rectW, 10 + rectH, mPaint);
        canvas.restore();
    }


}
