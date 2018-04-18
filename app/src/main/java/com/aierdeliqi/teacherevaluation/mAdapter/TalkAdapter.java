package com.aierdeliqi.teacherevaluation.mAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aierdeliqi.teacherevaluation.R;

import java.util.LinkedList;

public class TalkAdapter extends BaseAdapter {
    private LinkedList<Talks> mData;
    private Context mContex;

    public TalkAdapter(LinkedList<Talks> mData, Context mContext) {
        this.mContex = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(mContex).inflate(R.layout.list_item, viewGroup, false);
            holder = new ViewHolder();
            holder.tv_name1 = view.findViewById(R.id.tv_name1);
            holder.tv_teacher = view.findViewById(R.id.tv_teacher);
            holder.tv_time = view.findViewById(R.id.tv_time);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_name1.setText(mData.get(i).getSpeaker());
        holder.tv_teacher.setText(mData.get(i).getTeacher());
        holder.tv_time.setText(mData.get(i).getTimes());
        return view;
    }

    static class ViewHolder{
        TextView tv_name1;
        TextView tv_teacher;
        TextView tv_time;
    }

}
