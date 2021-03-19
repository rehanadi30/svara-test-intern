package com.bookingman.svaratest.model;

public class Radio {
    public String name;
    public String city;
    public double frequency;
    public String logo;
    public String stream;
    public String website;
    public int id;
    public String images;

    public Radio(String name, String city, double frequency, String logo, String stream, String website, int id, String images) {
        this.name = name;
        this.city = city;
        this.frequency = frequency;
        this.logo = logo;
        this.stream = stream;
        this.website = website;
        this.id = id;
        this.images = images;
    }

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

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
