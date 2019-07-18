package com.example.fordlabs.weatherviewpager.dependency;

import com.example.fordlabs.weatherviewpager.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {


    @ContributesAndroidInjector
    abstract MainActivity providesMainactivity();
}
