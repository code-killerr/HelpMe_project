package com.example.codekiller.helpme;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.codekiller.helpme.footer.IndexViewPagerAdapter;
import com.example.codekiller.helpme.footer.RecycleAdapter;

import java.util.ArrayList;
import java.util.List;

public class Index extends AppCompatActivity  implements ViewPager.OnPageChangeListener{
    private ViewPager viewPager;

    /**
     * 装点点的ImageView数组
     */
    private ImageView[] tips;

    /**
     * 装ImageView数组
     */
    private ImageView[] mImageViews;

    /**
     * 图片资源id
     */
    private int[] imgIdArray ;

    private WebView WV;
    List<String > str = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);



        SearchView topSearch =(SearchView)findViewById(R.id.TopSearch);
        topSearch.setSubmitButtonEnabled(true);//是否添加搜索按鈕
        topSearch.setIconifiedByDefault(true);
        //topSearch.onActionViewExpanded();//是否展开搜索框
        topSearch.setBackgroundColor(0xFFFFFFFF);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });


        Button messButton = (Button)findViewById(R.id.messageButton);
        messButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Index.this,PersonUI.class);
                startActivity(intent);
            }
        });


        for(int i=0;i<20;i++)
            str.add("xxx");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.SearchText);
        recyclerView.setLayoutManager(layoutManager);
        RecycleAdapter adapter = new RecycleAdapter(this,str);
        recyclerView.setAdapter(adapter);




        ViewGroup group = (ViewGroup)findViewById(R.id.viewGroup);
        viewPager = (ViewPager) findViewById(R.id.IndexViewPager);

        //载入图片资源ID
        imgIdArray = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,};


        //将点点加入到ViewGroup中
        tips = new ImageView[imgIdArray.length];
        for(int i=0; i<tips.length; i++){
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(10,10));
            tips[i] = imageView;
            if(i == 0){
                tips[i].setBackgroundResource(R.drawable.focused);
            }else{
                tips[i].setBackgroundResource(R.drawable.unfocused);
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.leftMargin = 5;
            layoutParams.rightMargin = 5;
            group.addView(imageView, layoutParams);
        }


        //将图片装载到数组中
        mImageViews = new ImageView[imgIdArray.length];
        for(int i=0; i<mImageViews.length; i++){
            ImageView imageView = new ImageView(this);
            mImageViews[i] = imageView;
            imageView.setBackgroundResource(imgIdArray[i]);
        }

        //设置Adapter
        IndexViewPagerAdapter pagerAdapter = new IndexViewPagerAdapter();
        pagerAdapter.setImageView(mImageViews);//设置传入图片
        viewPager.setAdapter(pagerAdapter);
        //设置监听，主要是设置点点的背景
        viewPager.addOnPageChangeListener(this);
        //设置ViewPager的默认项, 设置为长度的100倍，这样子开始就能往左滑动
        viewPager.setCurrentItem((mImageViews.length) * 100);




    }







    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        setImageBackground(arg0 % mImageViews.length);
    }

    /**
     * 设置选中的tip的背景
     * @param selectItems
     */
    private void setImageBackground(int selectItems){
        for(int i=0; i<tips.length; i++){
            if(i == selectItems){
                tips[i].setBackgroundResource(R.drawable.focused);
            }else{
                tips[i].setBackgroundResource(R.drawable.unfocused);
            }
        }
    }

}

