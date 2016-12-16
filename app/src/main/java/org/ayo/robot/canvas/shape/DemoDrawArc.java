package org.ayo.robot.canvas.shape;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.DemoShapeMgmr;
import org.ayo.robot.PaintSettingView;
import org.ayo.robot.R;
import org.ayo.robot.observe.Observable;
import org.ayo.robot.observe.Observer;

/**
 * Created by Administrator on 2016/12/15.
 */

public class DemoDrawArc extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_draw_arc);

        final ShapeView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        PaintSettingView paintSettingView = DemoShapeMgmr.attach(getActivity(), root, shapeView);

        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("canvas.drawArc(rectF, startAngle, sweepAngle, useCenter, paint);");

        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("画个扇形或者弧线--都可以填充\n" +
                "弧线的填充就是收尾相连形成close\n" +
                "不论弧线还是扇形，都是取自一个由外接矩形定义的椭圆\n" +
                "startAngle：从圆心水平向右是0，顺时针数，总数360\n" +
                "sweepAngle：弧度\n" +
                "useCenter：true表示要扇形，false表示要弧线");

        final TextView tv_radius = findViewById(R.id.tv_radius);
        tv_radius.setText("起始角 = " + 0 + ", 跨度 = " + 90 + ", " + (true ? "扇形" : "弧线") + "   左右滑动和点击看效果");
        shapeView.getObservable().addObserver(new Observer() {
            @Override
            public void update(Observable observable, Object src, Object data) {
                tv_radius.setText(data.toString() + "   左右滑动看效果");
            }
        });
    }
}
