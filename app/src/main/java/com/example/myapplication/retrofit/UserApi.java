package com.example.myapplication.retrofit;

import com.example.myapplication.model.User;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserApi {
    @GET("/Users/get-all")
    Call<List<User>> getAllUsers();

    @POST("/Users/save")
    Call<User> save(@Body User user);

    @POST("/Users/get-password-by-id")
    Call<String> findPasswordById(@Query("username") String username);

    @POST("/Users/check-password")
    Call<Boolean> checkPassword(@Body String username, @Body String pswToCheck);
}
