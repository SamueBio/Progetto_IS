package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String mail;
    private ImageButton search;
    private ImageButton profilo;
    private ImageButton preferiti;

    private ImageButton notif;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.dashboard);

        Intent intent = getIntent();

        // Recupero della variabile dalla chiave specificata
        username = intent.getStringExtra("user");
        password = intent.getStringExtra("pw");
        nome = intent.getStringExtra("nome");
        cognome = intent.getStringExtra("cognome");
        mail = intent.getStringExtra("mail");
        search = (ImageButton) findViewById(R.id.lente);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearch();
            }
        });

        profilo = (ImageButton) findViewById(R.id.btnProfilo);
        profilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });
        preferiti = (ImageButton) findViewById(R.id.preferiti);
        preferiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPref();
            }
        });

        notif = (ImageButton) findViewById(R.id.notifica);
        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNot();
            }
        });
    }
    public void openSearch(){
        Intent intent=new Intent(this, Cerca.class);
        startActivity(intent);
    }

    public void openProfile(){
        Intent intent=new Intent(this, Profilo.class);
        intent.putExtra("user", username);
        intent.putExtra("pw", password);
        intent.putExtra("nome",nome);
        intent.putExtra("cognome",cognome);
        intent.putExtra("mail",mail);
        startActivity(intent);
    }

    public void openPref(){
        Intent intent=new Intent(this, Preferiti.class);
        startActivity(intent);
    }

    public void openNot(){
        Intent intent=new Intent(this, Notifiche.class);
        startActivity(intent);
    }


}
