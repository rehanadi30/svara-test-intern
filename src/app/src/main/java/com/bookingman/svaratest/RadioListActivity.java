package com.bookingman.svaratest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bookingman.svaratest.model.Radio;

import java.util.ArrayList;

public class RadioListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RadioAdapter adapter;
    private ArrayList<Radio> radioArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_recycler);

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new RadioAdapter(radioArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RadioListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void addData() {
        radioArrayList = new ArrayList<>();
        radioArrayList.add(new Radio("Ardan", "Jakarta", 107.9, "logo", "stream", "website", 1, "images"));
        radioArrayList.add(new Radio("Prambors", "Las Vegas", 107.8, "logo", "stream", "website", 2, "images"));
        radioArrayList.add(new Radio("JakFM", "Bandung", 107.7, "logo", "stream", "website", 3, "images"));
        radioArrayList.add(new Radio("8EH Radio ITB", "Tangerang", 107.6, "logo", "stream", "website", 4, "images"));
    }
}
