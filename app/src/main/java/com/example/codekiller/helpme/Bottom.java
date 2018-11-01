package com.example.codekiller.helpme;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.codekiller.helpme.BorrowEachOther;
import com.example.codekiller.helpme.Main_Screen;
import com.example.codekiller.helpme.PeopleService;
import com.example.codekiller.helpme.PersonUI;
import com.example.codekiller.helpme.R;

public class Bottom extends Fragment{
    public Bottom(){}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.bottom_all,container,false);

        //控制按钮点击事件
        view.findViewById(R.id.BottomButton1).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        replaceFragment(new Main_Screen());
                    }
                });
        view.findViewById(R.id.BottomButton2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                replaceFragment(new BorrowEachOther());
            }
        });

        view.findViewById(R.id.BottomButton3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                replaceFragment(new PeopleService());
            }
        });

        view.findViewById(R.id.BottomButton4).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                replaceFragment(new PersonUI());
            }
        });
        return view;


    }

    private void replaceFragment(Fragment fragment){
        if (getFragmentManager()!=null) {
            getFragmentManager().beginTransaction()
                    //.addToBackStack(null) //支持返回键,否则点返回直接退出app
                    .replace(R.id.Main_Screen, fragment)
                    .commit();
        }
    }
}
