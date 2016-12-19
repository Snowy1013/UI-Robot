package org.ayo.robot.paint.colormatrix;

import org.ayo.robot.paint.BaseView;
import org.ayo.robot.paint.DemoBase;

/**
 * Created by Administrator on 2016/12/19.
 */

public class DemoPortDuffColorFilter2 extends DemoBase {

    @Override
    protected BaseView createTestView() {
        return new PortDuffColorFilterView2(getActivity());
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
