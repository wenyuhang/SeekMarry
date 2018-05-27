package com.wl.seekmarry.utils;

/**
 * Created by ${温宇航} on 2018/5/9.
 * oss上传 工具类
 */

public class UpLoadUtils {

    private static UpLoadUtils upLoadUtils;

    /**
     * 实例化单例对象
     *
     * @return
     */
    public static UpLoadUtils getInstance() {
        if (upLoadUtils == null) {
            synchronized (UpLoadUtils.class) {
                if (upLoadUtils == null) {
                    upLoadUtils = new UpLoadUtils();
                }
            }
        }
        return upLoadUtils;
    }

    /**
     * 初始化oss
     * @param activity
     * @return
     */
//    public OSS initOSS(Activity activity) {
////        OSSCredentialProvider credentialProvider = new OSSAuthCredentialsProvider(stsServer);
//        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(App.OSS_KEY_ID, App.OSS_KEY_SECRET);
//        ClientConfiguration conf = new ClientConfiguration();
//        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
//        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
//        conf.setMaxConcurrentRequest(5); // 最大并发请求书，默认5个
//        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次
//        OSS oss = new OSSClient(activity, App.OSS_ENDPOINT, credentialProvider, conf);
//        OSSLog.enableLog();
//        return oss;
//    }
}
