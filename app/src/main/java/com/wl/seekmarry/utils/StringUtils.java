package com.wl.seekmarry.utils;

/**
 * Created by ${温宇航} on 2018/5/10.
 */

public class StringUtils {
    private static StringUtils stringUtils;
    public static StringUtils getInstance() {
        if (stringUtils == null) {
            synchronized (StringUtils.class) {
                if (stringUtils == null) {
                    stringUtils = new StringUtils();
                }
            }
        }
        return stringUtils;
    }

    /**
     * 是否为空
     * @param str
     * @return
     */
    public boolean isEmpty(String str){
        if(str!=null&&str.length()>0){
            return true;
        }
        return false ;
    }
}
