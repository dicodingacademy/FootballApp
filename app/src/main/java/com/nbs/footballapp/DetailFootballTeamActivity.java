package com.nbs.footballapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailFootballTeamActivity extends AppCompatActivity {

    private TextView tvFootballName;

    private ImageView imgLogo;

    public static final String BUNDLE_TEAM_NAME = "bundle_team_name";

    public static final String BUNDLE_TEAM_LOGO = "bundle_team_logo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_football_team);

        tvFootballName = findViewById(R.id.tv_football_name);

        imgLogo = findViewById(R.id.img_logo);

        String name = getIntent().getStringExtra(BUNDLE_TEAM_NAME);

        String logo = getIntent().getStringExtra(BUNDLE_TEAM_LOGO);

        Picasso.get().load(logo).into(imgLogo);

        tvFootballName.setText(name);
    }
}
