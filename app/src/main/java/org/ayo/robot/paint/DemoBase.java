package org.ayo.robot.paint;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.R;
import org.ayo.robot.TouchBoard;
import org.ayo.robot.observe.Observable;
import org.ayo.robot.observe.Observer;

/**
 * Created by Administrator on 2016/12/19.
 */

public abstract class DemoBase extends AyoActivityAttacher {

    TextView tv_title, tv_method, tv_comment, tv_notify;
    FrameLayout shapeViewContainer;
    BaseView baseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_base);

        tv_title = id(R.id.tv_title);
        tv_method = id(R.id.tv_method);
        tv_comment = id(R.id.tv_comment);
        tv_notify = id(R.id.tv_notify);

        final FrameLayout shapeViewContainer = findViewById(R.id.shapeView_container);

        baseView = createTestView();
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        shapeViewContainer.addView(baseView, lp);

        baseView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onClickd();
            }
        });

        setTitle(baseView.getTitle());
        setMethod(baseView.getMethod());
        setComment(baseView.getComment());
        baseView.getObservable().addObserver(new Observer() {
            @Override
            public void update(Observable observable, Object src, Object data) {
                tv_notify.setText(data.toString());
            }
        });

        TouchBoard touchBoard_left = findViewById(R.id.touchBoard_left);
        TouchBoard touchBoard_right = findViewById(R.id.touchBoard_right);

        touchBoard_left.setCallback(new TouchBoard.Callback() {
            @Override
            public void onDown(int x, int y) {

            }

            @Override
            public void onUp(int x, int y) {

            }

            @Override
            public void onMove(int x, int y, int dx, int dy) {
                onLeftTouchBoardMove(x, y, dx, dy);
            }
        });

        touchBoard_right.setCallback(new TouchBoard.Callback() {
            @Override
            public void onDown(int x, int y) {

            }

            @Override
            public void onUp(int x, int y) {

            }

            @Override
            public void onMove(int x, int y, int dx, int dy) {
                onRightTouchBoardMove(x, y, dx, dy);
            }
        });


    }

    protected abstract void onLeftTouchBoardMove(int x, int y, int dx, int dy);
    protected abstract void onRightTouchBoardMove(int x, int y, int dx, int dy);
    protected abstract BaseView createTestView();
    protected abstract void onClickd();

    protected BaseView getTestView(){
        return baseView;
    }

    protected void setNotify(String s){
        tv_notify.setText(s);
    }

    protected void setTitle(String s){
        tv_title.setText(s);
    }

    protected void setMethod(String s){
        tv_method.setText(s);
    }

    protected void setComment(String s){
        tv_comment.setText(s);
    }
}
