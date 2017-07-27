package com.lazyfitness.lazyfitness;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;


import com.lazyfitness.lazyfitness.fragment.GymFragment;
import com.lazyfitness.lazyfitness.fragment.HomeFragment;
import com.lazyfitness.lazyfitness.fragment.OrderFragment;
import com.lazyfitness.lazyfitness.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化首页
        getFragmentManager().beginTransaction().replace(R.id.frame,new HomeFragment()).commit();
        //底部导航栏
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                Fragment fragment;
                switch (checkedId){
                    case R.id.home:
                        fragment = new HomeFragment();
                        getFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
                        break;
                    case R.id.gym:
                        fragment = new GymFragment();
                        getFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
                        break;
                    case R.id.order:
                        fragment = new OrderFragment();
                        getFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
                        break;
                    case R.id.user:
                        fragment = new UserFragment();
                        getFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
                        break;
                }
            }
        });

    }

}
