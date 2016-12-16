package org.ayo.robot.canvas.shape;

import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.DemoShapeMgmr;
import org.ayo.robot.R;

/**
 * Created by Administrator on 2016/12/15.
 */

public class DemoDrawPath extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_draw_path);

        final ShapeView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapeMgmr.attach(getActivity(), root, shapeView);

        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("canvas.drawPath(path, paint);");
        Path path = new Path();
        path.moveTo(90, 330);
        path.lineTo(150, 330);
        path.lineTo(120, 270);
        path.close();
        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("drawPath(Path, Paint)\n" +
                "Path path = new Path();\n" +
                "path.moveTo(90, 330);\n" +
                "path.lineTo(150, 330);\n" +
                "path.lineTo(120, 270);\n" +
                "path.close();\n" +
                "close的Path是个闭合的图形\n" +
                "不受style的填充和线框影响\n" +
                "rLineTo(dx, dy)：用相对距离画线\n" +
                "path连接两点的方法还挺多，各种曲线，可以好好研究一下\n" +
                "但是注意：本质上Path就是连续的直线");
    }
}
