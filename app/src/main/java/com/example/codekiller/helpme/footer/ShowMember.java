package com.example.codekiller.helpme.footer;

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

public class ShowMember extends Fragment {
    private List<Main_RecycleItemClass> mMemberList = new ArrayList<>();

    public ShowMember() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.showmember_layout, container, false);


        initMember();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView recyclerView = view.findViewById(R.id.showMember_Recycle);
        recyclerView.setLayoutManager(layoutManager);
        ShowMemberAdapter adapter = new ShowMemberAdapter(getActivity(), mMemberList);
        recyclerView.setAdapter(adapter);


        return view;
    }

    private void initMember() {//初始化导入数据
        for (int i = 0; i < 10; i++) {
            Main_RecycleItemClass data = new Main_RecycleItemClass("hello", R.drawable.a1);
            mMemberList.add(data);
        }
    }
}
