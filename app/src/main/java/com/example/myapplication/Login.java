package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.crypto.CryptoUtils;
import com.example.myapplication.retrofit.RetrofitService;
import com.example.myapplication.retrofit.UserApi;
import com.google.android.material.button.MaterialButton;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
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

            if(!isEmpty(username)&&!isEmpty(password)){
                /*HashMap<String,String> param = new HashMap<String,String>();
                param.put("username", String.valueOf(username.getText()));
                param.put("password",String.valueOf(password.getText()));*/

                String hashedPassword = CryptoUtils.hashPassword(String.valueOf(password.getText()));
                JsonObject jsonBody = new JsonObject();
                jsonBody.addProperty("username", String.valueOf(username.getText()));
                jsonBody.addProperty("password", hashedPassword);

                Call<ResponseBody> call = userApi.login(jsonBody);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            try {
                                String responseBody = response.body().string();
                                Toast.makeText(Login.this, "Login effettuato", Toast.LENGTH_SHORT).show();
                                //System.out.println("!!!  RESPONDE !!!: "+ responseBody);
                                openSearch();
                            } catch (IOException e) {
                                //System.out.println("!!!  ECCEZIONE !!!");
                                e.printStackTrace();
                            }
                        } else {
                            //System.out.println("!!!  NON TROVATO !!!");
                            Toast.makeText(Login.this, "Login fallito", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        // Gestisci il caso di fallimento qui
                    }
                });
            }

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
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}