package com.wl.seekmarry.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.wl.seekmarry.base.BaseFragment;
import com.wl.seekmarry.config.Action;

import java.io.File;
import java.io.IOException;

import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;
import static com.wl.seekmarry.config.Action.CODE_CROP;

/**
 * Created by ${温宇航} on 2018/5/9.
 * 开打系统工具
 */

public class SystemUtils {

    private Uri cameraUri;
    private static SystemUtils photoUtils;

    /**
     * 实例化单例对象
     *
     * @return
     */
    public static SystemUtils getInstance() {
        if (photoUtils == null) {
            synchronized (SystemUtils.class) {
                if (photoUtils == null) {
                    photoUtils = new SystemUtils();
                }
            }
        }
        return photoUtils;
    }

    /**
     * 打开相机
     * @param activity
     * @param t
     * @return
     */
    public Uri openCamera(Activity activity, int t) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = new File(Environment.getExternalStorageDirectory(), "temp.jpg");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //注意需要跟provider中的authorities一行
            cameraUri = FileProvider.getUriForFile(activity, "com.wl.seekmarry.fileprovider", file);
        } else {
            cameraUri = Uri.fromFile(file);
        }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, cameraUri);
        activity.startActivityForResult(intent, t);
        return cameraUri;
    }

    /**
     * 打开相机
     * @param activity
     * @param t
     * @return
     */
    public Uri openCamera(BaseFragment activity, int t) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = new File(Environment.getExternalStorageDirectory(), "temp.jpg");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //注意需要跟provider中的authorities一行
            cameraUri = FileProvider.getUriForFile(activity.getActivity(), "com.wl.seekmarry.fileprovider", file);
        } else {
            cameraUri = Uri.fromFile(file);
        }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, cameraUri);
        activity.startActivityForResult(intent, t);
        return cameraUri;
    }

    /**
     * 打开系统相册
     *
     * @param activity
     */
    public void openAlbum(Activity activity) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(intent, Action.TYPE_ALBUM);
    }

    /**
     * 打开系统相册
     *
     * @param activity
     */
    public void openAlbum(BaseFragment activity) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(intent, Action.TYPE_ALBUM);
    }

    //打开系统媒体库
    public void openVideo(Activity activity){
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        activity.startActivityForResult(intent, Action.TYPE_VIDEO);
    }

    //打开系统媒体库
    public void openVideo(BaseFragment activity){
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        activity.startActivityForResult(intent, Action.TYPE_VIDEO);
    }


    /**
     * 剪切图片
     * @param uri
     * @param activity
     * @param crop
     * @param aspectX
     * @param aspectY
     * @return
     */
    public Uri cropPhoto(Uri uri, Activity activity, boolean crop, int aspectX, int aspectY) {
        File file = new File(Environment.getExternalStorageDirectory(), "cropImage.jpg");
        if (file.exists())
            file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent("com.android.camera.action.CROP");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(FLAG_GRANT_READ_URI_PERMISSION);
        }
        Uri cropUri = Uri.fromFile(file);
        Log.e("TAG", cropUri.toString());
        intent.setDataAndType(uri, "image/*");
        //裁剪图片的宽高比例
        if (crop) {
            intent.putExtra("aspectX", aspectX);
            intent.putExtra("aspectY", aspectY);
        }

        intent.putExtra("crop", "true");//可裁剪
        // 裁剪后输出图片的尺寸大小
//        intent.putExtra("outputX", 400);
//        intent.putExtra("outputY", 200);
        intent.putExtra("scale", true);//支持缩放
        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, cropUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());//输出图片格式
        intent.putExtra("noFaceDetection", true);//取消人脸识别
        activity.startActivityForResult(intent, Action.CODE_CROP);
        return cropUri;
    }

    /**
     * 剪切图片
     * @param uri
     * @param activity
     * @param crop
     * @param aspectX
     * @param aspectY
     * @return
     */
    public Uri cropPhoto(Uri uri, BaseFragment activity, boolean crop, int aspectX, int aspectY) {
        File file = new File(Environment.getExternalStorageDirectory(), "cropImage.jpg");
        if (file.exists())
            file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent("com.android.camera.action.CROP");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(FLAG_GRANT_READ_URI_PERMISSION);
        }
        Uri cropUri = Uri.fromFile(file);
        Log.e("TAG", cropUri.toString());
        intent.setDataAndType(uri, "image/*");
        //裁剪图片的宽高比例
        if (crop) {
            intent.putExtra("aspectX", aspectX);
            intent.putExtra("aspectY", aspectY);
        }

        intent.putExtra("crop", "true");//可裁剪
        // 裁剪后输出图片的尺寸大小
//        intent.putExtra("outputX", 400);
//        intent.putExtra("outputY", 200);
        intent.putExtra("scale", true);//支持缩放
        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, cropUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());//输出图片格式
        intent.putExtra("noFaceDetection", true);//取消人脸识别
        activity.startActivityForResult(intent, CODE_CROP);
        return cropUri;
    }



    /**
     * 判断软键盘是否弹出
     */
    public boolean isSHowKeyboard(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
        if (imm.hideSoftInputFromWindow(v.getWindowToken(), 0)) {
            imm.showSoftInput(v, 0);
            return true;
            //软键盘已弹出
        } else {
            return false;
            //软键盘未弹出
        }
    }
}
