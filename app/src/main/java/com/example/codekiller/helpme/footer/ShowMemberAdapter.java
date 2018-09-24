package com.example.codekiller.helpme.footer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.codekiller.helpme.R;

import java.util.List;

public class ShowMemberAdapter extends RecyclerView.Adapter<ShowMemberAdapter.RecycleHolder> {
    private Context context;
    private List<Main_RecycleItemClass> mMember = null;
    public ShowMemberAdapter(Context context, List<Main_RecycleItemClass> list){
        this.context = context;
        this.mMember = list;
    }//构造函数
    public void  setList(List<Main_RecycleItemClass> list){
        this.mMember = list;
        notifyDataSetChanged();//强制调用getView来刷新每个Item的内容。
    }
    static  class RecycleHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        private RecycleHolder(View view){
            super(view);
            textView = view.findViewById(R.id.memberIntroduce);
            imageView = view.findViewById(R.id.memberPic);
        }
    }
    @Override
    public RecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.showmember_recycle, parent, false);
        RecycleHolder holder = new RecycleHolder(view);
        return holder;
    }//调用相关布局

    @Override
    public void onBindViewHolder(RecycleHolder holder, int positon){
        Main_RecycleItemClass memberMessage = mMember.get(positon);
        holder.textView.setText(memberMessage.getMemberIntroduce());
        holder.imageView.setImageResource(memberMessage.getMemberImage());
    }//调用相关数据
    @Override
    public int getItemCount(){
        return mMember.size();
    }//返回数据数量长度
}
