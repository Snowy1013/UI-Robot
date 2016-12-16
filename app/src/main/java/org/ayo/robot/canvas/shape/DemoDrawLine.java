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

public class DemoDrawLine extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_draw_line);

        final ShapeView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapeMgmr.attach(getActivity(), root, shapeView);

        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText(" canvas.drawLine(startX, startY, endX, endY, paint);");

        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("drawLine(startX, startY, endX, endY, paint)：使用四个点画个直线\n" +
                "drawLines(@Size(multiple=4) float[] pts, int offset, int count, Paint paint)\n" +
                "pts：每两个值是一个点，两个点是一条线\n" +
                "offest: Number of values in the array to skip before drawing\n" +
                "count：画几条直线，skip过offset个值之后，处理count条直线，注意，是count*4个值\n" +
                "是离散的直线");
    }
}
