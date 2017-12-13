package com.lzw.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * 收款
 * Created by Administrator on 2017/6/15 0015.
 */

public class CollectionFragment extends Fragment {
    TextView content;
    private View rootView;
    private String mFrom;
    private static final String TAG = "CollectionFragment".getClass().getSimpleName();
    public static CollectionFragment newInstance(String from) {
        CollectionFragment fragment = new CollectionFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from", from);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        if (getArguments() != null) {
            mFrom = getArguments().getString("from");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.shopping_mall_fragment_layout, container, false);
        content = (TextView) rootView.findViewById(R.id.fragment_content);
        content.setText("CollectionFragment");
        return rootView;
    }


}
