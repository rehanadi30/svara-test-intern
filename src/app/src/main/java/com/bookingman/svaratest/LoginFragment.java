package com.bookingman.svaratest;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.bookingman.svaratest.model.LoginResponse;
import com.bookingman.svaratest.model.User;

import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class LoginFragment extends Fragment {
    private Button loginButton;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private String txt_username = "";
    private String txt_password = "";
    private TextView skipText;
    public String TOKEN;

    public User currUser;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

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

                            currUser = new User(loginResponse.getId(), loginResponse.getUsername(), loginResponse.getToken(), loginResponse.getExpire());

                            Log.d(TAG, "User: " + loginResponse.getUsername());
                            TOKEN = response.body().getToken();
                            Log.d(TAG, "Token: " + TOKEN);

                            Intent i = new Intent(getActivity(), RadioListActivity.class);
                            i.putExtra("User", currUser);
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

        usernameEditText = v.findViewById(R.id.et_usernameLogin);

        passwordEditText = v.findViewById(R.id.et_passwordLogin);

        loginButton = (Button) v.findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                txt_username = usernameEditText.getText().toString();
                txt_password = passwordEditText.getText().toString();
                if(txt_username.matches("") || txt_password.matches("") ){
                    Log.d(TAG, "Field masih kosong! ");
                }
                else{
                    Log.d(TAG, "Username yang masuk adalah: " + txt_username);
                    loginUser(txt_username, txt_password);
                }
        }

            @RequiresApi(api = Build.VERSION_CODES.N)
            private void loginUser(String txt_username, String txt_password) {
                Call<LoginResponse> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .signInUser(txt_username, txt_password);

                call.enqueue(new Callback<LoginResponse>(){
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response){
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
                        Toast.makeText(getActivity(), "Login Gagal", Toast.LENGTH_LONG).show();
                    }
                });
            }
            });

        return v;
    }

}