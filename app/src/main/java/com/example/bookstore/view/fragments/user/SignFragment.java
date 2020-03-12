package com.example.bookstore.view.fragments.user;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookstore.R;
import com.example.bookstore.data.api.ApiClient;
import com.example.bookstore.data.api.ApiService;
import com.example.bookstore.data.model.LoginBook;
import com.example.bookstore.data.model.RegisterModel;
import com.example.bookstore.utility.Utility;
import com.example.bookstore.view.fragments.home.BookFragment;


import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.bookstore.utility.Utility.openFragment;

public class SignFragment extends Fragment {


    @BindView(R.id.signUp_et_name)
    EditText signUpEtName;
    @BindView(R.id.signUp_et_mobile)
    EditText signUpEtMobile;
    @BindView(R.id.signUp_et_email)
    EditText signUpEtEmail;
    @BindView(R.id.signUp_et_address)
    EditText signUpEtAddress;
    @BindView(R.id.signUp_et_password)
    EditText signUpEtPassword;
    @BindView(R.id.signUp_btn_signUp)
    Button signUpBtnSignUp;
    @BindView(R.id.signUp)
    LinearLayout signUp;
    @BindView(R.id.signIn_et_email)
    EditText signInEtEmail;
    @BindView(R.id.signIn_et_password)
    EditText signInEtPassword;
    @BindView(R.id.signIn_btn_signIn)
    Button signInBtnSignIn;
    @BindView(R.id.signIn)
    LinearLayout signIn;
    @BindView(R.id.signUp_tv_signUpPage)
    TextView signUpTvSignUpPage;
    @BindView(R.id.signIn_tv_signInPage)
    TextView signInTvSignInPage;

    private ApiService apiService;

    private Unbinder unbinder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign, container, false);

        unbinder = ButterKnife.bind(this, view);
        apiService = ApiClient.getClient().create(ApiService.class);

        return view;
    }

    private void onSignUP() {

        String name = signUpEtName.getText().toString().trim();
        String email = signUpEtEmail.getText().toString().trim();
        String phone = signUpEtMobile.getText().toString().trim();
        String password = signUpEtPassword.getText().toString().trim();
        String address = signUpEtAddress.getText().toString().trim();


        if (name.isEmpty()) {
            signUpEtName.setError("Name Is Empty");
        }
        if (email.isEmpty()) {
            signUpEtEmail.setError("Email Is Empty");
        }
        if (phone.isEmpty()) {
            signUpEtMobile.setError("Mobile Is Empty");
        }
        if (phone.length() != 11) {
            signUpEtMobile.setError("Must Be 11 NO. ");
        }
        if (address.isEmpty()) {
            signUpEtAddress.setError("Address Is Empty");
        }
        if (password.isEmpty()) {
            signUpEtPassword.setError("Password Is Empty");
        }
        if (password.length() < 6) {
            signUpEtPassword.setError("Must Be 6 NO. or More");
        }

        RegisterModel registerModel = new RegisterModel(name, phone, email, address, password);

        apiService.signUp(registerModel).enqueue(new Callback<RegisterModel>() {
            @Override
            public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {

                try {
                    if (response.isSuccessful()) {

                        Utility.saveToken(getContext(), response.body().getEmail());
                        Utility.saveToken(getContext(), response.body().getAddress());
                        Utility.saveToken(getContext(), response.body().getEmail());
                        Utility.saveToken(getContext(), response.body().getPhone());
                        Utility.saveToken(getContext(), response.body().getPhone());

                        Toast.makeText(getActivity(), response.message(), Toast.LENGTH_LONG).show();
                        openFragment(getFragmentManager(), new ProfileFragment(), R.id.frameLayout_fl_container);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<RegisterModel> call, Throwable t) {
                Toast.makeText(getActivity(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void onLogin() {

        String email = signInEtEmail.getText().toString().trim();
        String password = signInEtPassword.getText().toString().trim();

        if (email.isEmpty()) {
            signInEtEmail.setError("Email Is Empty");
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signInEtEmail.setError("Email Not Match");
        }
        if (password.isEmpty()) {
            signInEtPassword.setError("Password Is Empty");
        }
        if (password.length() < 6) {
            signInEtPassword.setError("Must Be 6 NO. or More");
        }
        LoginBook loginBook = new LoginBook(email, password);
        apiService.singIn(loginBook).enqueue(new Callback<LoginBook>() {
            @Override
            public void onResponse(Call<LoginBook> call, Response<LoginBook> response) {

                try {
                    if (response.isSuccessful()) {

                        Toast.makeText(getActivity(), response.message(), Toast.LENGTH_SHORT).show();

                        openFragment(getFragmentManager(), new BookFragment(), R.id.frameLayout_fl_container);
                    } else {
                        Toast.makeText(getActivity(), "Texts Empty", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<LoginBook> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick({R.id.signUp_btn_signUp, R.id.signIn_btn_signIn,
            R.id.signUp_tv_signUpPage, R.id.signIn_tv_signInPage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.signUp_btn_signUp:

                onSignUP();
                break;

            case R.id.signIn_btn_signIn:

                onLogin();
                break;

            case R.id.signUp_tv_signUpPage:

                signIn.setVisibility(View.GONE);
                signUp.setVisibility(View.VISIBLE);
                signUpTvSignUpPage.setTextAppearance(getContext(), R.style.ButtonClicked);
                signInTvSignInPage.setTextAppearance(getContext(), R.style.ButtonDisable);
                break;

            case R.id.signIn_tv_signInPage:

                signUp.setVisibility(View.GONE);
                signIn.setVisibility(View.VISIBLE);
                signInTvSignInPage.setTextAppearance(getContext(), R.style.ButtonClicked);
                signUpTvSignUpPage.setTextAppearance(getContext(), R.style.ButtonDisable);
                break;
        }
    }
}
