package com.wl.seekmarry.ui.home;

import android.graphics.Color;

import com.wl.seekmarry.R;
import com.wl.seekmarry.base.BaseActivity;
import com.wl.seekmarry.ui.adapter.TextTagsAdapter;
import com.yoawo.example.shineButton.TagCloudView;

import butterknife.Bind;

/**
 * Created by ${温宇航} on 2018/5/28.
 */

public class ThreeDTagActivity extends BaseActivity {
    @Bind(R.id.tag_cloud)
    TagCloudView tagCloudView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_three_tag;
    }

    @Override
    public void init() {
        tagCloudView.setBackgroundColor(Color.WHITE);

        TextTagsAdapter textTagsAdapter = new TextTagsAdapter(new String[50]);
//        ViewTagsAdapter viewTagsAdapter = new ViewTagsAdapter();
//        VectorTagsAdapter vectorTagsAdapter = new VectorTagsAdapter();

        tagCloudView.setAdapter(textTagsAdapter);
    }

}
