package com.example.zilwerassignment;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface jsonplaceholderapi {


    @GET("v2/top-headlines?country=us&apiKey=61f805e134024cc387f2fcaf83a06b24")
    Call<Example> getposts1();

}
