package com.wl.seekmarry.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.UUID;

import butterknife.ButterKnife;

/**
 * Created by dongjunkun on 2016/2/2.
 */
public abstract class BaseFragment extends Fragment {
    protected Bundle bundle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    /**
     * 加载布局
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     * @param view
     */
    protected abstract void init(View view);


    /**
     * 加载数据
     */
    protected  void loadData(){};


    /**
     * 该方法在Fragment可见时调用，可以在该方法中刷新数据
     */
    protected void onShow(){}

    /**
     * 该方法在Fragment隐藏时调用，可以做数据保存
     */
    protected void onHidden(){}


    /**
     * 当Fragment发生变化是调用 true为隐藏
     * @param hidden
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            onHidden();
        }else {
            onShow();
        }
    }

    public void setBundle(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
