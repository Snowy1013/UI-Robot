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

public class DemoRotate extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_rotate);

        final RotateView shapeView = findViewById(R.id.shapeView);
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
        tv_method.setText("canvas.rotate(angle)");
        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("canvas.rotate(degree)默认以画布左上角为圆心旋转\n" +
                "rotate(degredd, px, py)指定旋转的圆心\n" +
                "注意，是画布本身旋转，正数是顺时针，负数是逆时针\n" +
                "画布转了几度，在其上的内容就转了几度");

        final TextView tv_notify = findViewById(R.id.tv_notify);
        shapeView.getObservable().addObserver(new Observer() {
            @Override
            public void update(Observable observable, Object src, Object data) {
                tv_notify.setText(data.toString());
            }
        });
    }
}
