package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DecimalFormat;
import java.util.List;
import android.graphics.drawable.GradientDrawable;


/**
 * Created by Waqas on 7/31/2016.
 */
public class EarthquakeArrayAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeArrayAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_earthquake, parent, false);
        }

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        //TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        Earthquake currentEarthquakePosition = getItem(position);

        int magnitudeColor = getMagnitudeColor(currentEarthquakePosition.getMagnitude());

        magnitudeCircle.setColor(magnitudeColor);

        String originalLocation = currentEarthquakePosition.getLocation();

        String formattedMagnitude = formatMagnitude(currentEarthquakePosition.getMagnitude());

        magnitudeTextView.setText(formattedMagnitude);

        //locationTextView.setText(currentEarthquakePosition.getLocation());
        Date dateObject = new Date(currentEarthquakePosition.getTimeInMilliseconds());

        String primaryLocation;
        String locationOffset;

        String formattedDate = formatDate(dateObject);

        dateView.setText(formattedDate);

        String formattedTime = formatTime(dateObject);

        timeView.setText(formattedTime);

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.location);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);

        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
