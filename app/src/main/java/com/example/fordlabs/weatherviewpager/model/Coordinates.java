package com.example.fordlabs.weatherviewpager.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Coordinates implements Serializable {
    @SerializedName("lon")
    private double lon;

    @SerializedName("lat")
    private double lat;

    public Coordinates(Integer lon, Integer lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(Integer lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }
}
