package com.bookingman.svaratest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bookingman.svaratest.model.LoginResponse;
import com.bookingman.svaratest.model.Radio;
import com.bookingman.svaratest.model.RadioResponse;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class RadioListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RadioAdapter adapter;
    private ArrayList<Radio> radioArrayList;
    private Radio selected_radio;
    public String TOKEN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_recycler);

        TOKEN = getIntent().getStringExtra("TOKEN");
        Log.d(TAG, "Token: " + TOKEN);

        addData(TOKEN);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new RadioAdapter(radioArrayList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(RadioListActivity.this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(RadioListActivity.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        selected_radio = new Radio("Radio Svara mantab", "city", 105.5, "logo", "stream", "website", 0, "images");
                        Intent i = new Intent(RadioListActivity.this, RadioActivity.class);
                        i.putExtra("Radio_Terpilih", selected_radio);
                        startActivity(i);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }

    private void addData(String TOKEN) {
        radioArrayList = new ArrayList<>();
        for (int i = 0; i < radioArrayList.size(); i++){
//            radioArrayList.add();
        }
        Call<List<RadioResponse>> call = RetrofitClient
                .getInstance()
                .getApi()
                .getRadioAll(TOKEN);
        call.enqueue(new Callback<List<RadioResponse>>() {
            @Override
            public void onResponse(Call<List<RadioResponse>> call, Response<List<RadioResponse>> response) {
                List<RadioResponse> rList = response.body();
                for (int i = 0; i < rList.size(); i++){
                    radioArrayList.add(new Radio("Ardan", "Jakarta", 107.9, "logo", "stream", "website", 1, "images"));
                }
            }

            @Override
            public void onFailure(Call<List<RadioResponse>> call, Throwable t) {

            }
        });
    }
}
