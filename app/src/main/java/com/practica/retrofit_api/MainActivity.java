package com.practica.retrofit_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

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
    TextView tv_cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        tv_cantidad = findViewById(R.id.textView_total);
        artistList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.seatgeek.com/2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ArtistAPI artistAPI = retrofit.create(ArtistAPI.class);
        ArrayList<Artist> totalArtistas = new ArrayList<>();
        Call<Artist> callSingleArtist = artistAPI.getArtist(266);
        /*Call<JSONResponse> callAll1 = artistAPI.getArtists("concerts", 1, "id.asc", 5000);
        Call<JSONResponse> callAll2 = artistAPI.getArtists("concerts", 2, "id.asc", 5000);
        Call<JSONResponse> callAll3 = artistAPI.getArtists("concerts", 3, "id.asc", 5000);
        Call<JSONResponse> callAll4 = artistAPI.getArtists("concerts", 4, "id.asc", 5000);*/

        callSingleArtist.enqueue(new Callback<Artist>() {
            @Override
            public void onResponse(Call<Artist> call, Response<Artist> response) {
                Artist artist = response.body();
                totalArtistas.add(artist);
                PutDataIntoRecyclerView(totalArtistas);
            }

            @Override
            public void onFailure(Call<Artist> call, Throwable t) {

            }
        });

/*
        callAll1.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                artistList = new ArrayList<>(jsonResponse.getArtistsArray());
                totalArtistas.addAll(artistList);

                PutDataIntoRecyclerView(totalArtistas);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });

        callAll2.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                artistList = new ArrayList<>(jsonResponse.getArtistsArray());
                totalArtistas.addAll(artistList);
                PutDataIntoRecyclerView(totalArtistas);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });

        callAll3.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                artistList = new ArrayList<>(jsonResponse.getArtistsArray());
                totalArtistas.addAll(artistList);

                PutDataIntoRecyclerView(totalArtistas);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });

        callAll4.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                artistList = new ArrayList<>(jsonResponse.getArtistsArray());
                totalArtistas.addAll(artistList);

                PutDataIntoRecyclerView(totalArtistas);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });
*/

    }

    private void PutDataIntoRecyclerView(List<Artist> artistList) {
        ArtistAdapter artistAdapter = new ArtistAdapter(this, artistList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(artistAdapter);
        tv_cantidad.setText("Total: " + artistAdapter.getItemCount());
    }

}

