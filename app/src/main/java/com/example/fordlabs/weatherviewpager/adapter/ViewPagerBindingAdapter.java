package com.example.fordlabs.weatherviewpager.adapter;

import android.databinding.BindingAdapter;
import android.support.v4.view.ViewPager;

public class ViewPagerBindingAdapter {

    @BindingAdapter("onChangeListener")
    public static void onSwipeAction(ViewPager viewPager, final SelectPageInterface selectPageInterface){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
            selectPageInterface.selectPage(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }


        @FunctionalInterface
        public interface SelectPageInterface{
        void selectPage(int position);

        }


}

