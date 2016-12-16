package org.ayo.robot.canvas.shape;

import android.os.Bundle;
import android.view.View;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.DemoShapehelper;
import org.ayo.robot.R;

/**
 * Created by Administrator on 2016/12/15.
 */

public class DemoDrawCircile extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_draw_circle);

        final ShapeView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapehelper.attach(getActivity(), root, shapeView);
    }
}
