package com.example.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.net.Uri;
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
    private TextView faq8;
    private TextView faq9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
        faq8 = findViewById(R.id.faq8);
        faq8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open8();
            }
        });

        faq9 = findViewById(R.id.faq9);
        faq9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open9();
            }
        });


    }

    //FAQ1
    private void open1(){
        String domanda="Visualizzazione profilo";
        String spiegazione="Dalla dashboard, cliccare in basso a destra sull'icona del profilo per aprire i dettagli dell'utente loggato";
        showFAQ(domanda, spiegazione);
    }

    private void open2(){
        String domanda = "Effettuare una ricerca";
        String spiegazione = "Dalla dashboard, cliccare in basso sull'icona centrale della lente d'ingrandimento per " +
                "aprire la sezione dedicata alla ricerca degli alloggi.\nDopo essere entrati nella pagina della ricerca " +
                "sarà possibile effettuarne una selezionando la TIPOLOGIA oppure inserendo da tastiera uno o più dei seguenti campi:\n - nome\n - città\n - provincia";
        showFAQ(domanda, spiegazione);
    }

    private void open3(){
        String domanda = "Ricerca tramite servizi";
        String spiegazione = "Nella sezione dedicata alla ricerca, cliccare sull'opzione 'FILTRI' e successivamente selezionare i servizi desiderati";
        showFAQ(domanda, spiegazione);
    }

    private void open4(){
        String domanda = "Aggiunta di un alloggio ai preferiti";
        String spiegazione = "Dopo aver effettuato una ricerca, accanto al nome dell'alloggio è possibile cliccare sull'icona del cuore per aggiungere quell'alloggio" +
                "ai preferiti.\nQuesta azione può essere effettuata anche all'interno della pagina dell'alloggio stesso, sempre cliccando sull'icona del cuore in alto a destra.";
        showFAQ(domanda, spiegazione);
    }

    private void open5(){
        String domanda = "Visualizzazione alloggi preferiti";
        String spiegazione = "Nella schermata home, attraverso l'icona a forma di cuore in basso a sinistra si accede alla pagina dedicata agli alloggi preferiti " +
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
        String spiegazione = "All'interno della pagina dell'alloggio di interesse sarà possibile contattare il proprietario in due modi:" +
                             "\n 1. Attraverso il pulsante 'INVIA RICHIESTA' per comunicare tramite email\n 2. Cliccando sul numero di telefono per effettuare una chiamata";
        showFAQ(domanda, spiegazione);
    }

    private void open8(){
        String domanda = "Visualizzare recensioni";
        String spiegazione = "All'interno della pagina dell'alloggio di interesse sarà possibile visualizzare " +
                "le recensioni, selezionando l'icona del fumetto con stella";
        showFAQ(domanda, spiegazione);
    }

    private void open9(){
        String domanda = "Effettuare una recensione";
        String spiegazione = "Dopo aver aperto la pagina delle recensioni di una determinata struttura, sarà possibile " +
                "crearne una cliccando sul pulsante 'NUOVA RECENSIONE' e successivamente selezionare quante stelle e inserire il testo della recensione" ;
        showFAQ(domanda, spiegazione);
    }







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

    public void openPrivacyPolicy(View v) {
        String url = "https://www.iubenda.com/privacy-policy/47447245.pdf";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }
}
