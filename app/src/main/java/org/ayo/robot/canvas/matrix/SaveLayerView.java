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

public class SaveLayerView extends ShapeView {
    public SaveLayerView(Context context) {
        super(context);
    }

    public SaveLayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SaveLayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SaveLayerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint mPaint) {
        /*
         * 绘制一个红色矩形
         */
        mPaint.setColor(Color.RED);
        canvas.drawRect(w / 2F - 200, h / 2F - 200, w / 2F + 200, h / 2F + 200, mPaint);

        /*
         * 保存画布并绘制一个蓝色的矩形
         */
        canvas.saveLayer(0, 0, w, h, null, Canvas.ALL_SAVE_FLAG);
        mPaint.setColor(Color.BLUE);

        // 旋转画布
        canvas.rotate(30);
        canvas.drawRect(w / 2F - 100, h / 2F - 100, w / 2F + 100, h / 2F + 100, mPaint);
        canvas.restore();
    }


}
