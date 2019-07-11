package com.example.fordlabs.weatherviewpager;

import android.databinding.BindingAdapter;
import android.support.v4.view.ViewPager;

public class ViewPagerBindingAdapter {

    @BindingAdapter("onPageChangeListener")
    public static void onPageChanged(ViewPager viewPager,final PageSelectionListener pageSelectedListener){

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
            pageSelectedListener.onPageSelected(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }


    @FunctionalInterface
    public interface PageSelectionListener {
        void onPageSelected(int position);
    }
}

