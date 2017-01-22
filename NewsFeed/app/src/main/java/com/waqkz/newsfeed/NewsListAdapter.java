package com.waqkz.newsfeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Waqas on 8/26/2016.
 */
public class NewsListAdapter extends ArrayAdapter<News> {

    private static final String LOCATION_SEPARATOR = "T";

    public NewsListAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView newsTitle = (TextView) listItemView.findViewById(R.id.title_textview);
        TextView newsSection = (TextView) listItemView.findViewById(R.id.section_textview);
        TextView newsFirstDate = (TextView) listItemView.findViewById(R.id.dateFirst_textview);
        TextView newsSecondDate = (TextView) listItemView.findViewById(R.id.dateSecond_textview);

        News currentNews = getItem(position);

        newsTitle.setText(currentNews.getNewsTitle());
        newsSection.setText(currentNews.getNewsSection());

        String originaDate = currentNews.getNewsDate();

        String primaryDate;
        String dateOffset;

        if (originaDate.contains(LOCATION_SEPARATOR)) {
            String[] parts = originaDate.split(LOCATION_SEPARATOR);

            primaryDate  = parts[0];
            dateOffset = LOCATION_SEPARATOR + parts[1];

        } else {
            primaryDate = originaDate;
            dateOffset = "";
        }

        newsFirstDate.setText(primaryDate);
        newsSecondDate.setText(dateOffset);

        return listItemView;
    }
}
