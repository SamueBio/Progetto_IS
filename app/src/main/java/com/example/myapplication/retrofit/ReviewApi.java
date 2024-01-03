package com.example.myapplication.retrofit;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ReviewApi {
    @POST("/Reviews/save")
    Call<ResponseBody> save(@Body JsonObject jsonObject);

    @POST("/Reviews/get-reviews-by-accommodation")
    Call<ResponseBody> getReviewsByAccommodation(@Body JsonObject jsonObject);
}
