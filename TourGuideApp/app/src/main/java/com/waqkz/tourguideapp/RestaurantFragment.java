package com.waqkz.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        final ArrayList<Tour> tourList = new ArrayList<Tour>();

        tourList.add(new Tour(R.drawable.alpine_hangout, "Alpine Hangout", "+92 51 3445569", R.drawable.star_4, "hangout_alpine@hotmail.com", R.string.alpine_hangout));
        tourList.add(new Tour(R.drawable.hilltop_resort_khajut, "Hilltop Resort Khajot", "+92 51 3489567", R.drawable.star_4, "hilltops_resorts@live.com", R.string.hilltop_resort_khajut));
        tourList.add(new Tour(R.drawable.lintott_restaurant, "Linttott's Restaurant", "+92 51 3499567" , R.drawable.star_4, "linttotts@gmail.com", R.string.lintott_restaurant));
        tourList.add(new Tour(R.drawable.red_onion, "Red Onion", "+92 51 3489651", R.drawable.star_3, "onion_red@live.com", R.string.red_onion));
        tourList.add(new Tour(R.drawable.white_union, "White Onion", "+92 51 3447895", R.drawable.star_3, "white_onion@live.com", R.string.white_union));

        TourAdapter tourAdapter = new TourAdapter(getActivity(), tourList);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(tourAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Tour tour = tourList.get(position);

                int TitleImage = tour.getImageTitleResourceID();
                String TitleName = tour.getTitleName();
                String TitlePhone = tour.getTitlePhone();
                int TitleStar = tour.getImageStarResourceID();
                String TitleEmail = tour.getTitleEmail();
                int TitleString = tour.getStringResourceID();

                Intent intent = new Intent(getActivity(), TourDescriptionActivity.class);

                intent.putExtra("TITLE_IMAGE_ID", TitleImage);
                intent.putExtra("TITLE_NAME", TitleName);
                intent.putExtra("TITLE_PHONE", TitlePhone);
                intent.putExtra("TITLE_STAR", TitleStar);
                intent.putExtra("TITLE_EMAIL", TitleEmail);
                intent.putExtra("TITLE_STRING", TitleString);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
