package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.crypto.CryptoUtils;
import com.example.myapplication.model.User;
import com.example.myapplication.retrofit.RetrofitService;
import com.example.myapplication.retrofit.UserApi;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Registrazione extends AppCompatActivity {

    TextInputEditText inputEditTextUsername;
    TextInputEditText inputEditTextFirstName;
    TextInputEditText inputEditTextLastName;
    TextInputEditText inputEditTextEmail;
    TextInputEditText inputEditTextPassword;
    MaterialButton buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrazione);
        initializeComponent();
    }

    private void initializeComponent() {
        inputEditTextUsername = findViewById(R.id.username);
        inputEditTextFirstName = findViewById(R.id.firstName);
        inputEditTextLastName = findViewById(R.id.lastName);
        inputEditTextEmail = findViewById(R.id.email);
        inputEditTextPassword = findViewById(R.id.password);
        MaterialButton buttonRegister = findViewById(R.id.registerButton);
        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);
        buttonRegister.setOnClickListener(view -> {
            if(checkDataEntered()){
                String username = String.valueOf(inputEditTextUsername.getText());
                String firstName = String.valueOf(inputEditTextFirstName.getText());
                String lastName = String.valueOf(inputEditTextLastName.getText());
                String email = String.valueOf(inputEditTextEmail.getText());
                String password = String.valueOf(inputEditTextPassword.getText());

                User user = new User();
                user.setUsername(username);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setPassword(CryptoUtils.hashPassword(password));
                userApi.save(user).enqueue(new Callback<User>() {

                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                Toast.makeText(Registrazione.this,"Registrazione completata",(int)2).show();
                                openLogin();
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                Toast.makeText(Registrazione.this,"Registrazione fallita",(int)2).show();
                                Logger.getLogger(Registrazione.class.getName()).log(Level.SEVERE,"Error occurred",t);
                            }
                        });
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    private static boolean isPasswordSecure(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&+-])[A-Za-z\\d@$!%*?&+-]{8,}$");
    }

    boolean checkDataEntered() {
    boolean ret = true;
        if (isEmpty(inputEditTextUsername)) {
            inputEditTextUsername.setError("Inserisci username!");
            ret = false;
        }

        if (isEmpty(inputEditTextFirstName)) {
            inputEditTextFirstName.setError("Inserisci nome!");
            ret = false;
        }

        if (isEmpty(inputEditTextLastName)) {
            inputEditTextLastName.setError("Inserisci cognome!");
            ret = false;
        }

        if (isEmail(inputEditTextEmail) == false) {
            inputEditTextEmail.setError("Inserisci mail valida!");
            ret = false;
        }

        if(isEmpty(inputEditTextPassword)||not_Valid_Password(inputEditTextPassword.getText().toString())) {
            inputEditTextPassword.setError("Password non valida");
            ret = false;
        }
        return ret;
    }

    public boolean not_Valid_Password(String password) {
        int mai=0, min=0, num=0, car=0;
        if (password.length() < 8) return true;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if(ch >= '0' && ch <= '9')
                num=1;
            else if (ch >= 'A' && ch <= 'Z')
                mai=1;
            else if (ch >= 'a' && ch <= 'z')
                min=1;
            else if (ch=='!'||ch=='('||ch==')'||ch=='{'||ch=='}'||ch=='+'||ch=='/'||ch=='-'
                ||ch==':'||ch=='.'||ch==','||ch==';'||ch=='*'||ch=='?'||ch=='=')
                car=1;

            if(mai==1&&min==1&&num==1&&car==1)
                return false;
        }
        return true;
    }
    public void openLogin(){
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
    }
    public void openPrivacyPolicy(View v) {
        String url = "https://www.iubenda.com/privacy-policy/47447245.pdf";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

}
