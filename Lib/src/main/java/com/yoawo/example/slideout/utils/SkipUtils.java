package com.yoawo.example.slideout.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;

import com.yoawo.example.a3dtag.R;
import com.yoawo.example.slideout.factory.DimFactory;
import com.yoawo.example.slideout.factory.RevealFactory;
import com.yoawo.example.slideout.factory.SlideFactory;


/**
 * Created by ${温宇航} on 2018/5/28.
 */

public class SkipUtils {

    public static SlideFactory slideFactory = null;
    public static RevealFactory revealFactory = null;
    public static DimFactory dimFactory = null;

    public SkipUtils() {
    }

    /**
     * 跳转activity,代工厂参数
     */
    public static void gotoActivity(Activity activity, Class<?> cls, SlideFactory factory) {
        slideFactory = factory;
        activity.startActivity(new Intent(activity, cls));
        activity.overridePendingTransition(R.anim.alpha_in, R.anim.keep);
    }

    /**
     * 跳转activity,代工厂参数
     */
    public static void gotoActivity(Activity activity, Class<?> cls, RevealFactory factory) {
        revealFactory = factory;
        activity.startActivity(new Intent(activity, cls));
        activity.overridePendingTransition(R.anim.keep, R.anim.keep);
    }


    /**
     * 跳转activity
     */
    public static void gotoActivity(Activity activity, Class<?> cls) {
        activity.startActivity(new Intent(activity, cls));
        activity.overridePendingTransition(R.anim.alpha_in, R.anim.keep);
    }

    /**
     * show dialog method
     */
    public static void showDialog(Context context, Dialog dialog, DimFactory factory) {
        dimFactory = factory;
        dialog.show();
    }

    public static SlideFactory getSlideFactory() {
        if (slideFactory == null) slideFactory = new SlideFactory();
        return slideFactory;
    }

    public static RevealFactory getRevealFactory() {
        if (revealFactory == null) revealFactory = new RevealFactory();
        return revealFactory;
    }


}

