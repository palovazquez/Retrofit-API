package com.practica.retrofit_api.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artist {
    private String name;
    @SerializedName("url")
    @Expose
    private String urlTickets;
    private String image;
    private String id;
    private Link[] links;

    public Artist(String name, String urlTickets, String image, String id, Link[] links) {
        this.name = name;
        this.urlTickets = urlTickets;
        this.image = image;
        this.id = id;
        this.links = links;
    }

    public String getName() {
        return name;
    }
    public String getUrlTickets() {
        return urlTickets;
    }
    public String getImage() {
        return image;
    }
    public String getId() {
        return id;
    }
    public Link[] getLinks() {
        return links;
    }
}

