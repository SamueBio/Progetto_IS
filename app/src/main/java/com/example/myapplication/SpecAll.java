package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SpecAll extends AppCompatActivity {
    private TextView indirizzoAll;
    private TextView nomeAll;
    private TextView inviaRichiesta;
    private ImageView cuore;
    private ImageView casa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.alloggio);


        cuore = findViewById(R.id.pref);
        casa = findViewById(R.id.home);
        nomeAll= findViewById(R.id.nameTextView);
        indirizzoAll = findViewById(R.id.locationTextView);
        inviaRichiesta = findViewById(R.id.inviaRichiesta);

        inviaRichiesta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { inviaRic(v);
            }
        });

       /* Intent intent = getIntent();
        String messaggio = intent.getStringExtra("nome_alloggio");
        nomeAll.setText(messaggio);*/

    }

    public void inviaRic(View view){
        Intent intent=new Intent(this, InviaRichiesta.class);
        startActivity(intent);
    }

    public void openLogin(){
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);
    }

    public void openSearch(){
        Intent intent=new Intent(this, Cerca.class);
        startActivity(intent);
    }
}
