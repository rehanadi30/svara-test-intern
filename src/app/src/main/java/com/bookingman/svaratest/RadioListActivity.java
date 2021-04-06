package com.bookingman.svaratest;

import android.content.Intent;
import android.os.Bundle;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RadioListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RadioAdapter adapter;
    private ArrayList<Radio> radioArrayList;
    private Radio selected_radio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_recycler);

        addData();

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

    private void addData() {
//        Call<RadioResponse> call = RetrofitClient
//                .getInstance()
//                .getApi()
//                .getRadioAll(token);
//        call.enqueue(new Callback<RadioResponse>(){
//            @Override
//            public void onResponse(Call<RadioResponse> call, Response<RadioResponse> response){
//                RadioResponse radioResponse = response.body();
//                JsonObject obj = null;
//
//                try{
//                    obj = new JsonObject(radioResponse.toString());
//                } catch (JSONException e){
//                    e.printStackTrace();
//                }
//
//                if(!radioResponse.isError()){
//                    Toast.makeText(RadioListActivity.this, "Radio berhasi. difetch!", Toast.LENGTH_SHORT).show();
//                } else{
//                    Toast.makeText(RadioListActivity.this, radioResponse.getMessage(), Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//
//            }
//        });
        radioArrayList = new ArrayList<>();
        for (int i = 0; i < radioArrayList.size(); i++){
//            radioArrayList.add();
        }
        radioArrayList.add(new Radio("Ardan", "Jakarta", 107.9, "logo", "stream", "website", 1, "images"));
        radioArrayList.add(new Radio("Prambors", "Las Vegas", 107.8, "logo", "stream", "website", 2, "images"));
        radioArrayList.add(new Radio("JakFM", "Bandung", 107.7, "logo", "stream", "website", 3, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
    }
}
