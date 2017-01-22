package com.example.android.quakereport;

/**
 * Created by Waqas on 7/31/2016.
 */
public class Earthquake {

    private String mLocation;
    private Long mDate;
    private double mMagnitude;
    private String mUrl;

    public Earthquake(double magnitude, String location, Long date, String url) {

        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
        mUrl = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public Long getTimeInMilliseconds() {
        return mDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
