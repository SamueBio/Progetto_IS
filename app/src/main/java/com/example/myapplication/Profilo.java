package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Profilo extends AppCompatActivity {
    private String username;
    private String password;
    private String nomee;
    private String cognomee;
    private String maill;

    private AlertDialog alertDialog;

    private ImageButton home;
    private ImageButton nomeMod;
    private ImageButton cognomeMod;
    private ImageButton mailMod;
    private ImageButton pwMod;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.profilo);
        //Intent intent = getIntent();

        // Recupero della variabile dalla chiave specificata
        username =  GlobalData.getInstance().getUsername();
        password = GlobalData.getInstance().getPassword();
        nomee = GlobalData.getInstance().getNome();
        cognomee = GlobalData.getInstance().getCognome();
        maill = GlobalData.getInstance().getMail();
        //System.out.println("USERNAME: "+username+"\nPW: "+password+nome+cognome+mail);
        EditText nome = findViewById(R.id.nome2);
        nome.setText(nomee);
        EditText cognome = findViewById(R.id.cognome2);
        cognome.setText(cognomee);
        EditText mail = findViewById(R.id.email2);
        mail.setText(maill);
        EditText pw = findViewById(R.id.editTextPassword);
        pw.setText(password);

        home = (ImageButton) findViewById(R.id.house);
        nomeMod = (ImageButton) findViewById(R.id.nomeMod);
        cognomeMod = (ImageButton) findViewById(R.id.cognomeMod);
        mailMod = (ImageButton) findViewById(R.id.mailMod);
        pwMod = (ImageButton) findViewById(R.id.pwMod);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

        nomeMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openn1();
            }
        });

        nomeMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openn1();
            }
        });

        cognomeMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openn2();
            }
        });

        mailMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openn3();
            }
        });
        pwMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openn4();
            }
        });



    }

    public void openDashboard(){
        Intent intent=new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    private void openn1() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.nomemod, null);
        dialogBuilder.setView(dialogView);
        final EditText nome = dialogView.findViewById(R.id.nome2);
        Button salva = dialogView.findViewById(R.id.salva);
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ottieni lo stato delle caselle di controllo e gestisci di conseguenza
                // Esegui azioni in base alle selezioni dell'utente
                // ...
                // Chiudi il popup
                alertDialog.dismiss();
            }
        });
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private void openn2() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.cognomemod, null);
        dialogBuilder.setView(dialogView);
        final EditText nome = dialogView.findViewById(R.id.cognome2);
        Button salva = dialogView.findViewById(R.id.salva);
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ottieni lo stato delle caselle di controllo e gestisci di conseguenza
                // Esegui azioni in base alle selezioni dell'utente
                // ...
                // Chiudi il popup
                alertDialog.dismiss();
            }
        });
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
    private void openn3() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.mailmod, null);
        dialogBuilder.setView(dialogView);
        final EditText nome = dialogView.findViewById(R.id.mail2);
        Button salva = dialogView.findViewById(R.id.salva);
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ottieni lo stato delle caselle di controllo e gestisci di conseguenza
                // Esegui azioni in base alle selezioni dell'utente
                // ...
                // Chiudi il popup
                alertDialog.dismiss();
            }
        });
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
    private void openn4() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.pw, null);
        dialogBuilder.setView(dialogView);
        final EditText nome = dialogView.findViewById(R.id.pw2);
        Button salva = dialogView.findViewById(R.id.salva);
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ottieni lo stato delle caselle di controllo e gestisci di conseguenza
                // Esegui azioni in base alle selezioni dell'utente
                // ...
                // Chiudi il popup
                alertDialog.dismiss();
            }
        });
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
}
