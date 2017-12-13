package com.lzw.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 商城
 * Created by liufy on 17/6/14.
 */

public class WalletFragment extends Fragment {
    TextView content;

    private View rootView;

    private String mFrom;
    public static WalletFragment newInstance(String from){
        WalletFragment fragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from",from);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mFrom = getArguments().getString("from");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.shopping_mall_fragment_layout, container, false);
        content = (TextView) rootView.findViewById(R.id.fragment_content);
        content.setText("WalletFragment");
        return rootView;
    }

}
