package com.example.administrator.mdmd.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.mdmd.R;

/**
 * Created by Administrator on 2017/4/25.
 */

public class RecyclerVpFragment extends Fragment {

    ImageView ivVp;


    public static RecyclerVpFragment newInstance(int param1) {
        RecyclerVpFragment fragment = new RecyclerVpFragment();
        Bundle args = new Bundle();
        args.putInt("imgpath", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_vp, container, false);
        ivVp = (ImageView) view.findViewById(R.id.iv_vp);
        Bundle bundle = getArguments();
        if (bundle != null) {
            ivVp.setBackgroundResource(bundle.getInt("imgpath"));
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}