package com.nbs.footballapp.api;

import com.nbs.footballapp.response.TeamResponse;

import retrofit2.Call;

public class ApiConnection {
    private static final String BASE_URL =
            "https://www.thesportsdb.com/api/v1/json/1/";

    public static Call<TeamResponse> getTeamList(String league){
        return ApiService.createService(ApiClient.class,
                OkHttpClientFactory.create(), BASE_URL)
                .getTeams(league);
    }
}
