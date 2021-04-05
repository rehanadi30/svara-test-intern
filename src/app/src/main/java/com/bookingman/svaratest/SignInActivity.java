package com.bookingman.svaratest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bookingman.svaratest.model.LoginResponse;
import com.bookingman.svaratest.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    //Attribute Global
    private EditText username;
    private EditText password;
    private Button signInBtn;
    private TextView registerText;

    public User currUser;

    public String TOKEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        username = (EditText) findViewById(R.id.form_namapengguna);
        password = (EditText) findViewById(R.id.form_katasandi);

        registerText = (TextView) findViewById(R.id.registerText);
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        signInBtn = (Button) findViewById(R.id.masukBtn);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_namaPengguna = username.getText().toString().trim();
                String txt_kataSandi = password.getText().toString().trim();
                if (TextUtils.isEmpty(txt_namaPengguna) || TextUtils.isEmpty(txt_kataSandi)) {
                    Toast.makeText(SignInActivity.this, "Field ini tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignInActivity.this, "Username: " + txt_namaPengguna, Toast.LENGTH_SHORT).show();
                    loginPengguna(txt_namaPengguna, txt_kataSandi);
                }
            }

            public void loginPengguna(String txt_namaPengguna, String txt_katasandi) {
                Call<LoginResponse> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .signInUser(txt_namaPengguna, txt_katasandi);


                call.enqueue(new Callback<LoginResponse>(){
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response){
                        LoginResponse loginResponse = response.body();

                        if(!loginResponse.isError()){
                            Toast.makeText(SignInActivity.this, "Sign In Berhasil!", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(SignInActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });
                currUser = new User();
                Intent i = new Intent(SignInActivity.this, RadioListActivity.class);
                i.putExtra("currUser", currUser);
                startActivity(i);
            }
        });
    }

}
