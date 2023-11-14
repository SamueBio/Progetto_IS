package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
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

    void checkDataEntered() {
        if (isEmpty(nome)) {
            Toast t = Toast.makeText(this, "Inserisci nome!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(cognome)) {
            cognome.setError("Inserisci cognome!");
        }

        if (isEmail(email) == false) {
            email.setError("Inserisci mail valida!");
        }

    }
}
