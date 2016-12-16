package org.ayo.robot;

import android.app.Activity;
import android.graphics.Paint;
import android.view.View;

import org.ayo.robot.canvas.shape.ShapeView;

/**
 * Created by Administrator on 2016/12/16.
 */

public class DemoShapehelper {

    public static void attach(Activity mActivity, View root, final ShapeView shapeView){
        final PaintSettingView paintSettingView = PaintSettingView.attach(mActivity, root);
        root.findViewById(R.id.body).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(paintSettingView.getVisibility() == View.VISIBLE) paintSettingView.setVisibility(View.GONE);
                else paintSettingView.setVisibility(View.VISIBLE);
            }
        });


        paintSettingView.setCallback(new PaintSettingView.Callback() {
            @Override
            public void onSelectStyle(Paint.Style style) {
                shapeView.setPaintStyle(style);
            }

            @Override
            public void onSelectStrokeCap(Paint.Cap cap) {
                shapeView.setPaintStrokeCap(cap);
            }

            @Override
            public void onSelectStrokeJoin(Paint.Join join) {
                shapeView.setPaintStrokeJoin(join);
            }

            @Override
            public void onSelectStrokeWidth(float w) {
                shapeView.setPaintStrokeWidth(w);
            }

            @Override
            public void onSelectStrokeMiter(float m) {
                shapeView.setPaintStrokeMiter(m);
            }
        });
    }
}
