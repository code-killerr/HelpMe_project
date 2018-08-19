package com.example.codekiller.helpme.footer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.codekiller.helpme.PersonUI;
import com.example.codekiller.helpme.R;

public class BottomAll extends Fragment{
    public BottomAll(){}

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
                replaceFragment(new PersonUI());
            }
        });

        view.findViewById(R.id.BottomButton3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                replaceFragment(new PersonUI());
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
