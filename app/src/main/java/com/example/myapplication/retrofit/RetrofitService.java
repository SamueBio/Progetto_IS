package com.example.myapplication.retrofit;

import com.google.gson.Gson;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Retrofit retrofit;
    public RetrofitService(){
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        //IP ip = new IP();
        //String url = "192.168.1.55";

        retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-16-171-234-236.eu-north-1.compute.amazonaws.com:9000/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }
}
