package com.bookingman.svaratest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    public int id;
    public String username;
    public String password;
    public String token;
    public int expire;

    public User(int id, String username, String password, String token, int expire) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
        this.expire = expire;
    }

    protected User(Parcel in) {
        id = in.readInt();
        username = in.readString();
        password = in.readString();
        token = in.readString();
        expire = in.readInt();
    }

    public User() {
        id = 0;
        username = "rehan";
        password = "password";
        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2MDU0MWEzMzNmNGM2Nzc0Y2E0MjQ3ODIiLCJpYXQiOjE2MTYxMjQ0NjcsImV4cCI6MzIzMjI0OTUzNCwiaXNzIjoiZWYzMTAwMWUzN2VkNjQxODQyNGYifQ.ZL_yi365s4BrK2_GZDmctFym7MEqF0Vgs4DKpi61CXY";
        expire = 5000;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(token);
        dest.writeInt(expire);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }
}
