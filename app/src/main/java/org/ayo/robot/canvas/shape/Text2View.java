package org.ayo.robot.canvas.shape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

public class Text2View extends ShapeView {
    public Text2View(Context context) {
        super(context);
        init();
    }

    public Text2View(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Text2View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Text2View(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){

    }

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {
        Rect rect = new Rect(10, 10, 100, 100);
        RectF rectF = new RectF(10, 10, 200, 200);
        canvas.drawRect(rectF, paint);

        /*
        Rect的四个顶点是int
        RectF的四个顶点float
        RectF和rx（x-radius）,ry（y-radius）构成了圆角Rect
        rx    The x-radius of the oval used to round the corners
        ry    The y-radius of the oval used to round the corners

        Rect和RectF包含的方法：
        inset
        union
        是否包含点或矩形
         */
    }

}