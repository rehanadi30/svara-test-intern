package com.bookingman.svaratest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bookingman.svaratest.model.DefaultResponse;
import com.bookingman.svaratest.model.LoginResponse;
import com.bookingman.svaratest.model.RegisterResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class RegisterFragment extends Fragment {
    private Button registerButton;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private String txt_username;
    private String txt_password;
    private TextView skipText;
    public String TOKEN;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        skipText = v.findViewById(R.id.skipText);
        skipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<LoginResponse> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .guestMode();
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        LoginResponse loginResponse = response.body();
                        if(loginResponse != null){
                            Toast.makeText(getActivity(), "Sign In Berhasil!", Toast.LENGTH_SHORT).show();

                            Log.d(TAG, "User: " + loginResponse.getUsername());
                            TOKEN = response.body().getToken();
                            Log.d(TAG, "Token: " + TOKEN);

                            Intent i = new Intent(getActivity(), RadioListActivity.class);
                            i.putExtra("TOKEN", TOKEN);
                            startActivity(i);
                            ((Activity) getActivity()).overridePendingTransition(0, 0);
                        } else{
//                            Log.d(TAG, "Username yang masuk adalah: " + txt_username);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });
            }
        });

        usernameEditText = (EditText) v.findViewById(R.id.et_username);
        txt_username = usernameEditText.toString();

        passwordEditText = (EditText) v.findViewById(R.id.et_password);
        txt_password = passwordEditText.toString();

        registerButton = (Button) v.findViewById(R.id.btn_register);
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                registerUser(txt_username, txt_password);
            }

            private void registerUser(final String txt_username, final String txt_password) {
                //Dapetin tokennya
                Call<RegisterResponse> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .registerUser(txt_username, txt_password);

                call.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if (response != null) {
                            Toast.makeText(getActivity(), "Register Berhasil! Silakan login melalui panel login", Toast.LENGTH_LONG).show();

                        } else{
                            Toast.makeText(getActivity(), "Register Gagal!", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return v;
    }

}