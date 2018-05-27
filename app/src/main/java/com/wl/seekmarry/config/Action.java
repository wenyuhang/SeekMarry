package com.wl.seekmarry.config;

/**
 * Created by 温宇航 on 2017/11/7.
 */

public class Action {


    //    返回code值
    public static final int CD_SUCCESS_CODE = 1000;              //返回成功





    //    OnActivityResult    requestcode值
    public static final int CLOSE = 1000;                    //取消
    public static final int SCAN = 1001;                     //扫一扫
    public static final int TYPE_CAMERA = 1201;              //拉起相机
    public static final int TYPE_ALBUM = 1202;               //相册
    public static final int TYPE_MORE_ALBUM = 1203;          //相册多选
    public static final int TYPE_VIDEO = 1204;               //打开系统媒体库
    public static final int CODE_CROP = 1205;                //图片裁剪
    public static final int CAMERA_ERROR = 1206;             //自定义相机   拍照错误
    public static final int CAMERA_CAPTURE = 1207;           //自定义相机    拍照
    public static final int CAMERA_RECORD = 1208;            //自定义相机    拍摄
    public static final int CAMERA_CUSTOM = 1209;            //拉起自定义相机

    public static final int EDIT_USERNAME= 1501;             //修改用户名称
    public static final int OPT_CATEGORY = 1502;             //选择微名片分类
    public static final int LOCATION_MAP = 1503;             //地图定位
    public static final int CAMERA_RAIN  = 1504;             //拉取媒体库
    public static final int OPT_OPEN_CITY = 1505;            //选择开放城市
    public static final int ADD_TEXT_ADS = 1506;             //添加广告文案
    public static final int ADD_SET_MEAL = 1507;             //选择充值套餐
    public static final int ADD_CASH_COUPON = 1508;          //添加代金券
    public static final int ADD_COUPON = 1509;               //添加优惠券


    //   EventBus    code
    public static final int EB_MONEY_RAIN = 2001;             //发起钞票雨
}
