package com.lazyfitness.lazyfitness.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.lazyfitness.lazyfitness.R;
import com.lazyfitness.lazyfitness.SearchActivity;
import com.lazyfitness.lazyfitness.adapter.HomeAdapter;
import com.lazyfitness.lazyfitness.widget.PullToRrefresh.PullToRefreshView;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends Fragment {

    private static final long REFRESH_DELAY = 500;
    private PullToRefreshView mPullToRefreshView;
    private HomeAdapter homeAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ListView list = (ListView)view.findViewById(R.id.listView);
        list.setOverScrollMode(View.OVER_SCROLL_NEVER);
        //下拉刷新
        mPullToRefreshView = (PullToRefreshView) view.findViewById(R.id.pullToRefresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, REFRESH_DELAY);

            }
        });
        //数据
        ArrayList<HashMap<String,String>> arrayList = new ArrayList<HashMap<String, String>>();
        for (int i=0;i<30;i++){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("Title","Title "+i);
            hashMap.put("Text","Text "+i);
            arrayList.add(hashMap);
        }

        homeAdapter = new HomeAdapter(arrayList,getContext());
        list.setAdapter(homeAdapter);



        //首页搜索栏
        LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.search);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),SearchActivity.class));
            }
        });

        return view;
    }


}
