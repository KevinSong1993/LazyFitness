package com.lazyfitness.lazyfitness.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lazyfitness.lazyfitness.R;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends BaseAdapter {

    private Context mContext;
    private List mdatas;

    public HomeAdapter(List mdatas,Context mContext){
        this.mdatas = mdatas;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return mdatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mdatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(mContext).inflate(R.layout.my_listitem,parent,false);
        TextView itemTitle = (TextView)convertView.findViewById(R.id.ItemTitle);
        TextView itemText = (TextView)convertView.findViewById(R.id.ItemText);


        return null;
    }
}
