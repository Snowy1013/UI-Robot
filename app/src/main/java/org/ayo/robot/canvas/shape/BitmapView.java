package org.ayo.robot.canvas.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import org.ayo.robot.Bitmaps;
import org.ayo.robot.R;
import org.ayo.robot.Toaster;

public class BitmapView extends ShapeView {
    public BitmapView(Context context) {
        super(context);
        init();
    }
    public BitmapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BitmapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BitmapView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    Bitmap mBitmap;
    private void init(){
        //mBitmap = ((BitmapDrawable) getContext().getResources().getDrawable(R.raw.test2)).getBitmap();
        setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currentPosition++;
                if(currentPosition == ids.length) currentPosition = 0;

                Toaster.toastShort((currentPosition == 0 ? "jpg" : (currentPosition == 1 ? "png 1" : "png 2")));
                invalidate();
            }
        });
    }

    int[] ids = {
            R.raw.test2,
            R.mipmap.ic_launcher,
            R.raw.test3
    };
    int currentPosition = 0;

    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {

        int id = ids[currentPosition];
        int[] imageSize = Bitmaps.getImageSize(getContext(), id);
        mBitmap = Bitmaps.getBitmapByResource(getContext(), id, getMeasuredWidth(), getMeasuredHeight());
        Rect src = new Rect(0, 0, imageSize[0], imageSize[1]);
        RectF dest = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
        canvas.drawBitmap(mBitmap, src, dest, paint);
        getObservable().notifyDataChanged(this, "图片尺寸(" + imageSize[0] + ", " + imageSize[1] + "), 控件尺寸(" + getMeasuredWidth() + ", " + getMeasuredHeight() + ")");

    }

    public int getCurrentShowingResourceId(){
        return ids[currentPosition];
    }


}