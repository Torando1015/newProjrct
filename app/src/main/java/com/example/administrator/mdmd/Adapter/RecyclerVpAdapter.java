package com.example.administrator.mdmd.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
/**
 * Created by Administrator on 2017/4/25.
 */

public class RecyclerVpAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> list;
    FragmentManager fm;

    public RecyclerVpAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
        this.fm = fm;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int arg0) {
        return list.get(arg0);
    }

}
