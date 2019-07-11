package com.example.fordlabs.weatherviewpager;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fordlabs.weatherviewpager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        WeatherViewModel weatherViewModel = new WeatherViewModel();


        CustomAdapter adapter = new CustomAdapter(weatherViewModel);
        binding.viewPager.setAdapter(adapter);

        binding.setViewmodel(weatherViewModel);
        this.getLifecycle().addObserver(weatherViewModel);



    }
}
