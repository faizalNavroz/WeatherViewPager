package com.example.fordlabs.weatherviewpager.adapter;

import android.support.annotation.NonNull;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fordlabs.weatherviewpager.viewmodel.WeatherViewModel;
import com.example.fordlabs.weatherviewpager.databinding.ViewpagerItemBinding;

public class CustomAdapter extends PagerAdapter {

    WeatherViewModel weatherViewModel;

    public CustomAdapter(WeatherViewModel weatherViewModel) {
        this.weatherViewModel = weatherViewModel;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //Inflate the item view and return the same.
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        ViewpagerItemBinding itemViewBinding = ViewpagerItemBinding.inflate(inflater,container,true);
        itemViewBinding.setViewmodel(weatherViewModel);
        itemViewBinding.executePendingBindings();

        return itemViewBinding;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Log.i("MSG*************", "destroyItem: ");
        ViewpagerItemBinding viewpagerItemBinding = (ViewpagerItemBinding) object;
        viewpagerItemBinding.setViewmodel(null);
        container.removeView(viewpagerItemBinding.getRoot());
    }



    @Override
    public int getCount() {
        return weatherViewModel.getCityNames().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return ((ViewpagerItemBinding) object).getRoot() == view;
    }
}
