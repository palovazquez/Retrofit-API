package com.practica.retrofit_api.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JSONResponse {
    @SerializedName("performers")
    @Expose
    //private Artist[] performersArray;
    private ArrayList<Artist> performersArray;

    public ArrayList<Artist> getPerformersArray() {
        return performersArray;
    }

    public void setArtistsArray(ArrayList<Artist> performersArray) {
        this.performersArray = performersArray;
    }

    public ArrayList<Artist> getArtistsArray() {
        /*
        ArrayList<Artist> artistsArray = new ArrayList<>();
        for(Artist artist : performersArray){
           boolean isMusician = false;
           for(PerformerType taxonomy : artist.getTaxonomies()){
               if(taxonomy.getName().equals("concert") || taxonomy.getName().equals("concerts")) isMusician = true;
           }
            if(isMusician) artistsArray.add(artist);
        }
        return artistsArray;
        */
        return performersArray;
    }
}
