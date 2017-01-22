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
public class ParkFragment extends Fragment {


    public ParkFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        final ArrayList<Tour> tourList = new ArrayList<Tour>();

        tourList.add(new Tour(R.drawable.lakeviewpark, "Lake View Park", "+92 51 3413125", R.drawable.star_4, "lake_view@live.com", R.string.lake_view_park));
        tourList.add(new Tour(R.drawable.chattar_park, "Chattar Park", "+92 51 3456159", R.drawable.star_4, "chattars@yahoo.com", R.string.chattar_park));
        tourList.add(new Tour(R.drawable.sozo_adventure_park, "Sozo Adventure Park", "+92 51 3475596" , R.drawable.star_4, "sozo_adventurism@gmail.com", R.string.sozo_adventure_park));
        tourList.add(new Tour(R.drawable.valley_park, "Valley Park Murree", "+92 51 3489651", R.drawable.star_3, "valley_parkers@live.com", R.string.valley_park));
        tourList.add(new Tour(R.drawable.murree_wildlife_park, "Murree Wildlife Park", "+92 51 3412357", R.drawable.star_4, "wildlife_murree@gmail.com", R.string.murree_wildlife_park));
        tourList.add(new Tour(R.drawable.pia_park, "PIA Park", "+92 51 3461279", R.drawable.star_2, "parks_pia@hotmail.com", R.string.pia_park));

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
