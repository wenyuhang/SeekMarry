package com.wl.seekmarry.config;

/**
 * Created by 温宇航 on 2017/9/21.
 * URL管理
 */

public class Urls {



    //*页面加载失败
    public static final String NOT_FOUND_PAGE = "file:///android_asset/error.html";

    //*服务器地址
    public static String BASEURL = "https://super.api.yoawo.com/";

    //*baseimg
    public static final String BASE_IMGURL = "https://oss.yoawo.com/";

    //*现金交易服务器地址
    public static final String MONEY_BASEURL = "http://app.yoawo.com/";

    //*微信服务器地址
    public static final String BASE_WXURL = "https://api.weixin.qq.com/sns/";

    //*获取微信   openID
    public static final String GET_WXMESSAGE = "oauth2/access_token";

    //*获取微信用户信息
    public static final String GET_WXINFO = "userinfo";

    //*微信登录
    public static final String WX_LOGIN = "wx/wx_app_auth?gender&avatarUrl&nickName&union_id";

    //*获取用户个人信息
    public static final String USER_INFO = "Apis/my_info";

    //*更新个人信息
    public static final String UPDATE_INFO = "Apis/update_info";

    //*微名片的编辑
    public static final String UPDATE_TINY_CARD = "Apis/card_add_depose";

    //*获取微名片信息
    public static final String GET_TINY_CARD = "Apis/card_info";

    //*获取微名片分类
    public static final String GET_TINY_CARD_CATEGORY = "Apis/get_card_cate";

    //*开放城市列表
    public static final String OPEN_CITY = "Apis/open_city";

    //*发起钞票雨基本资料接口
    public static final String CREAT_RAIN_INFO = "Apis/coin_basic";

    //*钞票雨添加代金券
    public static final String CREAT_RAIN_CASH = "Apis/coin_pkg_voucher";

    //*钞票雨添加优惠券
    public static final String CREAT_RAIN_COUPON = "Apis/coin_pkg_coupon";

    //*钞票雨添加广告文案
    public static final String ADD_RAIN_TEXT_ADS = "Apis/coin_add_ad";

    //*钞票雨添加广告图
    public static final String ADD_RAIN_IMG_ADS = "Apis/coin_app_thumb";

    //*删除活动广告
    public static final String DELETE_ACTIV_ADS = "Apis/coin_adv_del";

    //*选择充值套餐
    public static final String OPT_RECHARGE_SET = "Apis/coin_package";

    //*钞票雨创建活动
    public static final String CREAT_RAIN_ACTIV = "Apis/coin_detail";

    //*全民推广
    public static final String CREAT_PULL_INFO = "Apis/spread_base";

    //*全民推广保存赏金设置
    public static final String PULL_SAVE_DATA = "Apis/spread_reward";














    //*获取支付宝支付信息
    public static final String GET_ALIPAY_ORDERINFO = "api.php/app/Alipay/getOrderSn";

    //*获取微信支付信息
    public static final String GET_WXPAY_ORDERINFO = "api.php/app/Weixin/getOrderSn";

    //*钞票雨活动支付（微信）
    public static final String GET_WXPAY_RAIN_ACTIV = "Pay/coin/get_sign";
}
