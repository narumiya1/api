package com.news.eijun.api.holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.eijun.api.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView title;
    public TextView published_at;
    public CardView cvNews;
    public View view;

    public NewsViewHolder(View itemView) {
        super(itemView);


        imageView = itemView.findViewById(R.id.img_news);
        title = itemView.findViewById(R.id.tv_title);
        published_at = itemView.findViewById(R.id.published_at);
        cvNews = itemView.findViewById(R.id.cvNews);

        this.view = itemView;

    }
}
