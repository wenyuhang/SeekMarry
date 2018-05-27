package com.wl.seekmarry.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wl.seekmarry.config.Urls;


/**
 * Created by ${���} on 2018/3/20.
 */

public class WebViewUtils {
    /**
     * 设置WebView
     */
    @SuppressLint("JavascriptInterface")
    public static void setWebView(final Context context, Activity baseFragment, final WebView webView, String webUrl) {

        if (webView != null) {
            //在页面销毁时清楚webview 缓存
            CookieSyncManager.createInstance(context);  //Create a singleton CookieSyncManager within a context
            CookieManager cookieManager = CookieManager.getInstance(); // the singleton CookieManager instance
            cookieManager.removeAllCookie();// Removes all cookies.
            CookieSyncManager.getInstance().sync(); // forces sync manager to sync now

            webView.setWebChromeClient(null);
            webView.setWebViewClient(null);
            webView.getSettings().setJavaScriptEnabled(false);
            webView.clearCache(true);
        }


        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        //不使用缓存：
//        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);//设置内置缩放控件
        settings.setDisplayZoomControls(false);//设置隐藏的原生的缩放控件


        webView.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if(NetWorkUtils.isNetworkConnected(context)){
                }else {
                    if (!url.equals(Urls.NOT_FOUND_PAGE)) {
                        webView.loadUrl(Urls.NOT_FOUND_PAGE);
                    }
                }


            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                webView.loadUrl(Urls.NOT_FOUND_PAGE);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();// 接受网站的证书
            }
        });


        webView.setWebChromeClient(new WebChromeClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }


        });
        webView.loadUrl(webUrl);
        webView.addJavascriptInterface(baseFragment, "android");
    }
}
