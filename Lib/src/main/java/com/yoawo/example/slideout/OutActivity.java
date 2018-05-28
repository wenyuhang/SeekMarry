package com.yoawo.example.slideout;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import com.yoawo.example.slideout.view.BaseSlideActivity;
import com.yoawo.example.slideout.view.OnViewChangeListener;
import com.yoawo.example.slideout.view.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class OutActivity extends BaseSlideActivity implements OnViewChangeListener {
    private ViewPager viewPager;
    private List<View> views;
    private OutActivity.MyImageView view;

    private ViewPagerAdapter pagerAdapter;

    Bitmap b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initData();
    }

    @Override
    public int getLayoutID() {
//        return R.layout.act_blurry_slide;
        return 0;
    }

    public void onclick(View view) {
        finish();
    }


    private void init() {
//        viewPager = (ViewPager) findViewById(R.id.act_dim_viewpager);

        SlideActivity.setOnViewChangeListener(this);

    }

    private void initData() {
//        b1 = BitmapFactory.decodeResource(getResources(), R.mipmap.p1);
        views = new ArrayList<View>();
        view = new OutActivity.MyImageView();
        views.add(view.getView());
        view = new OutActivity.MyImageView();
        views.add(view.getView());
        view = new OutActivity.MyImageView();
        views.add(view.getView());
        view = new OutActivity.MyImageView();
        views.add(view.getView());
        view = new OutActivity.MyImageView();
        views.add(view.getView());
        pagerAdapter = new ViewPagerAdapter(views);

        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new OutActivity.PageChange());
        setCanDragLeft(false);
        setCanDragRight(true);
    }


    class PageChange implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int page, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int page) {
            switch (page) {
                case 0:
                    setCanDragLeft(false);
                    setCanDragRight(true);
                    break;
                case 1:
                case 2:
                case 3:
                    setCanDragLeft(false);
                    setCanDragRight(false);
                    break;
                case 4:
                    setCanDragLeft(true);
                    setCanDragRight(false);
                    break;
            }
        }

    }

    class MyImageView extends View {
        View view;

        public MyImageView() {
            super(OutActivity.this);
            init();
        }

        public MyImageView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            init();
        }

        private void init() {

//            view = inflate(OutActivity.this, R.layout.view_pager,
//                    null);
//            ImageView imageView;
//            imageView = (ImageView) view.findViewById(R.id.view_pager_img);
//            imageView.setImageBitmap(b1);
        }

        public View getView() {
            return view;
        }
    }

    @Override
    public void onChange() {
        updateBgBluringView();//更新模糊背景视图
    }
}

