package com.example.bookstore.adapter;

import android.content.Context;
import android.renderscript.Int2;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.example.bookstore.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class HomeImageAdapter extends RecyclerView.Adapter<HomeImageAdapter.HomeViewHolder> {


    private List<String> UrlList;
    private Context context;


    public HomeImageAdapter(List<String> PlacesList, Context context) {
        this.UrlList = PlacesList;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_image_url, parent, false);

        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.bind(UrlList.get(position));
    }

    @Override
    public int getItemCount() {
        return UrlList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {

        ImageView ImgUrl;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            ImgUrl = itemView.findViewById(R.id.home_image_url);
        }

        void bind(String url) {

            Glide.with(context).load(url).into(ImgUrl);
            Log.d(" s", "bind: ");
        }

    }
}
