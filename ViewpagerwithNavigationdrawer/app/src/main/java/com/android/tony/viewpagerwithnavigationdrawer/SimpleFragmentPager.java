package com.android.tony.viewpagerwithnavigationdrawer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SimpleFragmentPager extends FragmentStatePagerAdapter {

    SimpleFragmentPager(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int i) {
        if(i==0)
            return new FirstFragment();
        else if(i==1)
            return new SecondFragment();
        else
            return new ThirdFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0)
            return "First";
        else if(position==1)
            return "Second";
        else
            return "Third";
    }

}
