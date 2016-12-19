package org.ayo.robot.canvas.clip;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.DemoShapeMgmr;
import org.ayo.robot.R;
import org.ayo.robot.canvas.shape.ShapeView;

/**
 * Created by Administrator on 2016/12/15.
 */

public class DemoClipPath extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_clip_path);

        final ShapeView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapeMgmr.attach(getActivity(), root, shapeView);

        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("canvas.clipPath(Path)");

        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("以一个闭合图形为裁剪区域\n" +
                "如果Path没有close，则会自动close");
    }
}
