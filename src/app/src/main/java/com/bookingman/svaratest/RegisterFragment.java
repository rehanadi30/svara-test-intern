package com.bookingman.svaratest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bookingman.svaratest.model.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                Intent i = new Intent(getActivity(), RadioListActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
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
                Call<DefaultResponse> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .registerUser(txt_username, txt_password);

                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        if (response.code() == 201) {
                            //Retrieve TOKEN
                            DefaultResponse dr = response.body();
                            Toast.makeText(getActivity(), dr.getMsg(), Toast.LENGTH_LONG).show();

                            Intent i = new Intent(getActivity(), RadioListActivity.class);
                            i.putExtra("TOKEN", TOKEN);
                            startActivity(i);
                            ((Activity) getActivity()).overridePendingTransition(0, 0);

                        } else if (response.code() == 422) {
                            Toast.makeText(getActivity(), "User already exist", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return v;
    }

}