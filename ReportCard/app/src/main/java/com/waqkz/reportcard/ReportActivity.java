package com.waqkz.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        TextView reportText = (TextView) findViewById(R.id.report_card);

        ReportCard reportCard = new ReportCard("Chemistry", 86, 88, 87, "A");

        reportText.setText(reportCard.toString());
    }
}
