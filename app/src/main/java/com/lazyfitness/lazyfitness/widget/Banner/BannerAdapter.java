package com.lazyfitness.lazyfitness.widget.Banner;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class BannerAdapter<T extends View> extends PagerAdapter{
    private Context mContext;
    private List<T> mData;

    public BannerAdapter(Context Context,List Data){
        this.mContext = Context;
        this.mData = Data;
    }

    @Override
    public int getCount() {
//        return mData == null || mData.isEmpty() ? 0 : mData.size() + 2;
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mData.get(position));

        return mData.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mData.get(position));
    }
}
