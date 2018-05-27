package com.wl.seekmarry.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 温宇航 on 2017/12/20.
 * 6.0动态权限管理
 */

public class PermissionUtils {
    private static final int CODE_PERMISSION = 4;
    private static List<String> list;            //用户未授权集合
    private static List<String> permission_List ; //用户所需权限管理
    private static PermissionUtils permissionUtils;
    private PermissionLisenter lisenter;
    private String openPer;                                 //所触发成功的权限

    private boolean FLAG_PERMISSION = true;                 //权限状态


    /**
     * 实例化单例对象
     *
     * @return
     */
    public static PermissionUtils getInstance() {
        if (permissionUtils == null) {
            synchronized (PermissionUtils.class) {
                if (permissionUtils == null) {
                    permissionUtils = new PermissionUtils();
                }
            }
        }
        return permissionUtils;
    }


    /**
     * 初始化所需权限
     */
    public static void addPermission(List<String> list) {
        permission_List = new ArrayList<String>();
        permission_List.addAll(list);
    }

    /**
     * 首次创建用户授权权限
     *
     * @param context             当前页面上下文对象
     */
    public void obtainPermission(Activity context) {
        inspect(context, permission_List);
    }

    /**
     * 用户检查权限
     * @param context              当前页面上下文对象
     * @param permission           所需检查权限集合
     * @return
     */
    public PermissionUtils inspect(Activity context, List<String> permission) {
//Android API  > 23
        if (permission.size() > 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                list = new ArrayList<>();
                //检查所需权限
                for (int i = 0; i < permission.size(); i++) {
                    if (context.checkSelfPermission(permission.get(i)) != PackageManager.PERMISSION_GRANTED) {
                        //未授权的权限直接   存储起来
                        list.add(permission.get(i));

                        if (!ActivityCompat.shouldShowRequestPermissionRationale(context, permission.get(i))) {
                            //权限请求失败，选中“不再提示”选项
                            FLAG_PERMISSION = true;

                        } else {
                            //权限请求失败，但未选中“不再提示”选项
                            FLAG_PERMISSION = false;
                        }
                    }
                }

                if (list.size() != 0) {
                    //  开启授权
                    context.requestPermissions(list.toArray(new String[list.size()]), CODE_PERMISSION);
                }
            }
        }
        return getInstance();
    }


    /**
     * 接收权限返回状态
     *
     * @param context                     当前页面上下文对象
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    public void onRequestPermissionsResult(Activity context, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] == -1) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(context, permissions[i])) {
                    //权限请求失败，选中“不再提示”选项
                    FLAG_PERMISSION = true;
                } else {
                    //权限请求失败，但未选中“不再提示”选项
                    FLAG_PERMISSION = false;
                }
                break;
            } else if (grantResults[i] == 0) {
                //授权成功
                FLAG_PERMISSION = true;
                //授权后直接触成功方法        grantPerSuccess()
                if (permissions[i].equals(openPer)) {
                    lisenter.grantPerSuccess();
                }
                return;
            }
        }
    }

    /**
     * 设置权限监听回调
     *
     * @param openPer            授指定权限  触发授权成功方法
     * @param lisenter           权限监听接口
     */
    public void setOnPerLisenter(String openPer, PermissionLisenter lisenter) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.lisenter = lisenter;
            this.openPer = openPer;
            try {
                lisenter.grantPer();
                if (FLAG_PERMISSION) {
                    lisenter.grantPerSuccess();
                }
            } catch (Exception e) {
                lisenter.grantPerBan();
            }
        }else {
            return;
        }
    }


    /**
     * 权限监听接口
     */
    public interface PermissionLisenter {
        /**
         * 检查并授权
         */
        void grantPer();

        /**
         * 授权成功
         */
        void grantPerSuccess();

        /**
         * 禁止授权
         */
        void grantPerBan();
    }
}
