package com.example.bookstore.view.fragments.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bookstore.R;
import com.example.bookstore.data.api.ApiClient;
import com.example.bookstore.data.api.ApiService;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {


    @BindView(R.id.profile_cim_image)
    CircleImageView profileCimImage;
    @BindView(R.id.profile_tv_name)
    TextView profileTvName;
    @BindView(R.id.profile_tv_email)
    TextView profileTvEmail;
    @BindView(R.id.profile_tv_phoneNumber)
    TextView profileTvPhoneNumber;

    private Unbinder unbinder;
    private ApiService apiService;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        unbinder = ButterKnife.bind(this, view);
        apiService = ApiClient.getClient().create(ApiService.class);

        return view;
    }


    @OnClick(R.id.profile_cim_image)
    public void onViewClicked() {


    }
}
