package com.bookingman.svaratest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bookingman.svaratest.model.LoginResponse;
import com.bookingman.svaratest.model.Radio;
import com.bookingman.svaratest.model.RadioResponse;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RadioActivity extends AppCompatActivity {
    public int id;

    public TextView namaRadio;
    public ImageView gambarRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_activity);

        Radio radio = getIntent().getParcelableExtra("Radio_Terpilih");

        id = radio.getId();
        String url = radio.getImages();
        String urlTest1 = "https://goo.gl/ghVPFq";
        String urlTest2 = "https://api.svara.id/svara-radio-logo/download/573e8bfd0c3f8b20491c8147";
        namaRadio = findViewById(R.id.namaRadio);
        namaRadio.setText(radio.getName());

        gambarRadio = findViewById(R.id.gambarRadio);
        Picasso.get().load(urlTest1).into(gambarRadio);
    }
}
