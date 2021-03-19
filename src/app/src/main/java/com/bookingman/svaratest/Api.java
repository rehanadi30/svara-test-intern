package com.bookingman.svaratest;

import com.bookingman.svaratest.model.DefaultResponse;
import com.bookingman.svaratest.model.LoginResponse;
import com.bookingman.svaratest.model.RadioResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {
    @FormUrlEncoded
    @POST("users/register")
    Call<DefaultResponse> registerUser(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("users/login")
    Call<LoginResponse> signInUser(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("users/guest-mode")
    Call<ResponseBody> guestMode();

    @FormUrlEncoded
    @GET("/radios?access_token={token}")
    Call<RadioResponse> getRadioAll(
            @Path("token") String accessToken
    );

    @FormUrlEncoded
    @GET("/radios/:{id}?access_token={token}")
    Call<RadioResponse> getRadioById(
            @Path("id") int id,
            @Path("token") String token
    );
}
