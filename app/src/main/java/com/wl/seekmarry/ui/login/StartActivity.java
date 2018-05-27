package com.wl.seekmarry.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wl.seekmarry.R;
import com.wl.seekmarry.base.BaseActivity;
import com.wl.seekmarry.base.MyPageAdapter;
import com.wl.seekmarry.ui.home.HomeActivity;
import com.wl.seekmarry.ui.login.fragment.GuildFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ${温宇航} on 2018/5/27.
 * 启动页
 */

public class StartActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @Bind(R.id.start_viewpage)
    ViewPager startViewpage;
    @Bind(R.id.img_one)
    ImageView imgOne;
    @Bind(R.id.img_two)
    ImageView imgTwo;
    @Bind(R.id.img_three)
    ImageView imgThree;
    @Bind(R.id.bt_start)
    Button btStart;
    private List<Fragment> fragments;
    private MyPageAdapter myPageAdapter;
    private View actionbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    public void init() {
//        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
////            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//亮色时状态栏显示黑字
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//        }
        initData();
        initView();
    }

    /**
     * 初始化数据,添加三个Fragment
     */
    private void initData() {
        fragments = new ArrayList<>();

        Fragment fragment1 = new GuildFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("index", 1);
        fragment1.setArguments(bundle1);
        fragments.add(fragment1);

        Fragment fragment2 = new GuildFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("index", 2);
        fragment2.setArguments(bundle2);
        fragments.add(fragment2);

        Fragment fragment3 = new GuildFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("index", 3);
        fragment3.setArguments(bundle3);
        fragments.add(fragment3);
    }

    /**
     * 设置ViewPager的适配器和滑动监听
     */
    private void initView() {
        startViewpage.setOffscreenPageLimit(3);
        myPageAdapter = new MyPageAdapter(fragments, getSupportFragmentManager());
        startViewpage.setAdapter(myPageAdapter);
        startViewpage.addOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 根据页面不同动态改变红点和在最后一页显示立即体验按钮
     *
     * @param position
     */
    @Override
    public void onPageSelected(int position) {
        btStart.setVisibility(View.GONE);
        imgOne.setImageResource(R.mipmap.dot_normal);
        imgTwo.setImageResource(R.mipmap.dot_normal);
        imgThree.setImageResource(R.mipmap.dot_normal);
        if (position == 0) {
            imgOne.setImageResource(R.mipmap.dot_focus);
        } else if (position == 1) {
            imgTwo.setImageResource(R.mipmap.dot_focus);
        } else {
            imgThree.setImageResource(R.mipmap.dot_focus);
            btStart.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @OnClick(R.id.bt_start)
    public void onViewClicked() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

}
