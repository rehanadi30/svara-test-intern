package com.bookingman.svaratest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bookingman.svaratest.model.LoginResponse;
import com.bookingman.svaratest.model.RadioResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RadioActivity extends AppCompatActivity {
    public int id;

    public TextView namaRadio;
    public TextView kota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_activity);
        Intent intent = getIntent();
        id = intent.getIntExtra("message_key", 0);

        Call<RadioResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .getRadioById(id, "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2MDU0MWEzMzNmNGM2Nzc0Y2E0MjQ3ODIiLCJpYXQiOjE2MTYxMjQ0NjcsImV4cCI6MzIzMjI0OTUzNCwiaXNzIjoiZWYzMTAwMWUzN2VkNjQxODQyNGYifQ.ZL_yi365s4BrK2_GZDmctFym7MEqF0Vgs4DKpi61CXY");

        call.enqueue(new Callback<RadioResponse>(){
            @Override
            public void onResponse(Call<RadioResponse> call, Response<RadioResponse> response){
                RadioResponse radioResponse = response.body();

                if(!radioResponse.isError()){

                } else{

                }
            }

            @Override
            public void onFailure(Call<RadioResponse> call, Throwable t) {

            }
        });

    }
}
