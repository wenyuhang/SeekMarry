package com.wl.seekmarry.design;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by 温宇航 on 2017/3/29.
 * 自定义dialog
 */

public class CustomDialog extends DialogFragment implements View.OnClickListener{
    private int enterTime;                  //进场动画时间
    private int enterAnimId;                //进场动画
    private int exitTime;                   //退场动画时间
    private int exitAnimId;                 //退场动画
    private View view;                      // 布局view
    private int[] listenedItems;  // 要监听的控件id
    private static CustomDialog dialog;
    private OnCenterItemClickListener listener;
    public interface OnCenterItemClickListener {
        void OnCenterItemClick(CustomDialog dialog, View view);
    }
    public View setOnCenterItemClickListener(OnCenterItemClickListener listener) {
        this.listener = listener;
        if(view!=null){
            return view;
        }
        return null;
    }


    public static CustomDialog getIntent(){
        if (dialog == null) {
            synchronized (CustomDialog.class) {
                if (dialog == null) {
                    dialog = new CustomDialog();
                }
            }
        }
        return dialog;
    }

    /**
     *初始化进场/退场动画
     * @param enterTime
     * @param enterAnimId
     * @param exitTime
     * @param exitAnimId
     * @return
     */
    public CustomDialog initAnim(View view, int[] listenedItems, int enterTime, int enterAnimId, int exitTime, int exitAnimId){
        this.view = view;
        this.listenedItems = listenedItems;
        this.enterTime = enterTime;
        this.enterAnimId = enterAnimId;
        this.exitTime = exitTime;
        this.exitAnimId =exitAnimId;
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //遍历控件id,添加点击事件
        for (int id : listenedItems) {
            view.findViewById(id).setOnClickListener(this);
        }
        startEnterAnim();
        return view;
    }

    /**
     * 获取布局
     * @return
     */
    public View getView(){
        return view;
    }

    @Override
    public void onStart() {
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        getFocus();
    }


    /**
     * 创建进场动画
     */
    public void startEnterAnim() {
        final Animation animation = AnimationUtils.loadAnimation(getActivity(),enterAnimId);
        animation.setDuration(enterTime);
        animation.setFillAfter(true);
        animation.setFillBefore(false);
        view.startAnimation(animation);
        animation.cancel();
    }


    /**
     * 创建退出动画
     */
    public void startExitAnim() {
        final Animation animation = AnimationUtils.loadAnimation(getActivity(),exitAnimId);
        animation.setDuration(exitTime);
        animation.setFillAfter(true);
        animation.setFillBefore(false);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                dismiss();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
        animation.cancel();
    }

    /**
     * 做物理返回键处理
     */
    private void getFocus() {
        getView().setFocusable(true);
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
                    // 监听到返回按钮点击事件
//                    Log.e("TAG", "点击了返回键");
                    startExitAnim();
                    return true;// 未处理
                }
                return false;
            }
        });
    }

    /**
     * 做事件监听
     * @param v
     */
    @Override
    public void onClick(View v) {
        //注意：我在这里加了这句话，表示只要按任何一个控件的id,弹窗都会消失，不管是确定还是取消。
        startExitAnim();
        listener.OnCenterItemClick(this, v);
    }

}
