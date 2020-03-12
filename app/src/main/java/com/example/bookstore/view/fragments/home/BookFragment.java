package com.example.bookstore.view.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookstore.R;
import com.example.bookstore.data.api.ApiClient;
import com.example.bookstore.data.api.ApiService;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BookFragment extends Fragment {


    @BindView(R.id.bookStore_tv_bookStore)
    TextView bookStoreTvBookStore;
    @BindView(R.id.bookStory_iv_backBar)
    ImageView bookStoryIvBackBar;
    @BindView(R.id.profile_tb_toolbar)
    Toolbar profileTbToolbar;
    @BindView(R.id.home_rv_Image_url)
    RecyclerView homeRvImageUrl;
    private ApiService apiService;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_books, container, false);

        unbinder = ButterKnife.bind(this, view);
        bookStoreTvBookStore.setText("Books");
        bookStoryIvBackBar.setVisibility(View.GONE);

        apiService = ApiClient.getClient().create(ApiService.class);

        return view;
    }

}
