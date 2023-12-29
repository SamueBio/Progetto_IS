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
    private ImageButton search;
    private ImageButton profilo;
    private ImageButton preferiti;

    private ImageButton faq;

    private ImageButton notif;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.dashboard);

        faq = (ImageButton) findViewById(R.id.faq);
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFaq();
            }
        });


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

       /* notif = (ImageButton) findViewById(R.id.notifica);
        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNot();
            }
        });*/
    }

    public void openFaq(){
        Intent intent=new Intent(this, Faq.class);
        startActivity(intent);
    }

    public void openSearch(){
        //SERVIZI RESET
        GlobalData.getInstance().setFalse();

        Intent intent=new Intent(this, Cerca.class);
        startActivity(intent);
    }

    public void openProfile(){
        Intent intent=new Intent(this, Profilo.class);
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
