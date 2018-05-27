package com.wl.seekmarry.model;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wl.seekmarry.net.RetrofitService;

import static com.wl.seekmarry.app.App.context;


/**
 * Created by 温宇航 on 2017/7/12.
 * Glide 图片加载
 */
public class ImageLoaders {

    private static ImageLoaders imageLoaders;

    //单例模式
    public static ImageLoaders getInstance() {
        if (imageLoaders == null) {
            synchronized (RetrofitService.class) {
                if (imageLoaders == null) {
                    imageLoaders = new ImageLoaders();
                }
            }
        }
        return imageLoaders;
    }

    /**
     * 使用默认加载失败图
     * @param path
     * @param imageView
     */
    public  void loadImage(String path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }

    /**
     * 指定加载失败图
     * @param path
     * @param imageView
     * @param imgId
     */
    public  void loadImage(String path, ImageView imageView, int imgId) {
        Glide.with(context).load(path).into(imageView);
    }
}
