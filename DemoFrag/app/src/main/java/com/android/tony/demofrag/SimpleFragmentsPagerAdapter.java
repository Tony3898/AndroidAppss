package com.android.tony.demofrag;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SimpleFragmentsPagerAdapter extends FragmentStatePagerAdapter {

    SimpleFragmentsPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        if ( i == 0)
            return new FirstFragment();
        else if(i == 1)
            return  new TwoFragment();
        else if(i == 2)
            return new ThreeFragment();
        else
            return new FourFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if(position == 0 )
            return "Home";
        else if(position == 1 )
            return  "Sign UP";
        else if(position ==2)
            return  "Sign In";
        else
            return "Fetch all";

    }

    @Override
    public int getCount() {
        return 4;
    }
}
