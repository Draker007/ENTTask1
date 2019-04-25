package com.example.enttask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit;
    private static final String BaseUrl = "https://robotux.in/";

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null){
retrofit= new retrofit2.Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        return retrofit;
    }
}
