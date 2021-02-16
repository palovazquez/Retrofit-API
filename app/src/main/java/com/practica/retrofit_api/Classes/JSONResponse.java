package com.practica.retrofit_api.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONResponse {
    @SerializedName("performers")
    @Expose
    private Artist[] artistsArray;

    public Artist[] getArtistsArray() {
        return artistsArray;
    }
    public void setArtistsArray(Artist[] artistsArray) {
        this.artistsArray = artistsArray;
    }
}
