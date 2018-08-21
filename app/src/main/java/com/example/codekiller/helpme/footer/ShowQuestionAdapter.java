package com.example.codekiller.helpme.footer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.codekiller.helpme.R;

import java.util.List;

public class ShowQuestionAdapter extends RecyclerView.Adapter <ShowQuestionAdapter.ViewHolder>{
    private List<Main_RecycleItemClass>mQuestion;
    private Context context;
    public ShowQuestionAdapter(Context context, List<Main_RecycleItemClass> questionList){
        this.context = context;
        this.mQuestion = questionList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView qTitle;
        TextView qText;
        //留空加多图片
        public ViewHolder(View view){
            super(view);
            qTitle = view.findViewById(R.id.questionTitle);
            qText = view.findViewById(R.id.questionDescribe);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.showquestion_recycle,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Main_RecycleItemClass question = mQuestion.get(position);
        holder.qTitle.setText(question.getQuestionTitle());
        holder.qText.setText(question.getQuestionDescribe());
    }
    @Override
    public int getItemCount(){
        return mQuestion.size();
    }
}
