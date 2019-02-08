package com.example.codekiller.helpme;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.codekiller.helpme.footer.BoorowEachOther.ShowBorrow;
import com.example.codekiller.helpme.footer.BoorowEachOther.ShowLend;

public class BorrowEachOther extends Fragment {
    private View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_borroweachother,container,false);

        SearchView topSearch = view.findViewById(R.id.TopSearch);
        topSearch.setSubmitButtonEnabled(true);//是否添加搜索按鈕
        topSearch.setIconifiedByDefault(true);
        //topSearch.onActionViewExpanded();//是否展开搜索框
        topSearch.setBackgroundColor(0xFFFFFFFF);
        //设置初始fragment
        replaceFragment(new ShowBorrow());
        view.findViewById(R.id.showBorrowButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ShowBorrow());
            }
        });

        view.findViewById(R.id.showLendButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ShowLend());
    }
});
        return view;
    }

    //变换fragment
    private void replaceFragment(Fragment fragment) {
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction()
                    //.addToBackStack(null) //支持返回键,否则点返回直接退出app
                    .replace(R.id.little_Main_Screen, fragment)
                    .commit();
        }
    }
}
