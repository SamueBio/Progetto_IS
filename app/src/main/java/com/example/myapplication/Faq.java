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
    }


    //VISUALIZZA POPUP SPIEGAZIONE DOMANDA
    private void open1() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.faqdesc, null);
        dialogBuilder.setView(dialogView);
        final TextView domanda = dialogView.findViewById(R.id.domanda);
        domanda.setText("Visualizzazione profilo");
        final TextView spieg = dialogView.findViewById(R.id.spieg);
        spieg.setText("Dalla dashboard, cliccare in basso a destra sull'icona del profilo per aprire i dettagli dell'utente loggato");
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
