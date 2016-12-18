package org.ayo.robot.canvas.clip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import org.ayo.robot.canvas.shape.ShapeView;

public class ClipRectView extends ShapeView {
    public ClipRectView(Context context) {
        super(context);
        init();
    }

    public ClipRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClipRectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClipRectView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clipTop = !clipTop;
                invalidate();
            }
        });
    }

    private boolean clipTop = true;

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {
        RectF top = new RectF(5, 5, 2*w/3.0f, 2*h/3.0f);
        RectF bottom = new RectF(w/3.0f, h/3.0f, w-5, h-5);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawRect(top, paint);
        canvas.drawRect(bottom, paint);

        if(clipTop){
            top = new RectF(5, 5, 2*w/3.0f, 2*h/3.0f);
        }else{
            top.intersect(bottom);
        }
        canvas.clipRect(top);

        ///剪切后，绘制一个背景
        canvas.drawColor(Color.parseColor("#55000000"));
    }

}