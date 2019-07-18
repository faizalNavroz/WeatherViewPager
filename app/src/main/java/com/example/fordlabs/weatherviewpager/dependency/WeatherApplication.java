package com.example.fordlabs.weatherviewpager.dependency;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class WeatherApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> weatherApplicationDispatchingAndroidInjector;


    @Override
    public void onCreate() {
        super.onCreate();
        ApiComponent apiComponent = DaggerApiComponent.create();
        apiComponent.inject(this);

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return weatherApplicationDispatchingAndroidInjector;
    }
}
