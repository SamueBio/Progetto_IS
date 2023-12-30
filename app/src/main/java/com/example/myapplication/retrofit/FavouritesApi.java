package com.example.myapplication.retrofit;

import com.example.myapplication.model.Favourite;
import com.example.myapplication.model.User;
import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FavouritesApi {
    @POST("/Favourites/get-favouriteaccomodation-by-user")
    Call<ResponseBody> getFavouriteAccomodationByUser(@Body JsonObject favourite);

    @POST("/Favourites/save")
    Call<ResponseBody> save(@Body JsonObject favourite);

    @POST("/Favourites/delete")
    Call<ResponseBody> delete(@Body JsonObject favourite);
}
