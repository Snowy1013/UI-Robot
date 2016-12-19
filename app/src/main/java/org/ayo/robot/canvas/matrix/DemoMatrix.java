package org.ayo.robot.canvas.matrix;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.DemoShapeMgmr;
import org.ayo.robot.R;
import org.ayo.robot.observe.Observable;
import org.ayo.robot.observe.Observer;

/**
 * Created by Administrator on 2016/12/15.
 */

public class DemoMatrix extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_matrix);

        final MatrixView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapeMgmr.attach(getActivity(), root, shapeView);


        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("canvas.setMatrix(Matrix)");
        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("效果可以叠加\n" +
                "set系列是替换\n" +
                "post系列是叠加");

        final TextView tv_notify = findViewById(R.id.tv_notify);
        tv_notify.setText("");
        shapeView.getObservable().addObserver(new Observer() {
            @Override
            public void update(Observable observable, Object src, Object data) {
                tv_notify.setText(data.toString());
            }
        });
    }
}
