package com.aierdeliqi.teacherevaluation.mAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aierdeliqi.teacherevaluation.R;

import java.util.LinkedList;

public class RankingAdapter extends BaseAdapter{
    private LinkedList<Ranking> mData;
    private Context mContext;

    public RankingAdapter(LinkedList<Ranking> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_ranking,parent,false);
            holder = new ViewHolder();
            holder.tv_rankscore = convertView.findViewById(R.id.tv_rankscore);
            holder.tv_rankteacher = convertView.findViewById(R.id.tv_rankteacher);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tv_rankteacher.setText(mData.get(position).getRankteacher());
        holder.tv_rankscore.setText(mData.get(position).getRankscore());
        return convertView;
    }

    static class ViewHolder{
        TextView tv_rankteacher;
        TextView tv_rankscore;
    }
}
