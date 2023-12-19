package com.example.myapplication.retrofit;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccommodationApi {
    @POST("/Accomodations/get-accomodation-by-services")
    Call<ResponseBody> search(@Body JsonObject search);
}
