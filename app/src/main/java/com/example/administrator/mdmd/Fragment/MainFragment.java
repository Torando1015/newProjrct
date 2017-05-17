package com.example.administrator.mdmd.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.example.administrator.mdmd.Listener.AdListener;
import com.example.administrator.mdmd.R;
import com.example.administrator.mdmd.Adapter.RecyclerAdapter;
import com.example.administrator.mdmd.Entity.RecyclerBean;
import com.example.administrator.mdmd.Listener.RecyclerItemClickListener;
import com.example.administrator.mdmd.Adapter.RecyclerVpAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * Created by Administrator on 2017/4/25.
 */

public class MainFragment extends Fragment {

    RecyclerView recyclerView;
    AutoScrollViewPager vpBooks;
    LinearLayout llPoint;
    RecyclerViewHeader header;
    RecyclerView recyclerViewGird;

    private List<RecyclerBean> mList = new ArrayList<>();
    private String[] title = {"测试_01", "测试_02", "测试_03", "测试_04", "测试_05", "测试_06", "测试_07", "测试_08", "测试_09", "测试_10"};
    private int[] imgPath = {R.mipmap.ic_recyclerview_01, R.mipmap.ic_recyclerview_02, R.mipmap.ic_recyclerview_03, R.mipmap.ic_recyclerview_04, R.mipmap.ic_recyclerview_05,
            R.mipmap.ic_recyclerview_06, R.mipmap.ic_recyclerview_07, R.mipmap.ic_recyclerview_08, R.mipmap.ic_recyclerview_09, R.mipmap.ic_recyclerview_10};
    private int[] vpImgPath = {R.mipmap.ic_viewpager_01, R.mipmap.ic_viewpager_02, R.mipmap.ic_viewpager_03};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        vpBooks = (AutoScrollViewPager) view.findViewById(R.id.vp_books);
        llPoint = (LinearLayout) view.findViewById(R.id.ll_point);
        header = (RecyclerViewHeader) view.findViewById(R.id.header);
        recyclerViewGird = (RecyclerView) view.findViewById(R.id.recyclerView_gird);

        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewHeader header = (RecyclerViewHeader) view.findViewById(R.id.header);
        AutoScrollViewPager viewPager = (AutoScrollViewPager) view.findViewById(R.id.vp_books);
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < vpImgPath.length; i++) {
            RecyclerVpFragment recyclerVpFragment = RecyclerVpFragment.newInstance(vpImgPath[i]);
            fragmentList.add(recyclerVpFragment);
        }
        RecyclerVpAdapter bAdapter = new RecyclerVpAdapter(getChildFragmentManager(), fragmentList);
        viewPager.setAdapter(bAdapter);
        LinearLayout llPoint = (LinearLayout) header.findViewById(R.id.ll_point);
        viewPager.addOnPageChangeListener(new AdListener(AdListener.setImageView(getActivity(), llPoint, fragmentList)));
        viewPager.setCurrentItem(0);
        viewPager.startAutoScroll();
        viewPager.setInterval(5000);
        //开启Viewpager的自动轮播
        header.attachTo(recyclerView, true);
        setData();
        RecyclerAdapter mAdapter = new RecyclerAdapter(getActivity(), mList);
        //RecyclerView子项的点击事件
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), mAdapter.onItemClickListener));
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void setData() {
        mList.clear();
        for (int i = 0; i < title.length; i++) {
            RecyclerBean recyclerBean = new RecyclerBean();
            recyclerBean.setImg(imgPath[i]);
            recyclerBean.setInfo(title[i]);
            recyclerBean.setTitle(title[i]);
            recyclerBean.setCatalog(title[i]);
            recyclerBean.setAuthor_intro(title[i]);
            recyclerBean.setSummary(title[i]);
            recyclerBean.setImglarge(imgPath[i]);
            mList.add(recyclerBean);
        }
    }
}
