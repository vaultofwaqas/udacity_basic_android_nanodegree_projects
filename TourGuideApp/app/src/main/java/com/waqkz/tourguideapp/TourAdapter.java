package com.waqkz.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Waqas on 8/12/2016.
 */
public class TourAdapter extends ArrayAdapter<Tour> {

    public TourAdapter(Context context, ArrayList<Tour> tour) {
        super(context, 0, tour);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView tourTitleImageView = (ImageView) listItemView.findViewById(R.id.image);
        TextView tourTitleTextView = (TextView) listItemView.findViewById(R.id.title_textview);
        TextView tourPhoneTextView = (TextView) listItemView.findViewById(R.id.phone_tetview);
        ImageView tourStarImageView = (ImageView) listItemView.findViewById(R.id.star_imageview);

        Tour currentTour = getItem(position);

        tourTitleTextView.setText(currentTour.getTitleName());
        tourPhoneTextView.setText(currentTour.getTitlePhone());

        tourTitleImageView.setImageResource(currentTour.getImageTitleResourceID());
        tourStarImageView.setImageResource(currentTour.getImageStarResourceID());

        return listItemView;
    }


}
