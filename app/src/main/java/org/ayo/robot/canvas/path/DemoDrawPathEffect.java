package org.ayo.robot.canvas.path;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ayo.robot.config.FormCheckBox;
import com.ayo.robot.config.FormRadioGroup;
import com.google.common.collect.Lists;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.DemoShapeMgmr;
import org.ayo.robot.R;
import org.ayo.robot.observe.Observable;
import org.ayo.robot.observe.Observer;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static org.ayo.robot.R.id.tv_method;

/**
 * Created by Administrator on 2016/12/15.
 */

public class DemoDrawPathEffect extends AyoActivityAttacher {

    private boolean isCompose = false;
    private boolean isSum = false;
    private List<String> pathEffects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_draw_patheffect);

        final PathEffectView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapeMgmr.attach(getActivity(), root, shapeView);

        final FormCheckBox form_check_path_effect = id(R.id.form_check_path_effect);
        form_check_path_effect.setLabel("选择PathEffect（最多两个）");
        form_check_path_effect.notifyDataSetChanged(Lists.newArrayList("CornerPathEffect", "DiscretePathEffect", "DashPathEffect", "PathDashPathEffect"));
        form_check_path_effect.setOnSelectChangedCallback(new FormCheckBox.OnSelectChangedCallback() {
            @Override
            public void onSelectChange(List<Object> selected) {
                pathEffects.clear();
                if(selected == null){
                    shapeView.setPathEffect(null, isCompose, isSum);
                }else{
                    for(Object o: selected){
                        pathEffects.add(o.toString());
                        shapeView.setPathEffect(pathEffects, isCompose, isSum);
                    }
                }
            }
        });

        final FormRadioGroup form_radio_path_effect_group = id(R.id.form_radio_path_effect_group);
        form_radio_path_effect_group.setLabel("选择组合模式");
        form_radio_path_effect_group.notifyDataSetChanged(Lists.newArrayList("none", "ComposePathEffect", "SumPathEffect"));
        form_radio_path_effect_group.getInputView().setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == 1){
                    isCompose = false;
                    isSum = false;
                }else if(checkedId == 2){
                    isCompose = true;
                    isSum = false;
                }else if(checkedId == 3){
                    isCompose = false;
                    isSum = true;
                }else{
                    isCompose = false;
                    isSum = false;
                }
                shapeView.setPathEffect(pathEffects, isCompose, isSum);
            }
        });

        TextView tv_title = findViewById(R.id.tv_title);
        tv_title.setText("PathEffect");

        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("paint.setPathEffect(PathEffect)");

        final TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("");

        final TextView tv_notify = findViewById(R.id.tv_notify);
        tv_notify.setText("PathEffect = null");
        shapeView.getObservable().addObserver(new Observer() {
            @Override
            public void update(Observable observable, Object src, Object data) {
                tv_notify.setText(data.toString());
            }
        });
    }
}
