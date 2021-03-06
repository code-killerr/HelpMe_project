package com.example.codekiller.helpme;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.codekiller.helpme.footer.MainScreen.IndexViewPagerAdapter;
import com.example.codekiller.helpme.footer.MainScreen.Main_RecycleItemClass;
import com.example.codekiller.helpme.footer.SearchTextAdapter;
import com.example.codekiller.helpme.footer.MainScreen.ShowMember;
import com.example.codekiller.helpme.footer.MainScreen.ShowQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main_Screen extends Fragment implements ViewPager.OnPageChangeListener {

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
    private int[] imgIdArray;

    private View view;

    private SwipeRefreshLayout swipeRefresh;
    List<Main_RecycleItemClass> searchText = new ArrayList<>();

    public Main_Screen() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_index, container, false);


        SearchView topSearch = view.findViewById(R.id.TopSearch);
        topSearch.setSubmitButtonEnabled(true);//是否添加搜索按鈕
        topSearch.setIconifiedByDefault(true);
        //topSearch.onActionViewExpanded();//是否展开搜索框
        topSearch.setBackgroundColor(0xFFFFFFFF);

        //设置刷新
        swipeRefresh = view.findViewById(R.id.swipeRefresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 开始刷新，设置当前为刷新状态
                //swipeRefreshLayout.setRefreshing(true);

                // 这里是主线程
                // 一些比较耗时的操作，比如联网获取数据，需要放到子线程去执行
                // TODO 获取数据
                final Random random = new Random();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(getActivity(), "刷新了一条数据", Toast.LENGTH_SHORT).show();

                        // 加载完数据设置为不刷新状态，将下拉进度收起来
                        swipeRefresh.setRefreshing(false);
                    }
                }, 1200);

            }
        });


        //搜索框下方提示词
        initSearchText();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        RecyclerView recyclerView = view.findViewById(R.id.SearchText);
        recyclerView.setLayoutManager(layoutManager);
        SearchTextAdapter adapter = new SearchTextAdapter(getActivity(), searchText);
        recyclerView.setAdapter(adapter);


        //图片轮播
        ViewGroup group = view.findViewById(R.id.viewGroup);
        viewPager = view.findViewById(R.id.IndexViewPager);

        //载入图片资源ID
        imgIdArray = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,};


        //将点点加入到ViewGroup中
        tips = new ImageView[imgIdArray.length];
        for (int i = 0; i < tips.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(10, 10));
            tips[i] = imageView;
            if (i == 0) {
                tips[i].setBackgroundResource(R.drawable.focused);
            } else {
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
        for (int i = 0; i < mImageViews.length; i++) {
            ImageView imageView = new ImageView(getActivity());
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


        replaceFragment(new ShowMember());//初始展示项目
        view.findViewById(R.id.showMemberButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//展示项目变更
                replaceFragment(new ShowMember());
            }
        });
        view.findViewById(R.id.showQuestionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ShowQuestion());
            }
        });
        return view;
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
     * //@paramselectItems
     */
    private void setImageBackground(int selectItems) {
        for (int i = 0; i < tips.length; i++) {
            if (i == selectItems) {
                tips[i].setBackgroundResource(R.drawable.focused);
            } else {
                tips[i].setBackgroundResource(R.drawable.unfocused);
            }
        }
    }

    //设置搜索提示词传入数据
    private void initSearchText() {
        for (int i = 0; i < 20; i++) {
            Main_RecycleItemClass str = new Main_RecycleItemClass("xxxx");
            searchText.add(str);
        }
    }

    public void replaceFragment(Fragment fragment) {
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction()
                    //.addToBackStack(null) //支持返回键,否则点返回直接退出app
                    .replace(R.id.little_Main_Screen, fragment)
                    .commit();
        }
    }
}