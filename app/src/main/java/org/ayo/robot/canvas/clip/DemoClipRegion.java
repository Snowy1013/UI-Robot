package org.ayo.robot.canvas.clip;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.DemoShapeMgmr;
import org.ayo.robot.R;
import org.ayo.robot.canvas.shape.ShapeView;

/**
 * Created by Administrator on 2016/12/15.
 */

public class DemoClipRegion extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_clip_region);

        final ShapeView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapeMgmr.attach(getActivity(), root, shapeView);

        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("canvas.clipRegion(mRegionB, Region.Op.DIFFERENCE) 已被废弃");

        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("因为不支持current matrix");
    }
}
