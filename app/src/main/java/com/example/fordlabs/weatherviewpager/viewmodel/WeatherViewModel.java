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
import com.example.fordlabs.weatherviewpager.network.ApiInterface;
import com.example.fordlabs.weatherviewpager.network.WeatherServiceManager;

import java.text.DecimalFormat;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WeatherViewModel extends BaseObservable implements LifecycleObserver {

    public static final String TAG="WeatherViewModel";

    @Inject
    ApiInterface apiInterface;

    String [] cityNames = {"Chennai,in","London","Delhi,in","Kolkata,in","Pune,in"};

    ObservableField<WeatherResponse>weatherRepObj = new ObservableField<WeatherResponse>();

    @Inject
    public WeatherViewModel() {
    }


    @Inject
    WeatherServiceManager weatherServiceManager;

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

        weatherServiceManager.getWeatherResponse(cityNames[position]).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<WeatherResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeatherResponse value) {
                    weatherRepObj.set(value);
                    notifyPropertyChanged(BR._all);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }



    public String[] getCityNames() {
        return cityNames;
    }
}
