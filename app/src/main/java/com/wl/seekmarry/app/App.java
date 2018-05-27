package com.wl.seekmarry.app;

import android.app.Application;

import com.wl.seekmarry.base.BaseActivity;

/**
 * Created by ${温宇航} on 2018/5/27.
 */

public class App extends Application{
    public static BaseActivity context = null;
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
