package com.waqkz.newsfeed;

/**
 * Created by Waqas on 8/26/2016.
 */
public class News {

    private String mNewsTitle;
    private String mNewsSection;
    private String mNewsDate;
    private String mUrl;

    public News(String newsTitle, String newsSection, String newsDate, String url) {
        mNewsTitle = newsTitle;
        mNewsSection = newsSection;
        mNewsDate = newsDate;
        mUrl = url;
    }

    public String getNewsTitle() {
        return mNewsTitle;
    }

    public String getNewsSection() {
        return mNewsSection;
    }

    public String getNewsDate() {
        return mNewsDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
