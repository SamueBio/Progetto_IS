package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.crypto.CryptoUtils;
import com.example.myapplication.retrofit.RetrofitService;
import com.example.myapplication.retrofit.UserApi;
import com.google.android.material.button.MaterialButton;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;

    TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        MaterialButton loginButton = findViewById(R.id.loginButton);
        register=findViewById(R.id.register);
        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);
        String inputUsername = String.valueOf(username.getText());
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), inputUsername);
        loginButton.setOnClickListener( View -> {
            userApi.findPasswordById(String.valueOf(username.getText())).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    openSearch();
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    // Handle the failure case
                    Toast.makeText(Login.this, "Network request failed", Toast.LENGTH_SHORT).show();
                }
            });
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegis();
            }

        });
    }
    public void openSearch(){
        Intent intent=new Intent(this, Dashboard.class);
        startActivity(intent);
    }
    public void openRegis(){
        Intent intent=new Intent(this, Registrazione.class);
        startActivity(intent);
    }

}