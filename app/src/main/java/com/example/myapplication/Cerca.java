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

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Cerca extends AppCompatActivity {
    private EditText keywordEditText;
    private Button searchButton;
    private ListView resultsListView;
    private AlloggioAdapter adapter; // Supponiamo che tu abbia un adattatore personalizzato per gli alloggi
    private ArrayList<Alloggio> allAccommodations; // La lista completa degli alloggi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cerca);

        // Inizializza i componenti dell'interfaccia utente
        keywordEditText = findViewById(R.id.keywordEditText);
        searchButton = findViewById(R.id.searchButton);
        resultsListView = findViewById(R.id.accommodationListView);

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
        resultsListView.setAdapter(adapter);

        // Gestisci il clic del pulsante di ricerca
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });
    }

    // Metodo per eseguire la ricerca
    private void performSearch() {
        String keyword = keywordEditText.getText().toString();
        String[] inputArray = keyword.trim().split(" ");
        adapter = new AlloggioAdapter(this, filterAccommodationsByKeywords(allAccommodations, inputArray));

        resultsListView.setAdapter(adapter);
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
        for(int j=0; j<allAccommodations.size(); j++){
            boolean matchesKeywords = true;
            for(int i=0; i<keywords.length; i++){
                Log.d("","valore: "+keywords[i]);
                if (!accommodationContainsKeyword(allAccommodations.get(j), keywords[i])) {
                    matchesKeywords = false;
                    i=keywords.length;
                }
            }

            if (matchesKeywords) {
                filteredAccommodations.add(allAccommodations.get(j));
            }
        }



        return filteredAccommodations;
    }

    private boolean accommodationContainsKeyword(Alloggio accommodation, String keyword) {
        return accommodation.getNome().toLowerCase().contains(keyword.toLowerCase())
                || accommodation.getIndirizzo().toLowerCase().contains(keyword.toLowerCase());
    }
}
