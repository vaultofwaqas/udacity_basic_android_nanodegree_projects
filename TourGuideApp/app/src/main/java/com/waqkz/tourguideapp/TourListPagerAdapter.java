package com.waqkz.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Waqas on 8/13/2016.
 */
public class TourListPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public TourListPagerAdapter(Context context, FragmentManager fm) {
        super(fm);

        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new HotelFragment();
        } else if (position == 1) {
            return new ParkFragment();
        } else if (position == 2) {
            return new HillFragment();
        } else {
            return new RestaurantFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.hotel);
        } else if (position == 1) {
            return mContext.getString(R.string.park);
        } else if (position == 2) {
            return mContext.getString(R.string.hill);
        } else {
            return mContext.getString(R.string.restaurant);
        }
    }
}
