package com.yoawo.example.slideout;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.yoawo.example.slideout.factory.SlideFactory;
import com.yoawo.example.slideout.utils.DensityUtil;
import com.yoawo.example.slideout.utils.SkipUtils;
import com.yoawo.example.slideout.view.D;
import com.yoawo.example.slideout.view.OnViewChangeListener;


public class SlideActivity extends AppCompatActivity {
    RelativeLayout bgLayout;
    public static OnViewChangeListener onViewChangeListener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_slide);
//        bgLayout = (RelativeLayout) findViewById(R.id.activity_slide);
    }

    public void jumpOut(View view) {
        //模糊背景退出
        SlideFactory factory = new SlideFactory();
        factory.setDuration(500)
                .setIS_DRAG_LEFT(false)
                .setIS_DRAG_RIGHT(true)
                .setMOVE_MODE(D.MOVE_LEVEL)
                .setBG_MODE(D.BG_BLURRY)
                .setBLUR_RADIUS(15)
                .setBluringBg(bgLayout)
                .setOVERLAY_COLOR(Color.argb(99, 0, 0, 0))
                .setSLIDE_COE(DensityUtil.dip2px(SlideActivity.this, 120));

        SkipUtils.gotoActivity(SlideActivity.this, ExitActivity.class, factory);
    }

    public static void setOnViewChangeListener(OnViewChangeListener onViewChangeListener) {
        SlideActivity.onViewChangeListener = onViewChangeListener;
    }

    private static ValueAnimator.AnimatorUpdateListener listener = new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            if (onViewChangeListener != null) onViewChangeListener.onChange();
        }
    };
}
