package com.example.codekiller.helpme.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;
//.解决scrollview嵌套recycle没有滑动惯性问题
public class ScrollViewForIndex extends ScrollView {
    private int downX;
    private int downY;
    private int mTouchSlop;


    //覆写构造函数，获取事件触发滑动距离
    public ScrollViewForIndex(Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public ScrollViewForIndex(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public ScrollViewForIndex(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }
//事件处理，onInterceptTouchEvent向下传递
    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        int action = e.getAction();//获取活动
        switch (action) {
            case MotionEvent.ACTION_DOWN://手指接触屏幕
                downX = (int) e.getRawX();//获取手指坐标
                downY = (int) e.getRawY();
                break;
            case MotionEvent.ACTION_MOVE://手指移动
                int moveY = (int) e.getRawY();
                if (Math.abs(moveY - downY) > mTouchSlop) {
                    return true;
                }//控制是否触发移动事件
        }
        return super.onInterceptTouchEvent(e);//调用scrollview事件处理
    }
}
