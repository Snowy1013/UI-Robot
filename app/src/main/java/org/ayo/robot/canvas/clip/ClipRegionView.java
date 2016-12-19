package org.ayo.robot.canvas.clip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Region;
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

    private Region mRegionA, mRegionB;// 区域A和区域B对象
    private void init(){
        // 实例化区域A和区域B
        mRegionA = new Region(100, 100, 200, 200);
        mRegionB = new Region(150, 150, 300, 300);
    }

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {
        canvas.save();

        // 裁剪区域A
        canvas.clipRegion(mRegionA);

        // 再通过组合方式裁剪区域B
        canvas.clipRegion(mRegionB, Region.Op.DIFFERENCE);

        // 填充颜色
        canvas.drawColor(Color.RED);

        canvas.restore();

        // 绘制框框帮助我们观察
        canvas.drawRect(100, 100, 200, 200, paint);
        canvas.drawRect(150, 150, 300, 300, paint);
    }

}