package org.ayo.robot.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import org.ayo.robot.observe.Observable;

/**
 * 画一个shape，点击可以切换FILL，STROKE样式
 * 为了降低对各种图形坐标尺寸的混淆，这个自定义控件不考虑padding，并且最小尺寸（即wrap_content）是200px
 */
public abstract class BaseView extends View {
    public BaseView(Context context) {
        super(context);
        initttt();
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initttt();
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initttt();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BaseView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initttt();
    }

    private int mColor = Color.parseColor("#006633");
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Paint getPaint(){
        return mPaint;
    }

    private void initttt(){
        mPaint.setColor(mColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawShape(canvas, getWidth(), getHeight(), mPaint);
    }

    protected abstract void drawShape(Canvas canvas, int w, int h, Paint paint);

    //===========================================
    //为了让控件支持wrap_content时，内容尺寸取200px，需要我们重写measure过程
    //===========================================
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(
                mearureWidth(widthMeasureSpec),
                mearureHeight(heightMeasureSpec));
    }

    private int mearureWidth(int measureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else{
            result = calculateContentWidth();
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize);
            }
        }

        return result;
    }

    private int mearureHeight(int measureSpec){
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else{
            result = calculateContentHeight();
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize);
            }
        }

        return result;
    }

    private int calculateContentWidth(){
        return 200;
    }

    private int calculateContentHeight(){
        return 200;
    }

    protected Observable observable = new Observable();
    public Observable getObservable(){
        return observable;
    }

    public void setPaintColor(int color){
        mPaint.setColor(color);
        invalidate();
    }

    public abstract String getTitle();
    public abstract String getMethod();
    public abstract String getComment();

}