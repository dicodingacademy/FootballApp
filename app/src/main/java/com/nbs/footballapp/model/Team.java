package com.nbs.footballapp.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("strTeam")
    private String name;

    @SerializedName("idTeam")
    private String id;

    @SerializedName("strTeamBadge")
    private String logo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
