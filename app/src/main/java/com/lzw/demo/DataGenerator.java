package com.lzw.demo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zhouwei on 17/4/23.
 */

public class DataGenerator {

    public static final int[] mTabRes = new int[]{
            R.drawable.tab_home_selector,
            R.drawable.tab_discovery_selector,
            R.drawable.tab_attention_selector,
            R.drawable.tab_profile_selector};
    public static final int[] mTabResPressed = new int[]{
            R.mipmap.ic_tab_strip_icon_feed_selected,
            R.mipmap.ic_tab_strip_icon_category_selected,
            R.mipmap.ic_tab_strip_icon_pgc_selected,
            R.mipmap.ic_tab_strip_icon_profile_selected};
    public static final String[] mTabTitle = new String[]{"收款", "钱包", "商城", "我"};

    public static Fragment[] getFragments(String from) {
        Fragment fragments[] = new Fragment[4];
        fragments[0] = CollectionFragment.newInstance(from);
        fragments[1] = WalletFragment.newInstance(from);
        fragments[2] = ShoppingMallFragment.newInstance(from);
        fragments[3] = ProfileFragment.newInstance(from);
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_tab_content, null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(DataGenerator.mTabRes[position]);
        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
        tabText.setText(mTabTitle[position]);
        return view;
    }


}
