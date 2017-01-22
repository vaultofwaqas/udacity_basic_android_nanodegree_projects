package com.waqkz.tourguideapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class TourDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_description);

        ImageView titleImage = (ImageView) findViewById(R.id.descriptionImage);
        TextView titleNameText = (TextView) findViewById(R.id.nameDescription);
        TextView titlePhoneText = (TextView) findViewById(R.id.phoneDescription);
        ImageView titleStarImage = (ImageView) findViewById(R.id.starDescription);
        TextView titleEmailText = (TextView) findViewById(R.id.emailDescription);
        TextView titleDescriptionText = (TextView) findViewById(R.id.titleDescription);

        Intent intent = getIntent();

        int titleResourceImage = intent.getIntExtra("TITLE_IMAGE_ID", 0);
        String titleName = intent.getStringExtra("TITLE_NAME");
        String titlePhone = intent.getStringExtra("TITLE_PHONE");
        int titleStar = intent.getIntExtra("TITLE_STAR", 0);
        String titleEmail = intent.getStringExtra("TITLE_EMAIL");
        int titleDescription = intent.getIntExtra("TITLE_STRING", 0);

        titleImage.setImageResource(titleResourceImage);
        titleNameText.setText(titleName);
        titlePhoneText.setText(titlePhone);
        titleStarImage.setImageResource(titleStar);
        titleEmailText.setText(titleEmail);
        titleDescriptionText.setText(titleDescription);

    }
}
