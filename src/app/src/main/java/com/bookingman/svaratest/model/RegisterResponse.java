package com.bookingman.svaratest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegisterResponse {
    @SerializedName("username")
    private String username;
    @SerializedName("isGuest")
    private Boolean isGuest;
    @SerializedName("id")
    private String id;

    public RegisterResponse(String username, Boolean isGuest, String id) {
        this.username = username;
        this.isGuest = isGuest;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getGuest() {
        return isGuest;
    }

    public void setGuest(Boolean guest) {
        isGuest = guest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
