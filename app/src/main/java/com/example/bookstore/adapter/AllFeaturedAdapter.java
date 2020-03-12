package com.example.bookstore.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bookstore.R;
import com.example.bookstore.data.model.AllFeaturedModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class AllFeaturedAdapter extends RecyclerView.Adapter<AllFeaturedAdapter.HomeViewHolder> {


    private List<AllFeaturedModel> allFeaturedModels;
    private Context context;


    public AllFeaturedAdapter(List<AllFeaturedModel> allFeaturedModels, Context context) {
        this.allFeaturedModels = allFeaturedModels;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_featured_page, parent, false);

        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.bind(allFeaturedModels.get(position));
    }

    @Override
    public int getItemCount() {
        return allFeaturedModels.size();
    }



    class HomeViewHolder extends RecyclerView.ViewHolder {

        ImageView ImgUrl;
        TextView tvBookName, tvNameAuthor, tvPrice;
        RatingBar ratingBar;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            ImgUrl = itemView.findViewById(R.id.featured_im_imageView);
            tvBookName = itemView.findViewById(R.id.allFeatured_book_name);
            tvPrice = itemView.findViewById(R.id.allFeatured_tv_price);
            tvNameAuthor = itemView.findViewById(R.id.allFeatured_author_name);
            ratingBar = itemView.findViewById(R.id.allFeatured_rb_ratingBar);

        }

        void bind(AllFeaturedModel allFeaturedModel) {

            tvBookName.setText(allFeaturedModel.getName());
            tvNameAuthor.setText(allFeaturedModel.getName());
            tvPrice.setText(String.valueOf(allFeaturedModel.getPrice()));
            ratingBar.setRating(allFeaturedModel.getRating());

            Glide.with(context).load(allFeaturedModel.getImage()).into(ImgUrl);
            Log.d(" s", "bind: ");
        }

    }
}
