package com.practica.retrofit_api.Interfaces;

import com.practica.retrofit_api.Classes.JSONResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ArtistAPI {

    @GET("performers?client_id=MjE1Mzk3MDJ8MTYxMzAwMTQ3OC4zNDE5MzU0")
    Call<JSONResponse> getArtists();
}
