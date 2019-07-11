package com.example.fordlabs.weatherviewpager.network;


import com.example.fordlabs.weatherviewpager.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("/weather")
    public Call<WeatherResponse> getWeatherResponse(@Query("q") String q);
}
