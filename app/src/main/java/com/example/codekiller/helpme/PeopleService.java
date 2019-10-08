package com.example.codekiller.helpme;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.codekiller.helpme.footer.BoorowEachOther.ShowBorrow;
import com.example.codekiller.helpme.footer.BoorowEachOther.ShowLend;

public class PeopleService extends Fragment {
    private View view;

    public PeopleService() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_prople_service, container, false);
        return view;
    }
}

