package com.example.codekiller.helpme.footer.MainScreen;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.ArrayList;

public class IndexViewPagerAdapter extends PagerAdapter{

    private ImageView[] mImageViews;

    public void setImageView(ImageView imageView[]){
        mImageViews = imageView;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    /**
     * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int data =  position % mImageViews.length;
        Log.i("Message","数字是"+data+"图片组长度为"+mImageViews.length+"当前页面为"+position);

        if(container!= null)
            ((ViewPager)container).removeView(mImageViews[position % mImageViews.length]);

        ((ViewPager)container).addView(mImageViews[position % mImageViews.length], 0);

        return mImageViews[position % mImageViews.length];
    }



}
