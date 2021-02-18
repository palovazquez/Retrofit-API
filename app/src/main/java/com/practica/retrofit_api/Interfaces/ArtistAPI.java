package com.practica.retrofit_api.Interfaces;

import com.practica.retrofit_api.Classes.Artist;
import com.practica.retrofit_api.Classes.JSONResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ArtistAPI {

    @GET("performers?client_id=MjE1Mzk3MDJ8MTYxMzAwMTQ3OC4zNDE5MzU0")
    Call<JSONResponse> getArtists(
            @Query("taxonomies.name") String taxonomy,
            @Query("page") int page,
            @Query("sort") String sort,
            @Query("per_page") int per_page
    );

    @GET("performers/{artistId}?client_id=MjE1Mzk3MDJ8MTYxMzAwMTQ3OC4zNDE5MzU0")
    Call<Artist> getArtist(
            @Path("artistId") int artistId
    );
}
