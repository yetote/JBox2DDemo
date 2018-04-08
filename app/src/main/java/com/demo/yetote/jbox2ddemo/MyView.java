package com.demo.yetote.jbox2ddemo;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

/**
 * com.demo.yetote.jbox2ddemo
 *
 * @author Swg
 * @date 2018/4/8 21:08
 */
public class MyView extends FrameLayout {
    private JBoxImpl jBox;
    private static final String TAG = "MyView";


    public MyView(@NonNull Context context) {
        this(context,null);
    }

    private void init() {
        jBox = new JBoxImpl(this);
    }

    public MyView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        jBox.onSizeChanged(w, h);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        jBox.onLayout(changed);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        jBox.onDraw(canvas);
    }





    /**
     * 传递重力改变
     *
     * @param x x坐标
     * @param y y坐标
     */
    public void onSensorChange(float x, float y) {
        Log.e(TAG, "onSensorChange: "+"aaaaaaaa" );
        jBox.onSensorChanged(x,y);
    }
}
