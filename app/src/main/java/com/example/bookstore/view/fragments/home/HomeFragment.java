package com.example.bookstore.view.fragments.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookstore.R;
import com.example.bookstore.adapter.HomeBookItemAdapter;
import com.example.bookstore.adapter.HomeImageAdapter;
import com.example.bookstore.data.api.ApiClient;
import com.example.bookstore.data.api.ApiService;
import com.example.bookstore.data.model.FeaturedModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.bookstore.utility.Utility.openFragment;

public class HomeFragment extends Fragment {


    @BindView(R.id.bookStore_tv_bookStore)
    TextView bookStoreTvBookStore;
    @BindView(R.id.bookStory_iv_backBar)
    ImageView bookStoryIvBackBar;
    @BindView(R.id.profile_tb_toolbar)
    Toolbar profileTbToolbar;
    @BindView(R.id.home_rv_Image_url)
    RecyclerView homeRvImageUrl;
    @BindView(R.id.home_tv_seeAll)
    TextView homeTvSeeAll;
    @BindView(R.id.home_rv_bookItems)
    RecyclerView homeRvBookItems;

    private ApiService apiService;
    private Unbinder unbinder;


    private RecyclerView.LayoutManager layoutManagerSlider;
    private RecyclerView.LayoutManager layoutManagerBookItems;
    private HomeImageAdapter homeImageAdapter;
    private HomeBookItemAdapter homeBookItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        bookStoryIvBackBar.setVisibility(View.GONE);

        apiService = ApiClient.getClient().create(ApiService.class);

        onImageUrl();
        onBookItems();

        return view;
    }

    private void onBookItems() {

        apiService.getBooksPagination(1, 3).enqueue(new Callback<List<FeaturedModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<FeaturedModel>> call, @NonNull Response<List<FeaturedModel>> response) {

                try {
                    if (response.isSuccessful())

                        layoutManagerBookItems = new LinearLayoutManager(getActivity(),
                                LinearLayoutManager.HORIZONTAL, false);

                    homeRvBookItems.setLayoutManager(layoutManagerBookItems);

                    List<FeaturedModel> featuredModels = response.body();

                    homeBookItemAdapter = new HomeBookItemAdapter(featuredModels, getContext());
                    homeRvBookItems.setAdapter(homeBookItemAdapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<FeaturedModel>> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onImageUrl() {

        apiService.getSlider().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(@NonNull Call<List<String>> call, @NonNull Response<List<String>> response) {

                try {
                    if (response.isSuccessful())

                        layoutManagerSlider = new LinearLayoutManager(getActivity(),
                                LinearLayoutManager.HORIZONTAL, false);
                    homeRvImageUrl.setLayoutManager(layoutManagerSlider);

                    List<String> slider = response.body();

                    homeImageAdapter = new HomeImageAdapter(slider, getContext());
                    homeRvImageUrl.setAdapter(homeImageAdapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<String>> call, @NonNull Throwable t) {

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.home_tv_seeAll)
    public void onViewClicked() {

        openFragment(getActivity().getSupportFragmentManager(), new FeaturedFragment(),
                R.id.frameLayout_fl_container);
    }
}
