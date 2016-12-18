package org.ayo.robot.canvas.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import org.ayo.robot.canvas.shape.ShapeView;

public class PathBezier2View extends ShapeView {
    public PathBezier2View(Context context) {
        super(context);
        init();
    }

    public PathBezier2View(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathBezier2View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PathBezier2View(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
    }

    Path path;


    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {

        if(!isInited){

            startX = 30;
            startY = h / 2;
            endX = w - 30;
            endY = h/2;
            control_1_x = startX + 100;
            control_1_y = startY - 100;

            isInited = true;
        }

        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
        path.moveTo(startX, startY);
        path.quadTo(control_1_x, control_1_y, endX, endY);
        canvas.drawPath(path, paint);

        float oldWidth = paint.getStrokeWidth();
        paint.setStrokeWidth(7);
        canvas.drawPoint(startX, startY, paint);
        canvas.drawPoint(endX, endY, paint);
        canvas.drawPoint(control_1_x, control_1_y, paint);

        paint.setStrokeWidth(oldWidth);
    }

    @Override
    protected void onFingerMove(int x, int y, int dx, int dy) {
        path.reset();
        control_1_x += dx;
        control_1_y += dy;
        invalidate();
    }

    int startX = 10;
    int startY = 150;
    int endX = startX + 150;
    int endY = startY;
    int control_1_x = 150;
    int control_1_y = 30;
    private boolean isInited = false;

}