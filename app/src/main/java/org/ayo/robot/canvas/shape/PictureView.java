package org.ayo.robot.canvas.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.os.Build;
import android.util.AttributeSet;

import org.ayo.robot.Bitmaps;
import org.ayo.robot.R;

public class PictureView extends ShapeView {
    public PictureView(Context context) {
        super(context);
        init();
    }
    public PictureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PictureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PictureView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    Picture picture;
    private volatile boolean pictureReady = false;
    private void init(){
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        picture = new Picture();
        new Thread(new Runnable() {
            @Override
            public void run() {

                Canvas canvas = picture.beginRecording(300, 500);
                canvas.drawBitmap(Bitmaps.getBitmapByResource(getContext(), R.mipmap.ic_launcher, 100, 100), 0, 0, getPaint());
                picture.endRecording();

                pictureReady = true;
                postInvalidate();
            }
        }).start();

    }



    @Override
    protected void drawShape(Canvas canvas, int w, int h, Paint paint) {

        if(pictureReady){
            picture.draw(canvas);
            //canvas.drawPicture(picture);
        }

    }



}