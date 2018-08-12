package com.example.codekiller.helpme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.example.codekiller.helpme.footer.RecycleAdapter;

import java.util.ArrayList;
import java.util.List;

public class Index extends AppCompatActivity {
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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
    }
}

