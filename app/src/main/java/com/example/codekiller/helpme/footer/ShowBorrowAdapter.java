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

public class ShowBorrowAdapter extends RecyclerView.Adapter<ShowBorrowAdapter.RecycleHolder> {
    private Context context;
    private List<Borrow_RecycleItemClass>borrowThings = null;
    public ShowBorrowAdapter(Context context,List<Borrow_RecycleItemClass>list){
        this.context = context;
        this.borrowThings = list;
    }

    public void setBorrowThings(List<Borrow_RecycleItemClass> borrowThings) {//重新更改表内容
        this.borrowThings = borrowThings;
        notifyDataSetChanged();//强制调用getView来刷新每个Item的内容。
    }

    static class RecycleHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        TextView introduceTextView;
        ImageView imageView;
        private RecycleHolder(View view){//用来临时储存数据的持有者类，提高加载效率
            super(view);
            titleTextView = view.findViewById(R.id.borrow_title);
            introduceTextView = view.findViewById(R.id.borrow_Introduce);
            imageView = view.findViewById(R.id.borrow_Introduce);

        }
    }
    @Override
        public RecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.showborrowthings_recycle, parent, false);
            RecycleHolder holder = new RecycleHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(RecycleHolder holder, int positon){
        Borrow_RecycleItemClass memberMessage = borrowThings.get(positon);
        holder.titleTextView.setText(memberMessage.getTitle());
        holder.introduceTextView.setText(memberMessage.getIntroduce());
        holder.imageView.setImageResource(memberMessage.getImage());
    }//调用相关数据
    @Override
    public int getItemCount(){
        return borrowThings.size();
    }//返回数据数量长度,没有当前类会报错
}
