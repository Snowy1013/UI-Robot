package org.ayo.robot.paint.xfermode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import org.ayo.robot.paint.BaseView;

/**
 * Created by Administrator on 2016/12/19.
 */

public class XfermodesView2 extends BaseView {
    public XfermodesView2(Context context) {
        super(context);
        init();
    }

    public XfermodesView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public XfermodesView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public XfermodesView2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){

    }

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.argb(255, 249, 119, 99));
        //--------------------


        //-------------------
        canvas.drawCircle(w/2, h/2, 150, paint);
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getMethod() {
        return null;
    }

    @Override
    public String getComment() {
        return null;
    }
}
