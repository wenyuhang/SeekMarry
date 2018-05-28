package com.yoawo.example.slideout;

import android.os.Bundle;

import com.yoawo.example.slideout.view.BaseSlideActivity;
import com.yoawo.example.slideout.view.OnViewChangeListener;

public class ExitActivity extends BaseSlideActivity implements OnViewChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SlideActivity.setOnViewChangeListener(this);
        setCanDragLeft(false);
        setCanDragRight(false);

    }

    @Override
    public int getLayoutID() {
//        return R.layout.activity_exit;
        return 0;
    }

    @Override
    public void onChange() {
        updateBgBluringView();//更新模糊背景视图
    }
}
