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

public class DemoDrawPath_arc extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_draw_path_arc_to);

        final PathArcView shapeView = findViewById(R.id.shapeView);
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
                shapeView.onRectMove(dx, dy);
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
                shapeView.onEndMove(dx, dy);
            }
        });



        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("arcTo (RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) ");
        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("不知道到底是个什么意思\n" +
                "mPath.arcTo((RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo)确定一条弧线\n" +
                "从当前点到这条弧线的起点就是咱的path，啥意思？？\n" +
                "如果forceMoveTo为true，就只剩一条弧线了，这又啥意思？？" );
    }
}
