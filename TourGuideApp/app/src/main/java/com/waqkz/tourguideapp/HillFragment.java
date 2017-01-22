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
public class HillFragment extends Fragment {


    public HillFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        final ArrayList<Tour> tourList = new ArrayList<Tour>();

        tourList.add(new Tour(R.drawable.changla_gali, "Changla Gali", "+92 51 3484124", R.drawable.star_4, "galie_changla@hotmail.com", R.string.changla_gali));
        tourList.add(new Tour(R.drawable.ghora_daka, "Ghora Daka", "+92 51 3445889", R.drawable.star_4, "daka_ghora@yahoo.com", R.string.ghora_daka));
        tourList.add(new Tour(R.drawable.kalabagh_point, "Kalabagh Point", "+92 51 3451689" , R.drawable.star_4, "kalabagh@live.com", R.string.kalabagh_point));
        tourList.add(new Tour(R.drawable.kashmir_point, "Kashmir Point", "+92 51 3478956", R.drawable.star_3, "points_kashmiris@hotmail.com", R.string.kashmir_point));
        tourList.add(new Tour(R.drawable.mushpuri_top, "Mushpuri Top", "+92 51 3478951", R.drawable.star_4, "mushpuri@gmail.com", R.string.mushpuri_top));
        tourList.add(new Tour(R.drawable.patriata_new_murree, "Patriata", "+92 51 3454645", R.drawable.star_4, "patriata@gmail.com", R.string.patriata_new_murree));
        tourList.add(new Tour(R.drawable.pindi_point, "Pindi Point", "+92 51 3454478", R.drawable.star_2, "pindi_points@hotmail.com", R.string.pindi_point));

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
