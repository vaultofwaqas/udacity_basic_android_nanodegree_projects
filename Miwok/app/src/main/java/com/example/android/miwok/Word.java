package com.example.android.miwok;

import android.media.Image;

/**
 * Created by Waqas on 7/30/2016.
 */
public class Word {

    private static int IMAGE_CONSTANT = -1;

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mMiwokImageResourceID = IMAGE_CONSTANT;
    private int mMiwokAudioResourceID;

    public Word(String defaultTranslation, String miwokTranslation, int miwokAudioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mMiwokAudioResourceID = miwokAudioResourceID;
    }

    public Word (String defaultTranslation, String miwokTranslation, int miwokImageResourceID, int miwokAudioResourceID){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mMiwokImageResourceID = miwokImageResourceID;
        mMiwokAudioResourceID = miwokAudioResourceID;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getMiwokImageResourceID() {
        return mMiwokImageResourceID;
    }

    public int hasImage(){

        if (mMiwokImageResourceID != IMAGE_CONSTANT){

            return mMiwokImageResourceID;
        }

        return IMAGE_CONSTANT;
    }

    public int getMiwokAudioResourceID() {
        return mMiwokAudioResourceID;
    }
}
