package com.nbs.footballapp.response;

import com.google.gson.annotations.SerializedName;
import com.nbs.footballapp.model.Team;

import java.util.ArrayList;

public class TeamResponse {

    @SerializedName("teams")
    private ArrayList<Team> teams = new ArrayList<>();

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }
}
