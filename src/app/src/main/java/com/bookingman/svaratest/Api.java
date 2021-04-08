package com.bookingman.svaratest;

import com.bookingman.svaratest.model.DefaultResponse;
import com.bookingman.svaratest.model.LoginResponse;
import com.bookingman.svaratest.model.Radio;
import com.bookingman.svaratest.model.RadioResponse;
import com.bookingman.svaratest.model.RegisterResponse;
import com.bookingman.svaratest.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    @FormUrlEncoded
    @POST("users/register")
    Call<RegisterResponse> registerUser(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("users/login")
    Call<LoginResponse> signInUser(
            @Field("username") String username,
            @Field("password") String password
    );

    @POST("users/guest-mode")
    Call<LoginResponse> guestMode();

    @FormUrlEncoded
    @GET("/radios?access_token={token}")
    Call<List<RadioResponse>> getRadioAll(
            @Path("token") String accessToken
    );

    @FormUrlEncoded
    @GET("/radios/:{id}?access_token={token}")
    Call<RadioResponse> getRadioById(
            @Path("id") int id,
            @Path("token") String token
    );
}
