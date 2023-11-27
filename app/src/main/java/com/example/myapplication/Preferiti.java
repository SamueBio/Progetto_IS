package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Preferiti extends AppCompatActivity {
    private ImageButton home;
    private ListView resultsListView;
    private AlloggioAdapter adapter; // Supponiamo che tu abbia un adattatore personalizzato per gli alloggi
    private ArrayList<Alloggio> allAccommodations; // La lista completa degli alloggi
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.preferiti);

        home = (ImageButton) findViewById(R.id.house);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

        allAccommodations = new ArrayList<>();
        allAccommodations.add(new Alloggio("Alloggio 1 pref", "Posizione 1"));
        allAccommodations.add(new Alloggio("Alloggio 2 pref", "Posizione 2"));
        adapter = new AlloggioAdapter(this, allAccommodations);

        resultsListView = findViewById(R.id.accommodationListView);
        resultsListView.setAdapter(adapter);
    }
    public void onHeartIconClick(View view) {
        ImageView heartIcon = (ImageView) view;
        Alloggio accommodation = (Alloggio) heartIcon.getTag();
        heartIcon.setImageResource(R.drawable.cuore_si);
    }
    public void openDashboard(){
        Intent intent=new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}
