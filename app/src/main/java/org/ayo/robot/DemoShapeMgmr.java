package org.ayo.robot;

import android.app.Activity;
import android.graphics.Paint;
import android.view.View;
import android.widget.RadioButton;

import org.ayo.robot.canvas.shape.ShapeView;

/**
 * Created by Administrator on 2016/12/16.
 */

public class DemoShapeMgmr {

    public static PaintSettingView attach(Activity mActivity, View root, final ShapeView shapeView){
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

        paintSettingView.form_stroke_width.getInputView().setProgress((int) shapeView.getPaint().getStrokeWidth());
        paintSettingView.form_stroke_miter.getInputView().setProgress((int) shapeView.getPaint().getStrokeMiter());
//        paintSettingView.form_stroke_width.setLabel("设置stroke width（{progress}/100)".replace("{progress}", shapeView.getPaint().getStrokeWidth()+""));
//        paintSettingView.form_stroke_miter.setLabel("设置stroke miter（{progress}/100)".replace("{progress}", shapeView.getPaint().getStrokeMiter()+""));
        ((RadioButton)paintSettingView.form_stroke_style.getInputView().getChildAt(1)).setChecked(true);

        return paintSettingView;
    }
}
