package com.example.enttask;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {
    @GET("/android/dummy.json")
    Call<dataList> getAllData();

}
