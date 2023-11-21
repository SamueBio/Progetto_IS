package com.example.myapplication;

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



public class Registrazione extends AppCompatActivity {

    EditText nome;
    EditText cognome;
    EditText email;
    EditText password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrazione);

        nome = findViewById(R.id.nome);
        cognome = findViewById(R.id.cognome);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.registerButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
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
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }

    void checkDataEntered() {
        if (isEmpty(nome)) {
            nome.setError("Inserisci nome!");
        }

        if (isEmpty(cognome)) {
            cognome.setError("Inserisci cognome!");
        }

        if (isEmail(email) == false) {
            email.setError("Inserisci mail valida!");
        }

        if(isPasswordSecure(password.getText().toString())) {
            password.setError("error");
        }

    }

}
