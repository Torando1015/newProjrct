package com.example.administrator.mdmd.Acitvity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.mdmd.R;

import java.util.ArrayList;
import java.util.List;

import github.chenupt.springindicator.SpringIndicator;

/**
 * Created by Administrator on 2017/5/9.
 */

public class SpringIndicatorActivity extends AppCompatActivity {
    private List<View> fragList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indicator);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SpringIndicator indicator = (SpringIndicator) findViewById(R.id.indicator);

        View view = LayoutInflater.from(this).inflate(R.layout.imageview, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.imageview2, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.imageview3, null);
        View view5 = LayoutInflater.from(this).inflate(R.layout.imageview5, null);

        fragList = new ArrayList<>();
        fragList.add(view);
        fragList.add(view2);
        fragList.add(view3);
        fragList.add(view5);

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return fragList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            // 是从ViewGroup中移出当前View
            public void destroyItem(View arg0, int arg1, Object arg2) {
                ((ViewPager) arg0).removeView(fragList.get(arg1));
            }

            // 返回一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
            public Object instantiateItem(View arg0, int arg1) {
                ((ViewPager) arg0).addView(fragList.get(arg1));
                return fragList.get(arg1);
            }

        });
        indicator.setViewPager(viewPager);
    }
}
