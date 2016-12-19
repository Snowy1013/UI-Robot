package org.ayo.robot.canvas.clip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import org.ayo.robot.canvas.shape.ShapeView;

import java.util.EnumMap;

public class ClipRegionOpView extends ShapeView {
    public ClipRegionOpView(Context context) {
        super(context);
        init();
    }

    public ClipRegionOpView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClipRegionOpView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClipRegionOpView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private Rect mRegionA, mRegionB;// 区域A和区域B对象
    private void init(){
        // 实例化区域A和区域B
        mRegionA = new Rect(100, 100, 200, 200);
        mRegionB = new Rect(150, 150, 300, 300);

        setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currentPositon++;
                if(currentPositon == ops.length){
                    currentPositon = 0;
                }
                invalidate();
            }
        });
    }

    Region.Op[] ops = {
            Region.Op.DIFFERENCE,
            Region.Op.REVERSE_DIFFERENCE,
            Region.Op.INTERSECT,
            Region.Op.REPLACE,
            Region.Op.UNION,
            Region.Op.XOR,
    };
    static EnumMap<Region.Op, String> map = new EnumMap<Region.Op, String>(Region.Op.class);
    static{
        map.put(Region.Op.DIFFERENCE, "保留前区域中的和后区域不重合的地方");
        map.put(Region.Op.REVERSE_DIFFERENCE, "保留后区域中的和前区域不重合的地方");
        map.put(Region.Op.INTERSECT, "保留前后区域重合的地方");
        map.put(Region.Op.REPLACE, "只保留后区域");
        map.put(Region.Op.UNION, "保留前后区域");
        map.put(Region.Op.XOR, "对于UNION，抠出INTERSECT，即去掉前后重合的地方");
    }
    int currentPositon = 0;

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {
        // 填充颜色
        canvas.save();

        // 裁剪区域A
        canvas.clipRect(mRegionA);

        // 再通过组合方式裁剪区域B
        canvas.clipRect(mRegionB, ops[currentPositon]);
        getObservable().notifyDataChanged(this, ops[currentPositon].name() + ": " + map.get(ops[currentPositon]));

        // 填充颜色
        canvas.drawColor(Color.RED);

        canvas.restore();

        // 绘制框框帮助我们观察
        canvas.drawRect(mRegionA, paint);
        canvas.drawRect(mRegionB, paint);
    }

}