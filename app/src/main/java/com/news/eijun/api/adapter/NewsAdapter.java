package com.news.eijun.api.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import com.news.eijun.api.R;
import com.news.eijun.api.holder.NewsViewHolder;
import com.news.eijun.api.model.ModelNews;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private List<ModelNews> androidList;
    private Context mContext;
    private NewsAdapter.onSelecData onSelecData;

    public interface onSelecData {
        void onSelected(ModelNews modelNews);
    }

    public NewsAdapter(Context context, List<ModelNews> android, NewsAdapter.onSelecData onSelecData) {
        this.mContext = context;
        this.androidList = android;
        this.onSelecData = onSelecData;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        final ModelNews berita = androidList.get(position);

        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_image_list);

        Glide.with(mContext)
                .load(berita.getUrlToImage())
                .apply(requestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(holder.imageView);

        holder.title.setText(berita.getTitle());
        holder.published_at.setText(berita.getPulishedAt());
        holder.cvNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelecData.onSelected(berita);
            }
        });
    }

    @Override
    public int getItemCount() {
        return androidList.size();
    }
}
