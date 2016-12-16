package org.ayo.robot.canvas.shape;

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

public class DemoDrawRoundRect extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_draw_round_rect);

        final ShapeView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapeMgmr.attach(getActivity(), root, shapeView);

        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("canvas.drawCircle(w/2, h/2, radius, paint);");

        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("画个圆角矩形\n" +
                "使用RectF和xRadius，yRadius\n" +
                "xRadius和yRadius不能小于0");

        final TextView tv_radius = findViewById(R.id.tv_radius);
        tv_radius.setText("xRadius = " + 30 + ", yRadius = " + 30 + "   左右滑动看效果");
        ((RoundRectView)shapeView).getObservable().addObserver(new Observer() {
            @Override
            public void update(Observable observable, Object src, Object data) {
                tv_radius.setText(data.toString() + "   左右滑动看效果");
            }
        });
    }
}
