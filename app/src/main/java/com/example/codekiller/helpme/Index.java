package com.example.codekiller.helpme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.codekiller.helpme.footer.IndexViewPagerAdapter;
import com.example.codekiller.helpme.footer.Main_Screen;
import com.example.codekiller.helpme.footer.RecycleAdapter;

import java.util.ArrayList;
import java.util.List;

public class Index extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        getSupportFragmentManager().beginTransaction().replace(R.id.Main_Screen,new Main_Screen()).commit();

        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

}

