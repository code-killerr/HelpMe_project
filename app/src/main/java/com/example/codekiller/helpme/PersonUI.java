package com.example.codekiller.helpme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PersonUI extends Fragment {
    public PersonUI(){}
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_person_ui,container,false);
        return view;


    }

}

