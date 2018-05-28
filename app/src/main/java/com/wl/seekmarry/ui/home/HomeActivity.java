package com.wl.seekmarry.ui.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wl.seekmarry.R;

/**
 * Created by ${温宇航} on 2018/5/27.
 * 首页
 */

public class HomeActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /**
     * 二维码
     * @param view
     */
    public void jumpUser(View view){
        intent = new Intent(this, UserCodeActivity.class);
        startActivity(intent);
    }

    /**
     * 3D
     * @param view
     */
    public void jumpThreeD(View view){
        intent = new Intent(this, ThreeDTagActivity.class);
        startActivity(intent);
    }

    /**
     * 蜂巢
     * @param view
     */
    public void jumpHive(View view){
        intent = new Intent(this, HiveActivity.class);
        startActivity(intent);
    }

    /**
     * Twitter
     * @param view
     */
    public void jumpTwitter(View view){
        intent = new Intent(this, TwitterActivity.class);
        startActivity(intent);
    }
}
