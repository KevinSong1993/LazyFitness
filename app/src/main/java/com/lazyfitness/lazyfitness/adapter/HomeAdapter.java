package com.lazyfitness.lazyfitness.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lazyfitness.lazyfitness.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<HashMap<String, String>> mDatas;

    public HomeAdapter(ArrayList<HashMap<String, String>> mDatas, Context mContext){
        this.mDatas = mDatas;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.my_listitem,parent,false);
            viewHolder.itemTitle = (TextView) convertView.findViewById(R.id.ItemTitle);
            viewHolder.itemText = (TextView) convertView.findViewById(R.id.ItemText);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.itemTitle.setText(mDatas.get(position).get("Title"));
        viewHolder.itemText.setText(mDatas.get(position).get("Text"));

        return convertView;
    }

    private class ViewHolder{
        TextView itemTitle;
        TextView itemText;
    }
}
