package com.example.fordlabs.weatherviewpager.network;

import com.example.fordlabs.weatherviewpager.model.WeatherResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;


public class WeatherServiceManager {


    @Inject
    ApiInterface apiInterface ;


    @Inject
    public WeatherServiceManager() {
//        this.apiInterface=apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
    }

    public Observable<WeatherResponse> getWeatherResponse(String cityName) {
       // apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
//        retrofit.create(ApiInterface.class);
        return apiInterface.getWeatherResponseObservable(cityName);
    }
}
