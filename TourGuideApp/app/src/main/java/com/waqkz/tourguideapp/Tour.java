package com.waqkz.tourguideapp;

/**
 * Created by Waqas on 8/12/2016.
 */
public class Tour {

    private int mImageTitleResourceID;
    private String mTitleName;
    private String mTitlePhone;
    private int mImageStarResourceID;
    private String mTitleEmail;
    private int mStringResourceID;

    public Tour(int imageTitleResourceID, String titleName, String titlePhone, int imageStarResourceID, String titleEmail, int stringResourceID) {

        mImageTitleResourceID = imageTitleResourceID;
        mTitleName = titleName;
        mTitlePhone = titlePhone;
        mImageStarResourceID = imageStarResourceID;
        mTitleEmail = titleEmail;
        mStringResourceID = stringResourceID;
    }

    public int getImageTitleResourceID() {
        return mImageTitleResourceID;
    }

    public String getTitleName() {
        return mTitleName;
    }

    public String getTitlePhone() {
        return mTitlePhone;
    }

    public int getImageStarResourceID() {
        return mImageStarResourceID;
    }

    public String getTitleEmail() {
        return mTitleEmail;
    }

    public int getStringResourceID() {
        return mStringResourceID;
    }
}
