package com.example.pasmobile10pplg2_29.API_2;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamService {
    @GET("search_all_teams.php?l=Spanish%20La%20Liga")
    Call<TeamResponse> getTeams();
}
