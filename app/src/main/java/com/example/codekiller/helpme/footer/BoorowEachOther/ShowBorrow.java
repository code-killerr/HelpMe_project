package com.example.codekiller.helpme.footer.BoorowEachOther;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.codekiller.helpme.R;

import java.util.ArrayList;
import java.util.List;

public class ShowBorrow extends Fragment{
    private List<Borrow_RecycleItemClass>borrowList = new ArrayList<>();
    public ShowBorrow(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.showborrowthings_layout,container,false);
        //设置recycler
        initMember();
        RecyclerView recyclerView = view.findViewById(R.id.showBorrow_Recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        ShowBorrowAdapter adapter = new ShowBorrowAdapter(getActivity(),borrowList);
        recyclerView.setAdapter(adapter);


        return view;
    }

    private void initMember() {//初始化导入数据
        for (int i = 0; i < 10; i++) {
            Borrow_RecycleItemClass data = new Borrow_RecycleItemClass("hello", "this is something in here", R.drawable.a1);
            borrowList.add(data);
        }
    }

}
