package com.example.fordlabs.weatherviewpager;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.fordlabs.weatherviewpager.model.WeatherResponse;
import com.example.fordlabs.weatherviewpager.network.ApiClient;
import com.example.fordlabs.weatherviewpager.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends BaseObservable implements LifecycleObserver {

    public static final String TAG="WeatherViewModel";

    ApiInterface apiInterface;

    String [] cityNames = {"Chennai,in","London"};


    ObservableField<String>cityName = new ObservableField<String>();

    @Bindable
    public String getCityName(){
        return cityName.get();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        Log.i(TAG, "onCreate: ");
        onPageSwipe(0);


    }

    public void onPageSwipe(int position){

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        final Call<WeatherResponse> weatherResponseCall = apiInterface.getWeatherResponse(cityNames[position]);

        weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.d("msg************", response.body().toString());
                if (response.isSuccessful()) {
                    cityName.set(response.body().getName());
                    notifyPropertyChanged(BR._all);

                }

            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d("msg", "error");
            }
        });


    }

}
