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
    private TextView faq2;
    private TextView faq3;
    private TextView faq4;
    private TextView faq5;
    private TextView faq6;
    private TextView faq7;

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

        faq2 = findViewById(R.id.faq2);
        faq2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2();
            }
        });

        faq3 = findViewById(R.id.faq3);
        faq3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open3();
            }
        });

        faq4 = findViewById(R.id.faq4);
        faq4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open4();
            }
        });

        faq5 = findViewById(R.id.faq5);
        faq5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open5();
            }
        });

        faq6 = findViewById(R.id.faq6);
        faq6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open6();
            }
        });

        faq7 = findViewById(R.id.faq7);
        faq7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open7();

                
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

    private void open2(){
        String domanda = "Effettuare una ricerca";
        String spiegazione = "Dalla dashboard, cliccare in basso sull'icona centrale della lente d'ingrandimento per aprire la sezione dedicata alla ricerca degli alloggi";
        showFAQ(domanda, spiegazione);
    }

    private void open3(){
        String domanda = "Ricerca tramite servizi";
        String spiegazione = "Nella sezione dedicata alla ricerca, cliccare sull'opzione 'FILTRI', dopodiché selezionare i servizi dedicati per la ricerca";
        showFAQ(domanda, spiegazione);
    }

    private void open4(){
        String domanda = "Aggiunta di un alloggio ai preferiti";
        String spiegazione = "Dopo aver effettuato una ricerca, accanto al nome dell'alloggio è possibile cliccare sull'icona del cuore per aggiungere quell'alloggio" +
                "ai preferiti. Questa azione può essere effettuata anche all'interno della pagina dell'alloggio stesso, con l'icona del cuore in alto a destra.";
        showFAQ(domanda, spiegazione);
    }

    private void open5(){
        String domanda = "Visualizzazione alloggi preferiti";
        String spiegazione = "Nella schermata home, attraverso l'icona a forma di cuore in basso a sinistra si può accedere alla pagina dedicata agli alloggi preferiti " +
                "aggiungti durante la ricerca";
        showFAQ(domanda, spiegazione);
    }


    private void open6(){
        String domanda = "Modifica profilo";
        String spiegazione = "All'interno della pagina del profilo selezionare l'icona della matita corrispondente al  " +
                "campo che si intende modificare";
        showFAQ(domanda, spiegazione);
    }

    private void open7(){
        String domanda = "Contatta proprietario alloggio";
        String spiegazione = "All'interno della pagina dell'alloggio di interesse sarà possibile contattare il proprietario " +
                "selezionando l'email";
        showFAQ(domanda, spiegazione);
    }
    /*
        qui creare altre FAQ con open2, open3, e avanti...

        delle possibili FAQ sono:
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
