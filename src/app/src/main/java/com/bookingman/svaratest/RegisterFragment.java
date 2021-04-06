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

import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {
    private Button registerButton;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private String txt_username;
    private String txt_password;
    private TextView skipText;


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
                Intent i = new Intent(getActivity(), RadioListActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });

        return v;
    }

}