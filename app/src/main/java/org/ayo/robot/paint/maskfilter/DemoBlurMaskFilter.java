package org.ayo.robot.paint.maskfilter;

import org.ayo.robot.paint.BaseView;
import org.ayo.robot.paint.DemoBase;
import org.ayo.robot.paint.colormatrix.ColorMatrixColorFilterView;

/**
 * Created by Administrator on 2016/12/19.
 */

public class DemoBlurMaskFilter extends DemoBase {

    @Override
    protected BaseView createTestView() {
        return new BlurMaskFilterView(getActivity());
    }

    @Override
    protected void onClickd() {

    }

    @Override
    protected void onLeftTouchBoardMove(int x, int y, int dx, int dy) {

    }

    @Override
    protected void onRightTouchBoardMove(int x, int y, int dx, int dy) {

    }


}
