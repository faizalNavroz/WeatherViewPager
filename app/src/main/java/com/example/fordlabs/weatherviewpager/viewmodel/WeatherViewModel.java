package com.example.fordlabs.weatherviewpager.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.fordlabs.weatherviewpager.BR;
import com.example.fordlabs.weatherviewpager.model.WeatherResponse;
import com.example.fordlabs.weatherviewpager.network.ApiClient;
import com.example.fordlabs.weatherviewpager.network.ApiInterface;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends BaseObservable implements LifecycleObserver {

    public static final String TAG="WeatherViewModel";

    ApiInterface apiInterface;

    String [] cityNames = {"Chennai,in","London","Delhi,in","Kolkata,in","Pune,in"};


    //ObservableField<String>cityName = new ObservableField<String>();

    ObservableField<WeatherResponse>weatherRepObj = new ObservableField<WeatherResponse>();

    /*@Bindable
    public String getCityName(){
        return cityName.get();
    }*/

    @Bindable
    public String getCityName(){
        return weatherRepObj.get() !=null ? weatherRepObj.get().getName() : new String("");
    }

    @Bindable
    public String getPressure(){
        return weatherRepObj.get() !=null ? "Pressure : "+String.valueOf(weatherRepObj.get().getMain().getPressure()) : new String("");
    }


    @Bindable
    public String getHumidity(){
        return weatherRepObj.get() !=null ? "Humidity : "+String.valueOf(weatherRepObj.get().getMain().getHumidity()) : new String("");
    }


    @Bindable
    public String getTemperature(){
        DecimalFormat df = new DecimalFormat("##.00");
        return weatherRepObj.get() !=null ? String.valueOf(df.format(weatherRepObj.get().getMain().getTemp() - 273.15))+"°C" : new String("");
    }


    @Bindable
    public String getWeather(){
        return weatherRepObj.get() !=null ? "Weather : "+String.valueOf(weatherRepObj.get().getWeather().get(0).getDescription()) : new String("");
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        Log.i(TAG, "onCreate: ");
        onSwipe(0);


    }

    public void onSwipe(int position){

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        final Call<WeatherResponse> weatherResponseCall = apiInterface.getWeatherResponse(cityNames[position]);

        weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.d("msg************", response.body().toString());
                if (response.isSuccessful()) {
                    weatherRepObj.set(response.body());
                    //cityName.set(response.body().getName());
                    notifyPropertyChanged(BR._all);

                }

            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d("msg", "error");
            }
        });


    }


    public String[] getCityNames() {
        return cityNames;
    }
}
