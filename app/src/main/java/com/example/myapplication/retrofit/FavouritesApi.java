package com.example.myapplication.retrofit;

import com.example.myapplication.model.Favourite;
import com.example.myapplication.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FavouritesApi {
    @GET("/Favourites/get-favouriteaccomodation-by-user")
    Call<User> getFavouriteAccomodationByUser(@Body Favourite favourite);

    @POST("/Favourites/save")
    Call<User> save(@Body Favourite favourite);
}
