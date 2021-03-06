package org.ayo.robot.canvas.shape;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.DemoShapeMgmr;
import org.ayo.robot.R;

/**
 * Created by Administrator on 2016/12/15.
 */

public class DemoDrawPoint extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_draw_point);

        final ShapeView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapeMgmr.attach(getActivity(), root, shapeView);

        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("canvas.drawPoint(x, y, paint);");

        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("drawPoint(x, y, paint)：画个点，点大小基于stroke width\n" +
                "drawPoints(float[] pts, int offest, int count, paint)：画很多点\n" +
                "pts:[x0 y0 x1 y1 x2 y2 ...]\n" +
                "offest: Number of values in the array to skip before drawing\n" +
                "count: 画几个点，skip过offset个值之后，处理count个点，注意，是count*2个值");
    }
}
