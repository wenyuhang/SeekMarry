package com.wl.seekmarry.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wl.seekmarry.config.Urls;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.wl.seekmarry.app.App.context;

/**
 * Created by 温宇航 on 2017/9/21.
 * 服务
 */

public class RetrofitService {

    private static Retrofit retrofit;
    private static Api api;
    private static Retrofit retrofitWx;
    private static Api wxApi;

    private RetrofitService() {
    }


    /**
     * 公司域名
     * @return
     */
    public static Api createYoaWo() {
        if (retrofit == null) {
            synchronized (RetrofitService.class) {
                if (retrofit == null) {
//retrofit2访问https
                    SSLSocketFactory sslSocketFactory = new SslContextFactory().getSslSocket(context).getSocketFactory();
                    OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder().sslSocketFactory(sslSocketFactory);
                    retrofit = new Retrofit.Builder()
//                            .client(okHttpClient.build())
                            .baseUrl(Urls.BASEURL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                    api = retrofit.create(Api.class);

                }
            }
        }
        return api;
    }


    /**
     * 微信域名
     * @return
     */
    public static Api createWx() {
        if (retrofitWx == null) {
            synchronized (RetrofitService.class) {
                if (retrofitWx == null) {
                    retrofitWx = new Retrofit.Builder()
                            .baseUrl(Urls.BASE_WXURL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                    wxApi = retrofitWx.create(Api.class);

                }
            }
        }
        return wxApi;
    }


    /**
     * 更新公司域名
     */
    public static void refreshUrl() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }
}
