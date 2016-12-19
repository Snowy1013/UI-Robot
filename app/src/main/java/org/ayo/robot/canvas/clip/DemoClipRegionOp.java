package org.ayo.robot.canvas.clip;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.DemoShapeMgmr;
import org.ayo.robot.R;
import org.ayo.robot.canvas.shape.ShapeView;
import org.ayo.robot.observe.Observable;
import org.ayo.robot.observe.Observer;

/**
 * Created by Administrator on 2016/12/15.
 */

public class DemoClipRegionOp extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_clip_region_op);

        final ShapeView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapeMgmr.attach(getActivity(), root, shapeView);

        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("canvas.clipRect(mRegionB, ops[currentPositon])");

        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("与现有裁剪区域进行组合，Region.Op就是组合方式\n" +
                "DIFFENCE, INTERSECT, REPLACE, REVERSE_DEFFERENCE, UNION, XOR");

        final TextView tv_notify = id(R.id.tv_notify);
        shapeView.getObservable().addObserver(new Observer() {
            @Override
            public void update(Observable observable, Object src, Object data) {
                tv_notify.setText(data.toString());
            }
        });
    }
}
