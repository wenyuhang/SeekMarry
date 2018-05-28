package com.wl.seekmarry.ui.home;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wl.seekmarry.R;
import com.wl.seekmarry.base.BaseActivity;
import com.wl.seekmarry.design.BeehiveLayoutManager;
import com.wl.seekmarry.design.HexagonImageView;

import java.util.Random;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ${温宇航} on 2018/5/28.
 */

public class HiveActivity extends BaseActivity {
    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;
    public int FIRSTGROUP_MARGIN_SECONDGROUP = 30;//第一小组与第二小组间距
    public int GROUP_PADDING = 50;//组距
    private final int TYPE_NOEMAL = 0;
    private final int TYPE_BEEHIVEL = 1;
    @Bind(R.id.changetype)
    Button changetype;
    @Bind(R.id.add)
    Button add;
    @Bind(R.id.delect)
    Button delect;
    private int Type = TYPE_BEEHIVEL;
    private Adapter mAdapter = null;

    private int mCount = 7;
    private int mGroupSize = 5;//列数量
    private BeehiveLayoutManager mManager = null;

    @Override
    public int getLayoutId() {
        return R.layout.activity_hive;
    }

    @Override
    public void init() {
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        setAdapter();
    }

    private void setAdapter() {
        mManager = new BeehiveLayoutManager(mGroupSize, this);
        mManager.setFristMarginSecondGroup(FIRSTGROUP_MARGIN_SECONDGROUP);
        mManager.setGroupPadding(GROUP_PADDING);
        mRecyclerView.setLayoutManager(mManager);
        mAdapter = new Adapter();
        mRecyclerView.setAdapter(mAdapter);
    }


    @OnClick({R.id.changetype, R.id.add, R.id.delect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.changetype:
                if (Type == TYPE_NOEMAL) {
                    Type = TYPE_BEEHIVEL;
                } else {
                    Type = TYPE_NOEMAL;
                }
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.add:
                mCount += 5;
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.delect:
                mCount =mCount -  5;
                mCount = mCount>0?mCount:0;
                mAdapter.notifyDataSetChanged();
                break;
        }
    }

    class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item, parent, false);
            return new Holder(item);
        }

        @Override
        public void onBindViewHolder(final Holder holder, final int position) {
            // int pic = R.mipmap.beehive;
            int pic = getPic();
            holder.pic.setImageResource(pic);
            holder.hexagonImageView.setImageResource(pic);
            holder.text.setText("" + position);
            if (Type == TYPE_BEEHIVEL) {
                holder.pic.setVisibility(View.GONE);
                holder.hexagonImageView.setVisibility(View.VISIBLE);
            } else {
                holder.pic.setVisibility(View.VISIBLE);
                holder.hexagonImageView.setVisibility(View.GONE);
            }
        }

        private int[] Pics = new int[]{R.mipmap.girl1, R.mipmap.girl2, R.mipmap.girl3, R.mipmap.girl5, R.mipmap.girl6, R.mipmap.girl7, R.mipmap.girl8, R.mipmap.girl9,};

        private int getPic() {
            return Pics[new Random().nextInt(Pics.length)];
        }

        @Override
        public int getItemCount() {
            return mCount;
        }

        class Holder extends RecyclerView.ViewHolder {

            TextView text;
            ImageView pic;
            HexagonImageView hexagonImageView;

            public Holder(View itemView) {
                super(itemView);

                text = (TextView) itemView.findViewById(R.id.text);
                hexagonImageView = (HexagonImageView) itemView.findViewById(R.id.hexagonview1);
                pic = (ImageView) itemView.findViewById(R.id.pic);

                int width = mManager.getItemWidth();
                ViewGroup.LayoutParams p = hexagonImageView.getLayoutParams();
                p.width = width;
                p.height = width;

                hexagonImageView.setLayoutParams(p);
                pic.setLayoutParams(p);

            }
        }
    }

}
