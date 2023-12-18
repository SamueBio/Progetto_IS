package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InviaRichiesta extends AppCompatActivity {

    private EditText editTextNomeCognome, editTextEmail, editTextOggetto, editTextTestoMessaggio;
    private Button buttonInviaRichiesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.inviarichiesta);

        // Inizializza gli elementi UI
        editTextNomeCognome = findViewById(R.id.editTextNomeCognome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextOggetto = findViewById(R.id.editTextOggetto);
        editTextTestoMessaggio = findViewById(R.id.editTextTestoMessaggio);
        buttonInviaRichiesta = findViewById(R.id.buttonInviaRichiesta);

        // Imposta un listener per il pulsante di invio
        buttonInviaRichiesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inviaRichiesta();
            }
        });
    }

    private void inviaRichiesta() {
        // Recupera i dati dai campi di testo
        String nomeCognome = editTextNomeCognome.getText().toString();
        String email = editTextEmail.getText().toString();
        String oggetto = editTextOggetto.getText().toString();
        String testoMessaggio = editTextTestoMessaggio.getText().toString();

        // Puoi qui gestire l'invio dei dati (ad esempio, inviare una mail)
        // In questo esempio, visualizziamo solo i dati nel Toast
        String messaggio = "Nome e Cognome: " + nomeCognome +
                "\nEmail: " + email +
                "\nOggetto: " + oggetto +
                "\nTesto Messaggio: " + testoMessaggio;

        Toast.makeText(this, messaggio, Toast.LENGTH_LONG).show();
    }
}
