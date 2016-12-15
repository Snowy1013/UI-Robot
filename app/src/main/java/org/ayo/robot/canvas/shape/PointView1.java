
package org.ayo.robot.canvas.shape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import org.ayo.robot.Toaster;

import java.util.Random;

public class PointView1 extends ShapeView {
    public PointView1(Context context) {
        super(context);
        init();
    }

    public PointView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PointView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PointView1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    Random r = new Random();
    private void init(){
        setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                countOfPoint *= 10;
                if(countOfPoint >= 1000000){
                    countOfPoint = 1000;
                }
                invalidate();
            }
        });
    }
    int countOfPoint = 1000;
    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {

        double radius = Math.min(w, h) / 2;
        int centerX = w/2;
        int centerY = h/2;
        //随机放出1000个点，离圆心距离小于radius的就在圆内，否则就在圆外，如果有900个在圆内，概率上来说，圆的面积就是w和h这个矩形的9/10
        int countInCircle = 0;
        for(int i = 0; i < countOfPoint; i++){
            int x = r.nextInt(w);
            int y = r.nextInt(h);

            canvas.drawPoint(x, y, paint);

            if(Math.sqrt(Math.pow(x-centerX, 2) + Math.pow(y-centerY, 2)) < radius){
                countInCircle++;
            }

        }

        int mianjiForRect = w * h;
        double mainjiForCircle = mianjiForRect * ((double)countInCircle/countOfPoint);
        double pai = mainjiForCircle/(radius*radius);
        Toaster.toastShort("根据概率算出来的π=" + pai + "(采样点：" + countOfPoint +"个)");

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(w/2, h/2, (int)radius, paint);
    }

}