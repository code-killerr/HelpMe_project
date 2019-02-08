package com.example.codekiller.helpme.footer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.codekiller.helpme.R;
import com.example.codekiller.helpme.footer.MainScreen.Main_RecycleItemClass;

import java.util.List;

public class SearchTextAdapter extends RecyclerView.Adapter<SearchTextAdapter.RecycleHolder> {


    private Context context;
    private List<Main_RecycleItemClass> list = null;
    public SearchTextAdapter(Context context, List<Main_RecycleItemClass> list){
        this.context = context;
        this.list = list;
    }//构造函数
    public void  setList(List<Main_RecycleItemClass> list){
        this.list = list;
        notifyDataSetChanged();//强制调用getView来刷新每个Item的内容。
    }
    class RecycleHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public RecycleHolder(View view){
            super(view);
            textView = view.findViewById(R.id.SearchRecycleText);
        }
    }
    @Override
    public RecycleHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_recycler_activity, parent, false);
        RecycleHolder holder = new RecycleHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecycleHolder holder, int positon){
        Main_RecycleItemClass searchText = list.get(positon);
        holder.textView.setText(searchText.getSearchText());

    }
    @Override
    public int getItemCount(){
        return list.size();
    }
}
