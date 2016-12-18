package org.ayo.robot.canvas.clip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import org.ayo.robot.canvas.shape.ShapeView;

public class ClipRegionView extends ShapeView {
    public ClipRegionView(Context context) {
        super(context);
        init();
    }

    public ClipRegionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClipRegionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClipRegionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){

    }

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {
        int radius = Math.min(w, h) / 2;
        canvas.drawCircle(w/2, h/2, radius, paint);
    }

}