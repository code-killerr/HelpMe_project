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

public class ShowLend extends Fragment{
    public ShowLend(){}
    private List<Main_RecycleItemClass> mQuestion = new ArrayList<>();
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
/*生命周期public void onAttach(Context context)
public void onCreate(@Nullable Bundle savedInstanceState)
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
public void onActivityCreated(@Nullable Bundle savedInstanceState)
public void onViewStateRestored(@Nullable Bundle savedInstanceState)
public void onStart()
public void onResume()
public void onPause()
public void onStop()
public void onDestroyView()
public void onDestroy()
public void onDetach()
 */
