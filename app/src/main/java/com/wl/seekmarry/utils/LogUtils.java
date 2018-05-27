package com.wl.seekmarry.utils;

import android.util.Log;

/**
 * Created by 温宇航 on 2017/9/21.
 */

public class LogUtils {
    private static boolean tolog=true;
    public static void d(String tag, String msg){
        if(tolog){
            Log.d(tag,msg);
        }
    }
}
