package com.yoawo.example.slideout.view;

/**
 * Created by ${温宇航} on 2018/5/28.
 */

public interface OnActivityChangeListener {
    /**
     * 滚动开始
     */
    void scrollStart();

    /**
     * 滚动中
     */
    void scrolling(float currX, float finalX);

    /**
     * 滚动结束
     */
    void scrollEnd(boolean isExit);
}
