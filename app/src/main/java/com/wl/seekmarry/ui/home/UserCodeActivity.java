package com.wl.seekmarry.ui.home;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.provider.Settings;
import android.widget.ImageView;

import com.wl.seekmarry.R;
import com.wl.seekmarry.base.BaseActivity;
import com.wl.seekmarry.config.Action;
import com.wl.seekmarry.utils.AwesomeQRCode;
import com.wl.seekmarry.utils.FileUtils;
import com.wl.seekmarry.utils.PermissionUtils;
import com.wl.seekmarry.utils.SystemUtils;
import com.wl.seekmarry.utils.ToastUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ${温宇航} on 2018/5/28.
 * 二维码
 */

public class UserCodeActivity extends BaseActivity {
    @Bind(R.id.img_code)
    ImageView imgCode;
    private ArrayList<String> perList;
    private Bitmap backgroundImage;

    @Override
    public int getLayoutId() {
        return R.layout.activity_usercode;
    }

    @Override
    public void init() {
        perList = initPer();
        Bitmap bitmap = AwesomeQRCode.create("http://www.daimasucai.com/daima/js/24/", 800, 20, Color.BLACK, Color.WHITE);
        imgCode.setImageBitmap(bitmap);
    }

    private ArrayList<String> initPer() {
        ArrayList<String> perList = new ArrayList<>();
        //对文件读写权限
        perList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        //定位权限
        PermissionUtils.getInstance().inspect(this, perList);//检查本页面所需权限（必须调用）
        return perList;
    }

    @OnClick(R.id.img_code)
    public void onViewClicked() {
        openAlbum();
    }

    /**
     * 权限检查
     */
    private void openAlbum() {
        PermissionUtils.getInstance().setOnPerLisenter(null, new PermissionUtils.PermissionLisenter() {

            /**
             * 询问授权
             */
            @Override
            public void grantPer() {
                PermissionUtils.getInstance().inspect(UserCodeActivity.this, perList);
            }

            /**
             * 授权成功
             */
            @Override
            public void grantPerSuccess() {
                SystemUtils.getInstance().openAlbum(UserCodeActivity.this);
            }

            /**
             * 禁止授权
             */
            @Override
            public void grantPerBan() {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case Action.TYPE_ALBUM:
                if (resultCode != 0) {
                    String filePath = FileUtils.getRealFilePath(UserCodeActivity.this, data.getData());
                    backgroundImage = BitmapFactory.decodeFile(filePath);
                    try {
                        Bitmap bitmap = AwesomeQRCode.create("http://www.daimasucai.com/daima/js/24/", 800, 20, Color.BLACK, Color.WHITE,backgroundImage);
//                        Bitmap bitmap = AwesomeQRCode.create("http://www.daimasucai.com/daima/js/24/",800,20,0.3f,Color.BLACK, Color.WHITE,backgroundImage,true,true,true);
                        imgCode.setImageBitmap(bitmap);
                    }catch (Exception e){
                        ToastUtils.showToast("图片不合规,请重新选择图片");
                    }
                }
                break;
        }
    }
}
