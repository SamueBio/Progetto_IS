package com.example.myapplication;

import android.annotation.SuppressLint;
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

        // Crea un adattatore personalizzato e assegnalo alla ListView
        adapter = new AlloggioAdapter(this, accommodationList);
        accommodationListView.setAdapter(adapter);
    }
}
