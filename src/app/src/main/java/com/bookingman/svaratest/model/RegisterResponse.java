package com.bookingman.svaratest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegisterResponse {
    @SerializedName("username")
    private String username;
    @SerializedName("isGuest")
    private Boolean isGuest;
    @SerializedName("sessions")
    private List sessions;
    @SerializedName("id")
    private String id;
}
