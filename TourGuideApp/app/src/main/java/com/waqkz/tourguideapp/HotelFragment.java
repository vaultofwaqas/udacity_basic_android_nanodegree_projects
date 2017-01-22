package com.waqkz.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {


    public HotelFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        final ArrayList<Tour> tourList = new ArrayList<Tour>();

        tourList.add(new Tour(R.drawable.firhill_murree, "Maisonette FirHill", "+92 51 3411327", R.drawable.star_4, "fir_hill@gmail.com", R.string.maisonette_fir_hill));
        tourList.add(new Tour(R.drawable.punjab_hut, "Punjab Huts", "+92 51 3752166", R.drawable.star_4, "punjab.huts@live.com", R.string.punjab_huts));
        tourList.add(new Tour(R.drawable.morning_side_murree, "Morning Side Murree", "+92 51 3412039 - 42", R.drawable.star_2, "morning_murree@hotmail.com", R.string.morning_side_murree));
        tourList.add(new Tour(R.drawable.faran_hotel, "Faran Hotel", "+92 51 3472126", R.drawable.star_3, "faranhotels_company@gmail.com", R.string.faran_hotel));
        tourList.add(new Tour(R.drawable.bhurban_hill_apartments, "Bhurban Hills", "+92 51 3456467", R.drawable.star_3, "bhurbans@live.com", R.string.bhurban_hills));
        tourList.add(new Tour(R.drawable.red_himalayan, "Red Himalayans", "+92 51 3413264", R.drawable.star_3, "himalayan_in_red@hotmail.com", R.string.red_himalayans));
        tourList.add(new Tour(R.drawable.bright_land_hotel_murree, "Bright Land Hotel", "+92 51 3967412", R.drawable.star_2, "bright.l@hotmail.com", R.string.bright_land_hotel));

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
