package com.waqkz.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CourtActivity extends AppCompatActivity {

    int scoreTeamA, scoreTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court);


        final Button threePointsTeamA = (Button) findViewById(R.id.threePointsTeamA);
        threePointsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scoreTeamA += 3;
                displayScoreTeamA(scoreTeamA);
            }
        });

        final Button twoPointsTeamA = (Button) findViewById(R.id.twoPointsTeamA);
        twoPointsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scoreTeamA += 2;
                displayScoreTeamA(scoreTeamA);
            }
        });

        final Button freeThrowTeamA = (Button) findViewById(R.id.freeThrowTeamA);
        freeThrowTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scoreTeamA += 1;
                displayScoreTeamA(scoreTeamA);
            }
        });

        final Button threePointsTeamB = (Button) findViewById(R.id.threePointsTeamB);
        threePointsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scoreTeamB += 3;
                displayScoreTeamB(scoreTeamB);
            }
        });

        final Button twoPointsTeamB = (Button) findViewById(R.id.twoPointsTeamB);
        twoPointsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scoreTeamB += 2;
                displayScoreTeamB(scoreTeamB);
            }
        });

        final Button freeThrowTeamB = (Button) findViewById(R.id.freeThrowTeamB);
        freeThrowTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scoreTeamB += 1;
                displayScoreTeamB(scoreTeamB);
            }
        });

        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scoreTeamA = 0;
                scoreTeamB = 0;
                displayScoreTeamA(scoreTeamA);
                displayScoreTeamB(scoreTeamB);
            }
        });
    }

    public void displayScoreTeamA (int score){

        TextView scoreView = (TextView) findViewById(R.id.scoreTeam_A);
        scoreView.setText(String.valueOf(score));
    }

    public void displayScoreTeamB (int score){

        TextView scoreView = (TextView) findViewById(R.id.scoreTeam_B);
        scoreView.setText(String.valueOf(score));
    }
}
