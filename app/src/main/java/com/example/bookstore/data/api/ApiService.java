package com.example.bookstore.data.api;


import com.example.bookstore.data.model.AllFeaturedModel;
import com.example.bookstore.data.model.FeaturedModel;
import com.example.bookstore.data.model.LoginBook;
import com.example.bookstore.data.model.RegisterModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiService {

    @POST("users/login")
    Call<LoginBook> singIn(@Body LoginBook loginBook);

    @POST("users/register")
    Call<RegisterModel> signUp(@Body RegisterModel registerModel);

    @GET("books/home/slider")
    Call<List<String>>  getSlider();

    @GET("books/")
    Call<List<FeaturedModel>> getBooksPagination(@Query("pageNumber") int pageNumber,
                                                 @Query("pageSize") int pageSize);
    @GET("books/")
    Call<List<AllFeaturedModel>> getAllFeatured ();


}


