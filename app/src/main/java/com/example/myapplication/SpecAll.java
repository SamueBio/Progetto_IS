package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Accommodation;

public class SpecAll extends AppCompatActivity {
    private TextView indirizzo;
    private TextView nome;
    private TextView telefono;
    private TextView sito;
    private TextView email;
    private TextView inviaRichiesta;
    private ImageView cuore;

    private Accommodation acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.alloggio);


        cuore = findViewById(R.id.pref);
        nome= findViewById(R.id.nameTextView);
        indirizzo = findViewById(R.id.locationTextView);
        telefono=findViewById(R.id.telefono2);
        email=findViewById(R.id.email2);
        sito=findViewById(R.id.sito2);
        inviaRichiesta = findViewById(R.id.inviaRichiesta);

        inviaRichiesta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { inviaRic(v);
            }
        });

        Intent intent = getIntent();
        acc = (Accommodation) intent.getSerializableExtra("alloggio");
        nome.setText(acc.getName());
        indirizzo.setText(acc.getAddress()+", "+acc.getInterno()+" "+acc.getCap()+" "+acc.getTown());
        telefono.setText(acc.getTelephone());
        email.setText(acc.getEmail());
        sito.setText(acc.getWebsite());
    }

    public void inviaRic(View view){
        Intent intent=new Intent(this, InviaRichiesta.class);
        intent.putExtra("alloggio", acc);
        startActivity(intent);
    }
}
