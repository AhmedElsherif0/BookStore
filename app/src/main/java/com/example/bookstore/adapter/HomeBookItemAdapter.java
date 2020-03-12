package com.example.bookstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bookstore.R;
import com.example.bookstore.data.model.FeaturedModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class HomeBookItemAdapter extends RecyclerView.Adapter<HomeBookItemAdapter.HomeViewHolder> {


    private List<FeaturedModel> featuredModelList;
    private Context context;


    public HomeBookItemAdapter(List<FeaturedModel> featuredModelList, Context context) {
        this.featuredModelList = featuredModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_book_items, parent, false);

        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.bind(featuredModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return featuredModelList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {

        ImageView ImgUrl;
        TextView tvOldPrice, tvBookName;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            ImgUrl = itemView.findViewById(R.id.home_iv_bookItems);
            tvBookName = itemView.findViewById(R.id.home_tv_bookItemsName);
            tvOldPrice = itemView.findViewById(R.id.home_tv_bookItemsPrice);
        }

        void bind(FeaturedModel featModel) {

            tvBookName.setText(featModel.getName());
            tvOldPrice.setText(String.valueOf(featModel.getPrice()));

            Glide.with(context).load(featModel.getImage()).into(ImgUrl);

        }
    }
}