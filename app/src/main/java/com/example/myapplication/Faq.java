package com.example.myapplication;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Faq extends AppCompatActivity {
    private AlertDialog alertDialog;
    private ImageButton back;

    //DICHIARAZIONE TEXTVIEW DELLE VARIE FAQ
    private TextView faq1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.faq);

        faq1=findViewById(R.id.faq1);
        faq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open1();
            }
        });

        /*
            QUI SETTARE LE VARIE FAQ COME A RIGA 29 E 30
         */
    }

    //FAQ1
    private void open1(){
        String domanda="Visualizzazione profilo";
        String spiegazione="Dalla dashboard, cliccare in basso a destra sull'icona del profilo per aprire i dettagli dell'utente loggato";
        showFAQ(domanda, spiegazione);
    }


    /*
        qui creare altre FAQ con open2, open3, e avanti...

        delle possibili FAQ sono:
            dove andare per ricerca
            come effettuare una ricerca
            ricerca per servizi come funziona
            visualizzazione preferiti
            ecc
            ecc
            ecc

     */






    //VISUALIZZA POPUP SPIEGAZIONE DOMANDA
    private void showFAQ(String dom, String spi) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.faqdesc, null);
        dialogBuilder.setView(dialogView);
        final TextView domanda = dialogView.findViewById(R.id.domanda);
        domanda.setText(dom);
        final TextView spieg = dialogView.findViewById(R.id.spieg);
        spieg.setText(spi);
        final ImageButton back = dialogView.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    public void onBackImageClick(View view) {
        finish();
    }
}
