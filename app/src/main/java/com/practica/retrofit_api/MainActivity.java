package com.practica.retrofit_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.practica.retrofit_api.Adapters.ArtistAdapter;
import com.practica.retrofit_api.Classes.Artist;
import com.practica.retrofit_api.Classes.JSONResponse;
import com.practica.retrofit_api.Interfaces.ArtistAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Artist> artistList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        artistList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.seatgeek.com/2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ArtistAPI artistAPI = retrofit.create(ArtistAPI.class);
        Call<JSONResponse> call = artistAPI.getArtists();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                artistList = new ArrayList<>(Arrays.asList(jsonResponse.getArtistsArray()));

                PutDataIntoRecyclerView(artistList);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });

    }

    private void PutDataIntoRecyclerView(List<Artist> artistList) {
        ArtistAdapter artistAdapter = new ArtistAdapter(this, artistList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(artistAdapter);
    }

}

