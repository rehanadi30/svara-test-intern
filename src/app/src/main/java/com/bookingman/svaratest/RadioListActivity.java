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

    }
}
