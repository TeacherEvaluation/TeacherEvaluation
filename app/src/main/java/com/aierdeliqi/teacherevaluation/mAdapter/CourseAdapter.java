package com.aierdeliqi.teacherevaluation.mAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aierdeliqi.teacherevaluation.R;

import java.util.LinkedList;

public class CourseAdapter extends BaseAdapter{
    private LinkedList<Coruse> mData;
    private Context mContext;
    public CourseAdapter(LinkedList<Coruse> mData,Context mContext){
        this.mContext = mContext;
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
            view = LayoutInflater.from(mContext).inflate(R.layout.list_course,viewGroup,false);
            holder = new ViewHolder();
            holder.tv_coursename = view.findViewById(R.id.tv_coursename);
            holder.tv_teachername = view.findViewById(R.id.tv_teachername);
            holder.tv_issubmit = view.findViewById(R.id.tv_issubmit);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_teachername.setText(mData.get(i).getTeacherName());
        holder.tv_coursename.setText(mData.get(i).getCoruseName());
        holder.tv_issubmit.setText("前往评价");
        return view;
    }

    static class ViewHolder{
        TextView tv_coursename;
        TextView tv_teachername;
        TextView tv_issubmit;
    }

}
