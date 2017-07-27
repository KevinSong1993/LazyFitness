package com.lazyfitness.lazyfitness.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.lazyfitness.lazyfitness.MainActivity;
import com.lazyfitness.lazyfitness.R;
import com.lazyfitness.lazyfitness.SearchActivity;
import com.lazyfitness.lazyfitness.widget.PullToRrefresh.PullToRefreshView;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends Fragment {

    private static final long REFRESH_DELAY = 500;
    private PullToRefreshView mPullToRefreshView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        final ListView list = (ListView)view.findViewById(R.id.list_view);
        //生成动态数组，并且转载数据
        final ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        final HashMap<String, String> map = new HashMap<String, String>();
        for(int i=0;i<1;i++)
        {
            map.put("ItemTitle", "This is Title.....");
            map.put("ItemText", "This is text.....");
            mylist.add(map);
        }
        //生成适配器，数组===》ListItem
        SimpleAdapter mSchedule = new SimpleAdapter(getContext(),mylist,R.layout.my_listitem,
                new String[] {"ItemTitle", "ItemText"},new int[] {R.id.ItemTitle,R.id.ItemText});
        list.setAdapter(mSchedule);

        mPullToRefreshView = (PullToRefreshView) view.findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                        //生成动态数组，并且转载数据
                        map.put("ItemTitle", "This is Title.....");
                        map.put("ItemText", "This is text.....");
                        mylist.add(map);
                        //生成适配器，数组===》ListItem
                        SimpleAdapter mSchedule = new SimpleAdapter(getContext(),mylist,R.layout.my_listitem,
                                new String[] {"ItemTitle", "ItemText"},new int[] {R.id.ItemTitle,R.id.ItemText});
                        list.setAdapter(mSchedule);
                    }
                }, REFRESH_DELAY);

            }
        });

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
