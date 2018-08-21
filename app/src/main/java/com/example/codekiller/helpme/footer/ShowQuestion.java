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

public class ShowQuestion extends Fragment {
    private List<Main_RecycleItemClass>mQuestion = new ArrayList<>();
    public ShowQuestion(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.showquestion_layout,container,false);

        initQuestion();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView recyclerView = view.findViewById(R.id.showQuestion_Recycle);
        recyclerView.setLayoutManager(layoutManager);
        ShowQuestionAdapter adapter = new ShowQuestionAdapter(getActivity(),mQuestion);
        recyclerView.setAdapter(adapter);


        return view;
    }

    private void initQuestion(){//初始化导入数据
        for(int i = 0;i<10;i++){
        Main_RecycleItemClass data = new Main_RecycleItemClass("hello","something in here");
        mQuestion.add(data);
        }


    }
}
