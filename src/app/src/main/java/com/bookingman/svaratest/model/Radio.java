package com.bookingman.svaratest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Radio implements Parcelable {
    public String name;
    public String city;
    public double frequency;
    public String logo;
    public String stream;
    public String website;
    public int id;
//    public String images;

    public Radio(String name, String city, double frequency, String logo, String stream, String website, int id) {
        this.name = name;
        this.city = city;
        this.frequency = frequency;
        this.logo = logo;
        this.stream = stream;
        this.website = website;
        this.id = id;
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

    public void setFrequency(double frequency) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.city);
        dest.writeDouble(this.frequency);
        dest.writeString(this.logo);
        dest.writeString(this.stream);
        dest.writeString(this.website);
        dest.writeInt(this.id);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.city = source.readString();
        this.frequency = source.readDouble();
        this.logo = source.readString();
        this.stream = source.readString();
        this.website = source.readString();
        this.id = source.readInt();
    }

    protected Radio(Parcel in) {
        this.name = in.readString();
        this.city = in.readString();
        this.frequency = in.readDouble();
        this.logo = in.readString();
        this.stream = in.readString();
        this.website = in.readString();
        this.id = in.readInt();
    }

    public static final Creator<Radio> CREATOR = new Creator<Radio>() {
        @Override
        public Radio createFromParcel(Parcel source) {
            return new Radio(source);
        }

        @Override
        public Radio[] newArray(int size) {
            return new Radio[size];
        }
    };
}
