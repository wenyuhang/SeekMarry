package com.wl.seekmarry.ui.home;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.wl.seekmarry.R;
import com.wl.seekmarry.base.BaseActivity;
import com.yoawo.example.shineButton.ShineButton;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ${温宇航} on 2018/5/28.
 */

public class TwitterActivity extends BaseActivity {
    @Bind(R.id.po_image0)
    ShineButton poImage0;
    @Bind(R.id.po_image1)
    ShineButton poImage1;
    @Bind(R.id.po_image2)
    ShineButton poImage2;
    @Bind(R.id.po_image3)
    ShineButton poImage3;
    @Bind(R.id.wrapper)
    LinearLayout linearLayout;
    @Bind(R.id.btn_list_demo)
    Button btnListDemo;
    @Bind(R.id.btn_fragment_demo)
    Button btnFragmentDemo;
    @Bind(R.id.container)
    LinearLayout container;

    @Override
    public int getLayoutId() {
        return R.layout.activity_twitter;
    }

    @Override
    public void init() {
        ShineButton shineButtonJava = new ShineButton(this);

        shineButtonJava.setBtnColor(Color.GRAY);
        shineButtonJava.setBtnFillColor(Color.RED);
        shineButtonJava.setShapeResource(R.raw.heart);
        shineButtonJava.setAllowRandomColor(true);
        shineButtonJava.setShineSize(100);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
        shineButtonJava.setLayoutParams(layoutParams);
        if (linearLayout != null) {
            linearLayout.addView(shineButtonJava);
        }
    }


    @OnClick({R.id.po_image0, R.id.po_image1, R.id.po_image2, R.id.po_image3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.po_image0:
                break;
            case R.id.po_image1:
                break;
            case R.id.po_image2:
                break;
            case R.id.po_image3:
                break;
        }
    }
}
