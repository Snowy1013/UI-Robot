package org.ayo.robot.canvas.path;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.DemoShapeMgmr;
import org.ayo.robot.R;
import org.ayo.robot.TouchBoard;

/**
 * Created by Administrator on 2016/12/15.
 */

public class DemoDrawPath_bezier3 extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_draw_path_bezier3);

        final PathBezier3View shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapeMgmr.attach(getActivity(), root, shapeView);

        TouchBoard touchBoard_left = findViewById(R.id.touchBoard_left);
        TouchBoard touchBoard_right = findViewById(R.id.touchBoard_right);

        touchBoard_left.setCallback(new TouchBoard.Callback() {
            @Override
            public void onDown(int x, int y) {

            }

            @Override
            public void onUp(int x, int y) {

            }

            @Override
            public void onMove(int x, int y, int dx, int dy) {
                shapeView.changeControlPoint_1(dx, dy);
            }
        });

        touchBoard_right.setCallback(new TouchBoard.Callback() {
            @Override
            public void onDown(int x, int y) {

            }

            @Override
            public void onUp(int x, int y) {

            }

            @Override
            public void onMove(int x, int y, int dx, int dy) {
                shapeView.changeControlPoint_2(dx, dy);
            }
        });


        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("Path.cubicTo(float x1, float y1, float x2, float y2, float endX, float endY) ");
        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("三阶贝塞尔曲线\n" +
                "x1,y1和x2,y2是两个控制点\n" );
    }
}
