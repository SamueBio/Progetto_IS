package com.example.myapplication;
/*
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class Cerca extends AppCompatActivity {
    private ListView accommodationListView;
    private AlloggioAdapter adapter;
    private ArrayList<Alloggio> accommodationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cerca);

        accommodationListView = findViewById(R.id.accommodationListView);

        // Inizializza la lista degli alloggi con dati di esempio
        accommodationList = new ArrayList<>();
        accommodationList.add(new Alloggio("Nome Alloggio 1", "Posizione 1"));
        accommodationList.add(new Alloggio("Nome Alloggio 2", "Posizione 2"));
        accommodationList.add(new Alloggio("Nome Alloggio 3", "Posizione 3"));
        View keywords = find(R.id.keywordEditText);

        ArrayList<Alloggio> supp= filterAccommodationsByKeywords(accommodationList, keywords );

        // Crea un adattatore personalizzato e assegnalo alla ListView
        adapter = new AlloggioAdapter(this, accommodationList);
        accommodationListView.setAdapter(adapter);
    }

    // Metodo per filtrare gli alloggi in base a più parole chiave
    private ArrayList<Alloggio> filterAccommodationsByKeywords(ArrayList<Alloggio> allAccommodations, String[] keywords) {
        ArrayList<Alloggio> filteredAccommodations = new ArrayList<>();

        for (Alloggio accommodation : allAccommodations) {
            boolean matchesKeywords = true;
            for (String keyword : keywords) {
                if (!accommodationContainsKeyword(accommodation, keyword)) {
                    matchesKeywords = false;
                    break;
                }
            }

            if (matchesKeywords) {
                filteredAccommodations.add(accommodation);
            }
        }

        return filteredAccommodations;
    }

    // Metodo per verificare se un alloggio contiene una parola chiave
    private boolean accommodationContainsKeyword(Alloggio accommodation, String keyword) {
        return accommodation.getNome().toLowerCase().contains(keyword.toLowerCase())
                || accommodation.getIndirizzo().toLowerCase().contains(keyword.toLowerCase())
    }

}
*/

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class Cerca extends AppCompatActivity {
    private EditText nomeSearch;
    private EditText indirizzo;

    private TextView backk;

    private Button searchButton;
    private ImageButton home;

    private ImageView cuore;

    private ImageButton back;
    private ImageButton filtri;

    private Button bpref;
    private ListView resultsListView;
    private AlloggioAdapter adapter; // Supponiamo che tu abbia un adattatore personalizzato per gli alloggi
    private ArrayList<Alloggio> allAccommodations; // La lista completa degli alloggi
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.cerca);

        // Inizializza i componenti dell'interfaccia utente
        nomeSearch = findViewById(R.id.nome);
        searchButton = findViewById(R.id.searchButton);
        filtri= findViewById(R.id.filtri);
        indirizzo = findViewById(R.id.indirizzo);
       // resultsListView = findViewById(R.id.accommodationListView);
        home = (ImageButton) findViewById(R.id.house);

        // Inizializza la lista completa degli alloggi con dati di esempio
        allAccommodations = new ArrayList<>();
        allAccommodations.add(new Alloggio("Nome Alloggio 1", "Posizione 1"));
        allAccommodations.add(new Alloggio("Nome Alloggio 2", "Posizione 2"));
        allAccommodations.add(new Alloggio("Nome Alloggio 3", "Posizione 3"));
        allAccommodations.add(new Alloggio("Nome Alloggio 4", "Posizione 4"));
        allAccommodations.add(new Alloggio("Nome Alloggio 5", "Posizione 5"));
        allAccommodations.add(new Alloggio("Nome Alloggio 6", "Posizione 6"));
        allAccommodations.add(new Alloggio("Nome Alloggio 7", "Posizione 7"));
        allAccommodations.add(new Alloggio("Nome Alloggio 8", "Posizione 8"));
        allAccommodations.add(new Alloggio("Nome Alloggio 9", "Posizione 9"));

        // Inizializza l'adattatore con la lista completa degli alloggi
        adapter = new AlloggioAdapter(this, allAccommodations);

        // Imposta l'adattatore per la ListView
        //resultsListView.setAdapter(adapter);

        // Gestisci il clic del pulsante di ricerca
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

        filtri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });
    }

    private void showPopup() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.servizi, null);
        dialogBuilder.setView(dialogView);

        final CheckBox piscina = dialogView.findViewById(R.id.piscina);
        final CheckBox animaliAmm = dialogView.findViewById(R.id.animaliAmm);
        final CheckBox ariaCond = dialogView.findViewById(R.id.ariaCond);
        final CheckBox ristorante = dialogView.findViewById(R.id.ristorante);
        final CheckBox parcheggio = dialogView.findViewById(R.id.parcheggio);
        final CheckBox accessoDisabili = dialogView.findViewById(R.id.accessoDisabili);

        Button btnSelectServices = dialogView.findViewById(R.id.btnSelectServices);
        btnSelectServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ottieni lo stato delle caselle di controllo e gestisci di conseguenza
                boolean isPiscina = piscina.isChecked();
                boolean isanimaliAmm = animaliAmm.isChecked();
                boolean isariaCond = ariaCond.isChecked();
                boolean isristorante = ristorante.isChecked();
                boolean isparcheggio = parcheggio.isChecked();
                boolean isaccessoDisabili = accessoDisabili.isChecked();
                // Esegui azioni in base alle selezioni dell'utente
                // ...

                // Chiudi il popup
                alertDialog.dismiss();
            }
        });

        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
    // Metodo per eseguire la ricerca
    @SuppressLint("MissingInflatedId")
    private void performSearch() {

        String keyword = nomeSearch.getText().toString();
        String keyword2 = indirizzo.getText().toString();
        String[] inputArray = (keyword+" "+keyword2).trim().split(" ");
        adapter = new AlloggioAdapter(this, filterAccommodationsByKeywords(allAccommodations, inputArray));
        setContentView(R.layout.cerca2);

        back=findViewById(R.id.back);
        backk=findViewById(R.id.back2);
        resultsListView = findViewById(R.id.accommodationListView);
        resultsListView.setAdapter(adapter);

        cuore = findViewById(R.id.pref);
       // bpref=findViewById(R.id.buttonPref);
       /* bpref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cuore.setImageResource(R.drawable.cuore_si);
            }
        });*/
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                backSearch();
            }
        });
        backk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                backSearch();
            }
        });


    }

    public void onHeartIconClick(View view) {
        ImageView heartIcon = (ImageView) view;
        Alloggio accommodation = (Alloggio) heartIcon.getTag();

        if (accommodation.isFavorited()) {
            heartIcon.setImageResource(R.drawable.cuore);
           // removeFromFavorites(accommodation);
        } else {
            heartIcon.setImageResource(R.drawable.cuore_si);
            //addToFavorites(accommodation);
        }
        accommodation.setFavorited(!accommodation.isFavorited());
    }
    private void openDashboard(){
        Intent intent=new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    private void backSearch(){
        Intent intent=new Intent(this, Cerca.class);
        startActivity(intent);
    }

    // Metodo per filtrare gli alloggi in base alla parola chiave
    private ArrayList<Alloggio> filterAccommodationsByKeyword(String keyword) {
        ArrayList<Alloggio> filteredAccommodations = new ArrayList<>();

        for (Alloggio accommodation : allAccommodations) {
            if (accommodation.getNome().toLowerCase().contains(keyword) ||
                    accommodation.getIndirizzo().toLowerCase().contains(keyword)){
                filteredAccommodations.add(accommodation);
            }
        }

        return filteredAccommodations;
    }

    private ArrayList<Alloggio> filterAccommodationsByKeywords(ArrayList<Alloggio> allAccommodations, String[] keywords) {
        ArrayList<Alloggio> filteredAccommodations = new ArrayList<>();
        //Log.d("","valore00: "+keywords[0]);
        //Log.d("","valore01: "+keywords[1]);
        String[] arrayStringhe = new String[keywords.length];

        for (int i = 0; i < keywords.length; i++) {
           arrayStringhe[i] = String.valueOf(keywords[i]);
        }

        for(int j=0; j<allAccommodations.size(); j++){
            for(int i=0; i<keywords.length; i++){
                if (accommodationContainsKeyword(allAccommodations.get(j), keywords[i])) {
                    filteredAccommodations.add(allAccommodations.get(j));
                    i = keywords.length;
                }
            }
        }
        return filteredAccommodations;
    }

    private boolean accommodationContainsKeyword(Alloggio accommodation, String keyword) {
        return accommodation.getNome().toLowerCase().contains(keyword.toLowerCase())
                || accommodation.getIndirizzo().toLowerCase().contains(keyword.toLowerCase());
    }
}
