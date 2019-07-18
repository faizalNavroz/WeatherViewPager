package com.example.fordlabs.weatherviewpager.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fordlabs.weatherviewpager.adapter.CustomAdapter;
import com.example.fordlabs.weatherviewpager.R;
import com.example.fordlabs.weatherviewpager.network.ApiInterface;
import com.example.fordlabs.weatherviewpager.viewmodel.WeatherViewModel;
import com.example.fordlabs.weatherviewpager.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="MainActivity";

    @Inject
    WeatherViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        CustomAdapter adapter = new CustomAdapter(weatherViewModel);
        binding.viewPager.setAdapter(adapter);

        binding.setViewmodel(weatherViewModel);
        this.getLifecycle().addObserver(weatherViewModel);



    }
}
