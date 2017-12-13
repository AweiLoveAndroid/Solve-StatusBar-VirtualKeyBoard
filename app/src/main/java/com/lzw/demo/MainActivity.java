package com.lzw.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    Toolbar mToolBar;
    BottomNavigationView mBottomNavigationView;
    TextView home_left;
    TextView toolbar_title;
    private Fragment[]mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragments = DataGenerator.getFragments("BottomNavigationView Tab");
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        home_left = (TextView) findViewById(R.id.home_left);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);

        highApiEffects();
        mToolBar = (Toolbar) getWindow().findViewById(R.id.home_title);
        //mToolBar = (Toolbar) findViewById(R.id.home_title);
        setSupportActionBar(mToolBar);

        init();
    }

    private void init() {
        //手动取消BottomNavigationView的切换动画，去掉这行代码就是默认的效果。
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);

        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onTabItemSelected(item.getItemId());
                return true;
            }
        });
        // 由于第一次进来没有回调onNavigationItemSelected，因此需要手动调用一下切换状态的方法
        onTabItemSelected(R.id.tab_menu_home);
        //mBottomNavigationView.setSelectedItemId(R.id.tab_menu_home);

    }

    //flag 标记 。如果没有这个标记，设置第一个被选中的item在app打开的时候会弹吐司，
    //设置flag就是为了解决这个问题.true表示第一次打开app
    boolean flag=true;

    private void onTabItemSelected(int id){
        Fragment fragment = null;
        switch (id){
            case R.id.tab_menu_home:
                if(flag){
                    fragment = getCurrentItems(0,View.VISIBLE,"收款");
                }
                break;
            case R.id.tab_menu_discovery:
                fragment = getCurrentItems(1,View.VISIBLE,"钱包");
                break;
            case R.id.tab_menu_attention:
                fragment = getCurrentItems(2,View.GONE,"商城");
                break;
            case R.id.tab_menu_profile:
                fragment = getCurrentItems(3,View.GONE,"我");
                break;
            default:
                break;
        }
        if(fragment!=null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.home_container,fragment)
                    .commit();
        }
        flag = false;
    }

    /**
     * 获取当前的fragment
     * @param position  索引
     * @param visibility 设置可见
     * @param title  toolbar标题
     * @return Fragment
     */
    private Fragment getCurrentItems(int position,int visibility,String title){
        Fragment fragment = mFragments[position];
        home_left.setVisibility(visibility);
        toolbar_title.setText(title);
        if(flag && position == 0) {
            flag = false;
        } else {
            Toast.makeText(MainActivity.this, "点击了" + fragment.getClass().getSimpleName(),
                        Toast.LENGTH_SHORT).show();
            flag = true;
        }
        return fragment;
    }



}
