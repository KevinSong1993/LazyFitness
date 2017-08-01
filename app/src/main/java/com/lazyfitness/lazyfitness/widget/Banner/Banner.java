package com.lazyfitness.lazyfitness.widget.Banner;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class Banner extends FrameLayout {
    private Context mContext;
    private ViewPager mViewPager;
    private BannerAdapter mBannerAdapter;
    //轮播图三部分 图片 文字 指示器

    public Banner(@NonNull Context context) {
        super(context);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //



}
