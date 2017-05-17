package com.example.administrator.mdmd.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.mdmd.R;


public class DetailFragment extends Fragment {

    TextView tvInfo;

    private String mParam1;
    private static final String ARG_PARAM1 = "param1";

    public static DetailFragment newInstance(String param1) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        tvInfo = (TextView) view.findViewById(R.id.tvInfo);
        tvInfo.setText(mParam1);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}