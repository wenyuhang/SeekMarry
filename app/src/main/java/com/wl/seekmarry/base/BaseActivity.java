package com.wl.seekmarry.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.wl.seekmarry.R;
import com.wl.seekmarry.app.App;


/**
 * Created by dongjunkun on 2016/2/2.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.context = this;
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        init();
    }

    /**
     * 加载布局
     * @return
     */
    public abstract int getLayoutId();
    /**
     * 初始化数据
     * @return
     */
    public abstract void init();


    @Override
    protected void onResume() {
        super.onResume();
        App.context = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
