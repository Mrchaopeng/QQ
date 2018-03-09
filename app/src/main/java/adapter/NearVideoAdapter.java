package adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jinmuyan.quarter.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import bean.NearbyBean;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by TH on 2018/3/9.
 */

public class NearVideoAdapter extends RecyclerView.Adapter<NearVideoAdapter.ViewHolder> {
    private Context context;
    private List<NearbyBean.DataBean> list;
    private JCVideoPlayer video;
    private SimpleDraweeView fsc;

    public NearVideoAdapter(Context context, List<NearbyBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.near_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

       /* boolean setUp = video.setUp(list.get(position).getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
        if (setUp) {
            video.cacheImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(context).load(list.get(position).getUser().getIcon()).into(video.cacheImageView);
        }*/

       /* Uri uri =  Uri.parse(list.get(position).getUser().getIcon());
        fsc.setImageURI(uri);*/

        Glide.with(context).load(list.get(position).getCover()).into(holder.img);



    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    //声明自己的ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            //video = itemView.findViewById(R.id.videoplayer);
            //fsc = itemView.findViewById(R.id.fsc);
            img = itemView.findViewById(R.id.img);

        }
    }
}





