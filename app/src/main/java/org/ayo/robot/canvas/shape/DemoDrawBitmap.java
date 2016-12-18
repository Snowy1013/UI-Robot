package org.ayo.robot.canvas.shape;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.robot.DemoShapeMgmr;
import org.ayo.robot.R;
import org.ayo.robot.observe.Observable;
import org.ayo.robot.observe.Observer;

/**
 * Created by Administrator on 2016/12/15.
 */

public class DemoDrawBitmap extends AyoActivityAttacher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_draw_bitmap);

        final ShapeView shapeView = findViewById(R.id.shapeView);
        final View root = findViewById(R.id.body);
        DemoShapeMgmr.attach(getActivity(), root, shapeView);

        TextView tv_method = findViewById(R.id.tv_method);
        tv_method.setText("canvas.drawBitmap(mBitmap, src, dest, paint);");

        TextView tv_comment = findViewById(R.id.tv_comment);
        tv_comment.setText("绘制位图\n" +
                "总是会尝试把ong的src区域全部绘制到View的dest区域，会拉伸变形\n" +
                "对于jpg图片的处理，没弄明白，demo里只显示了部分\n" +
                "高级处理：drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint)\n" +
                "ImageView是依靠canvas变换和Drawable");

        final ImageView iv = findViewById(R.id.iv);


        final TextView tv_radius = findViewById(R.id.tv_radius);
        shapeView.getObservable().addObserver(new Observer() {
            @Override
            public void update(Observable observable, Object src, Object data) {
                tv_radius.setText(data.toString() + "   点击中图");
                if(src instanceof BitmapView){
                    BitmapView bitmapView = (BitmapView) src;
                    iv.setImageResource(bitmapView.getCurrentShowingResourceId());
                }
            }
        });
    }
}

