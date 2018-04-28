package com.nbs.footballapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ViewUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nbs.footballapp.api.ApiConnection;
import com.nbs.footballapp.model.Team;
import com.nbs.footballapp.response.TeamResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements TeamAdapter.OnTeamClickCallback{

    private RecyclerView rvItems;

    private ProgressBar progressBar;

    private TeamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvItems = findViewById(R.id.rv_items);

        progressBar = findViewById(R.id.progressbar);

        rvItems.setHasFixedSize(true);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        rvItems.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adapter = new TeamAdapter();
        adapter.setOnTeamClickCallback(this);
        adapter.setTeams(new ArrayList<Team>());

        rvItems.setAdapter(adapter);

        progressBar.setVisibility(View.VISIBLE);

        ApiConnection.getTeamList("English Premier League")
                .enqueue(new Callback<TeamResponse>() {
                    @Override
                    public void onResponse(Call<TeamResponse> call,
                                           Response<TeamResponse> response) {

                        progressBar.setVisibility(View.GONE);

                        adapter.setTeams(response
                            .body().getTeams());
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<TeamResponse> call,
                                          Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        toast("gagal tidak terhubung ke server");
                    }
                });
    }

    private void toast(String message){
        Toast.makeText(this, message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTeamClicked(Team team) {
        Intent intent = new Intent(MainActivity.this,
                DetailFootballTeamActivity.class);
        intent.putExtra(DetailFootballTeamActivity.BUNDLE_TEAM_LOGO,
                team.getLogo());
        intent.putExtra(DetailFootballTeamActivity.BUNDLE_TEAM_NAME,
                team.getName());
        startActivity(intent);
    }
}
