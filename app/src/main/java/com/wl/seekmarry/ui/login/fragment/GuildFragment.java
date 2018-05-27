package com.wl.seekmarry.ui.login.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wl.seekmarry.R;
import com.wl.seekmarry.design.CustomVideoView;

/**
 * Created by ${温宇航} on 2018/5/27.XS
 */

public class GuildFragment extends Fragment {

    private CustomVideoView customVideoView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        customVideoView = new CustomVideoView(getContext());
        return customVideoView;
    }

    @Override
    public void onResume() {
        super.onResume();
        /**获取参数，根据不同的参数播放不同的视频**/
        int index = getArguments().getInt("index");
        Uri uri;
        if (index == 1) {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide1);
        } else if (index == 2) {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide2);
        } else {
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide3);
        }
        /**播放视频**/
        customVideoView.playVideo(uri);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (customVideoView != null) {
            customVideoView.stopPlayback();
        }
    }

    /**
     * 记得在销毁的时候让播放的视频终止
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (customVideoView != null) {
            customVideoView.stopPlayback();
        }
    }
}
