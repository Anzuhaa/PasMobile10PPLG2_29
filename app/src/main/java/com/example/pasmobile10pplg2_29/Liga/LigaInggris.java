package com.example.pasmobile10pplg2_29.Liga;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pasmobile10pplg2_29.API_1.Team;
import com.example.pasmobile10pplg2_29.API_1.TeamAdapter;
import com.example.pasmobile10pplg2_29.API_1.TeamResponse;
import com.example.pasmobile10pplg2_29.API_1.TeamService;
import com.example.pasmobile10pplg2_29.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LigaInggris extends Fragment {
    private static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/3/";
    private RecyclerView recyclerView;
    private TeamAdapter teamAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liga_inggris, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchData();
        return view;
    }
    private void fetchData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TeamService service = retrofit.create(TeamService.class);
        Call<TeamResponse> call = service.getTeams();
        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful()) {
                    TeamResponse teamResponse = response.body();
                    if (teamResponse != null) {
                        List<Team> teams = teamResponse.getTeams();
                        teamAdapter = new TeamAdapter(getContext(), teams);
                        recyclerView.setAdapter(teamAdapter);
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
            }
        });
    }

}
