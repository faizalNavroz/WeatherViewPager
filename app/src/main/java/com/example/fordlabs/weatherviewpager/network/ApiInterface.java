package com.example.fordlabs.weatherviewpager.network;


import com.example.fordlabs.weatherviewpager.model.WeatherResponse;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("/weather")
    public Call<WeatherResponse> getWeatherResponse(@Query("q") String q);

    @GET("/weather")
    public Observable<WeatherResponse> getWeatherResponseObservable(@Query("q") String q);

}
