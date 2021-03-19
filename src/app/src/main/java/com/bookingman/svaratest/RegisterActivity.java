package com.bookingman.svaratest;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bookingman.svaratest.model.DefaultResponse;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    //Atribute Global
    private EditText username;
    private EditText password;
    private Button registerBtn;
    private TextView signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        username = (EditText) findViewById(R.id.form_namapengguna);
        password = (EditText) findViewById(R.id.form_katasandi);

        signIn = (TextView) findViewById(R.id.signInText);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        registerBtn = (Button) findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String txt_namaPengguna = username.getText().toString();
                String txt_kataSandi = password.getText().toString();
                if (TextUtils.isEmpty(txt_namaPengguna) || TextUtils.isEmpty(txt_kataSandi)) {
                    Toast.makeText(RegisterActivity.this, "Field ini tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else {
                    registerPengguna(txt_namaPengguna, txt_kataSandi);
                    Toast.makeText(RegisterActivity.this, "Register Berhasil!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, RadioActivity.class);
                    startActivity(intent);
                }
            }

            public void registerPengguna(String txt_namaPengguna, String txt_katasandi) {
                Call<DefaultResponse> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .registerUser(txt_namaPengguna, txt_katasandi);

                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        if (response.code() == 201) {

                            DefaultResponse dr = response.body();
                            Toast.makeText(RegisterActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();

                        } else if (response.code() == 422) {
                            Toast.makeText(RegisterActivity.this, "User already exist", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
