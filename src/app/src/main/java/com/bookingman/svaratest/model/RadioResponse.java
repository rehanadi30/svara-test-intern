package com.bookingman.svaratest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RadioResponse {
    @SerializedName("name")
    private String name;
    @SerializedName("city")
    private String city;
    @SerializedName("frequency")
    private Double frequency;
    @SerializedName("logo")
    private String logo;
    @SerializedName("stream")
    private String stream;
    @SerializedName("website")
    private String website;
    @SerializedName("id")
    private int id;
//    @SerializedName("images")
//    private ArrayList<RadioImages> images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public ArrayList<RadioImages> getImages() {
//        return images;
//    }
//
//    public void setImages(ArrayList<RadioImages> images) {
//        this.images = images;
//    }

    public RadioResponse(String name, String city, Double frequency, String logo, String stream, String website, int id, ArrayList<RadioImages> images) {
        this.name = name;
        this.city = city;
        this.frequency = frequency;
        this.logo = logo;
        this.stream = stream;
        this.website = website;
        this.id = id;
//        this.images = images;
    }
}
