package org.ayo.robot.canvas.matrix;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.DemoShapeMgmr;
import org.ayo.robot.R;
import org.ayo.robot.TouchBoard;
import org.ayo.robot.observe.Observable;
import org.ayo.robot.observe.Observer;

/**
 * Created by Administrator on 2016/12/15.
 */

public class DemoScale extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_scale);

        final ScaleView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapeMgmr.attach(getActivity(), root, shapeView);


        TouchBoard touchBoard_right = findViewById(R.id.touchBoard_right);

        touchBoard_right.setCallback(new TouchBoard.Callback() {
            @Override
            public void onDown(int x, int y) {

            }

            @Override
            public void onUp(int x, int y) {

            }

            @Override
            public void onMove(int x, int y, int dx, int dy) {
                shapeView.changeCenter(dx, dy);
            }
        });

        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("canvas.scale(sx, sy, centerX, centerY)");
        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("centerX和Y对缩放的影响还是很大的");

        final TextView tv_notify = findViewById(R.id.tv_notify);
        shapeView.getObservable().addObserver(new Observer() {
            @Override
            public void update(Observable observable, Object src, Object data) {
                tv_notify.setText(data.toString());
            }
        });
    }
}
