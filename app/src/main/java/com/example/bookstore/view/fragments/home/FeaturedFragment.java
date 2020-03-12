package com.example.bookstore.view.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookstore.R;
import com.example.bookstore.adapter.AllFeaturedAdapter;
import com.example.bookstore.data.api.ApiClient;
import com.example.bookstore.data.api.ApiService;
import com.example.bookstore.data.model.AllFeaturedModel;


import java.util.List;

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

public class FeaturedFragment extends Fragment {


    @BindView(R.id.bookStore_tv_bookStore)
    TextView bookStoreTvBookStore;
    @BindView(R.id.bookStory_iv_backBar)
    ImageView bookStoryIvBackBar;
    @BindView(R.id.profile_tb_toolbar)
    Toolbar profileTbToolbar;
    @BindView(R.id.allFeatured_rv_Image_url)
    RecyclerView allFeaturedRvImageUrl;

    private LinearLayoutManager layoutManagerBookItems;
    private AllFeaturedAdapter allFeaturedAdapter;

    private ApiService apiService;
    private Unbinder unbinder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_featured, container, false);
        unbinder = ButterKnife.bind(this, view);
        bookStoreTvBookStore.setText("Featured");

        apiService = ApiClient.getClient().create(ApiService.class);

        allFeatured();

        return view;
    }

    private void allFeatured() {

        apiService.getAllFeatured().enqueue(new Callback<List<AllFeaturedModel>>() {
            @Override
            public void onResponse(Call<List<AllFeaturedModel>> call, Response<List<AllFeaturedModel>> response) {

                try {

                    if (response.isSuccessful())

                        layoutManagerBookItems = new LinearLayoutManager(getActivity(),
                                LinearLayoutManager.VERTICAL, false);

                    allFeaturedRvImageUrl.setLayoutManager(layoutManagerBookItems);

                    List<AllFeaturedModel> allFeaturedModels = response.body();

                    allFeaturedAdapter = new AllFeaturedAdapter(allFeaturedModels, getContext());
                    allFeaturedRvImageUrl.setAdapter(allFeaturedAdapter);

                } catch (Exception e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(Call<List<AllFeaturedModel>> call, Throwable t) {
                Toast.makeText(getActivity(),t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @OnClick(R.id.bookStory_iv_backBar)
    public void onViewClicked() {
        openFragment(getFragmentManager(),
                new HomeFragment(), R.id.frameLayout_fl_container);

    }
}
