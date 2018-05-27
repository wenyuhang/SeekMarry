package com.wl.seekmarry.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.wl.seekmarry.app.App;


/**
 * Created by 温宇航 on 2017/9/21.
 * Toast管理
*/

public class ToastUtils {
    public static void showToast(String msg){
        Toast toast = Toast.makeText(App.context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,300);
        toast.show();
    }
    public static void showLongToast(String msg){
        Toast.makeText(App.context,msg, Toast.LENGTH_LONG).show();
    }
}
