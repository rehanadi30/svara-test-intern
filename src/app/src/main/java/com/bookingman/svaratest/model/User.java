package com.bookingman.svaratest.model;

public class User {
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
