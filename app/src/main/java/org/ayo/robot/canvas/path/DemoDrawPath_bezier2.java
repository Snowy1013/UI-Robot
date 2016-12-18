package org.ayo.robot.canvas.path;

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

public class DemoDrawPath_bezier2 extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_draw_path_bezier2);

        final ShapeView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapeMgmr.attach(getActivity(), root, shapeView);

        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("quadTo(float x1, float y1, float x2, float y2) ");
        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("x1, y1是控制点\n" +
                "x2, y2是终点\n" );
    }
}
