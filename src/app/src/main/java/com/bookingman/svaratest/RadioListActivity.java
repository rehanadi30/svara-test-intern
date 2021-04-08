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
import com.bookingman.svaratest.model.User;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
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
    public User currUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_recycler);

        currUser = getIntent().getParcelableExtra("User");
        TOKEN = currUser.getToken();
//        TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2MDZjMzQyNGI1NDg0OTA2ZTE4OTkzMDAiLCJpYXQiOjE2MTc3MDM5NzIsImV4cCI6MzIzNTQwODU0NSwiaXNzIjoiYTcyMjFlNTg1MTBhMDQyN2ZiNTUifQ.RBYnw-g5rDrkJCfqK7YIaDZu7jd4kwuyXmuwUxpJKcM";
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
//                        selected_radio = RecyclerView.ViewHolder.getPosition(position);
                        selected_radio = new Radio("Radio Svara mantab", "city", 105.5, "logo", "stream", "website", 0);
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
//        for (int i = 0; i < radioArrayList.size(); i++){
//            radioArrayList.add();
//        }
//        Call<List<RadioResponse>> call = RetrofitClient
//                .getInstance()
//                .getApi()
//                .getRadioAll(TOKEN);
//        call.enqueue(new Callback<List<RadioResponse>>(){
//
//            @Override
//            public void onResponse(Call<List<RadioResponse>> call, Response<List<RadioResponse>> response) {
////                RadioResponse r = response.body();
////                Log.d(TAG, r.getName());
////                Radio nowRadio = new Radio(r.getName(), r.getCity(), r.getFrequency(), r.getLogo(), r.getStream(), r.getWebsite(), r.getId());
////                radioArrayList.add(nowRadio);
////                List<RadioResponse> lr = response.body();
////                Log.d(TAG, "Kelas dari bodynya adalah: " + response.body().getClass().toString());
////                radioArrayList = response.body();
//                Log.d("Retrofit Get", "Jumlah radio: " + radioArrayList.size());
//            }
//
//            @Override
//            public void onFailure(Call<List<RadioResponse>> call, Throwable t) {
//                Log.e("Retrofit Get", "Errornya adalah: " + t.getMessage());
//            }
//        });
        radioArrayList.add(new Radio("Ardan", "Jakarta", 107.9, "logo", "stream", "website", 1));
        radioArrayList.add(new Radio("8EH Radio ITB", "Jakarta", 107.9, "logo", "stream", "website", 2));
        radioArrayList.add(new Radio("Duar", "Jakarta", 107.9, "logo", "stream", "website", 3));
        radioArrayList.add(new Radio("Ronaldo", "Jakarta", 107.9, "logo", "stream", "website", 4));
        radioArrayList.add(new Radio("Messi FM", "Jakarta", 107.9, "logo", "stream", "website", 5));
        radioArrayList.add(new Radio("Svara", "Jakarta", 107.9, "logo", "stream", "website", 6));
        radioArrayList.add(new Radio("Dengarkanlah", "Jakarta", 107.9, "logo", "stream", "website", 7));
        radioArrayList.add(new Radio("Aku", "Jakarta", 107.9, "logo", "stream", "website", 8));
        radioArrayList.add(new Radio("Apa kabarnya", "Jakarta", 107.9, "logo", "stream", "website", 9));
        radioArrayList.add(new Radio("Pujaan hatiku", "Jakarta", 107.9, "logo", "stream", "website", 9));
        radioArrayList.add(new Radio("Aku", "Jakarta", 107.9, "logo", "stream", "website", 9));
        radioArrayList.add(new Radio("Disini menunggunya", "Jakarta", 107.9, "logo", "stream", "website", 9));
        radioArrayList.add(new Radio("Masih berharap", "Jakarta", 107.9, "logo", "stream", "website", 9));
        radioArrayList.add(new Radio("Lupa lanjutannya :(", "Jakarta", 107.9, "logo", "stream", "website", 9));
    }
}
