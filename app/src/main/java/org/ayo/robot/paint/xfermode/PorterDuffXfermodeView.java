package org.ayo.robot.paint.xfermode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import org.ayo.robot.paint.BaseView;

/**
 * Created by Administrator on 2016/12/19.
 */

public class PorterDuffXfermodeView extends BaseView {
    public PorterDuffXfermodeView(Context context) {
        super(context);
        init();
    }

    public PorterDuffXfermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PorterDuffXfermodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PorterDuffXfermodeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private PorterDuff.Mode mode = null;

    private void init(){
        setBackgroundColor(Color.TRANSPARENT);
    }

    public void setPorterDuffMode(PorterDuff.Mode mode){
        this.mode = mode;
        invalidate();
    }

    int centerX = 0;
    int centerY = 0;
    int rectLeft = 0;
    int rectTop = 0;
    boolean isInited = false;

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawColor(Color.parseColor("#f4f4f4"));
        //--------------------
        canvas.saveLayer(0, 0, w, h, paint, Canvas.ALL_SAVE_FLAG);
        if(!isInited){
            centerX = w/2;
            centerY = h/2;
            rectLeft = w/2;
            rectTop = h/2;
            isInited = true;
        }

        paint.setColor(Color.parseColor("#00cc00"));
        canvas.drawCircle(centerX, centerY, 100, paint);

        if(mode != null) paint.setXfermode(new PorterDuffXfermode(mode));

        paint.setColor(Color.parseColor("#0000ff"));
        canvas.drawRect(rectLeft, rectTop, rectLeft + 200, rectTop + 200, paint);

        paint.setXfermode(null);

        canvas.restore();
        //-------------------
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#ff0000"));
        canvas.drawRect(0, 0, w, h, paint);
//        canvas.drawCircle(w/2, h/2, 100, paint);
//        canvas.drawRect(w/2, h/2, w/2+200, h/2+200, paint);
    }

    public void moveCircleBy(int dx, int dy){
        centerX += dx;
        centerY += dy;
        invalidate();
    }

    public void moveRectBy(int dx, int dy){
        rectLeft += dx;
        rectTop += dy;
        invalidate();
    }

    @Override
    public String getTitle() {
        return "PorterDuffXfermode";
    }

    @Override
    public String getMethod() {
        return "mPaint.setXfermode(porterDuffXfermode)";
    }

    @Override
    public String getComment() {
        return "过渡模式，或者叫图形混合模式，色彩混合模式\n" +
                "相对于paint和canvas的两次绘图来说\n" +
                "先绘制dest，再设置Xfermode，再绘制src";
    }
}
