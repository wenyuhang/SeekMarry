package com.wl.seekmarry.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wl.seekmarry.R;
import com.wl.seekmarry.design.BeehiveLayoutManager;
import com.wl.seekmarry.design.HexagonImageView;

import java.util.Random;

/**
 * Created by ${温宇航} on 2018/5/28.
 */

public class HiveAdapter extends RecyclerView.Adapter<HiveAdapter.Holder> {
    private final int TYPE_NOEMAL = 0;
    private final int TYPE_BEEHIVEL = 1;
    private int Type = TYPE_BEEHIVEL;
    private int mCount = 7;
    private int mGroupSize = 5;//列数量
    private BeehiveLayoutManager mManager = null;

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new Holder(item);
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        // int pic = R.mipmap.beehive;
        int pic =getPic();
        holder.pic.setImageResource(pic);
        holder.hexagonImageView.setImageResource(pic);
        holder.text.setText(""+position);
        if(Type ==TYPE_BEEHIVEL){
            holder.pic.setVisibility(View.GONE);
            holder.hexagonImageView.setVisibility(View.VISIBLE);
        }else{
            holder.pic.setVisibility(View.VISIBLE);
            holder.hexagonImageView.setVisibility(View.GONE);
        }
    }
    private int[] Pics = new int[]{R.mipmap.girl1,R.mipmap.girl2,R.mipmap.girl3,R.mipmap.girl5,R.mipmap.girl6,R.mipmap.girl7,R.mipmap.girl8,R.mipmap.girl9,};
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
