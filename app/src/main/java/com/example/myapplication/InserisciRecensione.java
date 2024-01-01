package com.example.myapplication;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Accommodation;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class InserisciRecensione extends AppCompatActivity {

    private EditText recensione;
    private EditText utente;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;
    private Button recensisci;
    private Accommodation acc;
    private int stars=0;
    private String user=""+GlobalData.getInstance().getNome()+" "+GlobalData.getInstance().getCognome();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.inviarecensione);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Intent intent = getIntent();
        acc = (Accommodation) intent.getSerializableExtra("alloggio");

        recensione = findViewById(R.id.recensione2);
        utente=findViewById(R.id.utente2);
        utente.setText(user);
        recensisci = findViewById(R.id.nuovaRec);
        recensisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuovaRec();
            }
        });

        star1=findViewById(R.id.star1);
        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star_si);
                star2.setImageResource(R.drawable.star);
                star3.setImageResource(R.drawable.star);
                star4.setImageResource(R.drawable.star);
                star5.setImageResource(R.drawable.star);
                stars=1;
            }
        });

        star2=findViewById(R.id.star2);
        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star_si);
                star2.setImageResource(R.drawable.star_si);
                star3.setImageResource(R.drawable.star);
                star4.setImageResource(R.drawable.star);
                star5.setImageResource(R.drawable.star);
                stars=2;
            }
        });

        star3=findViewById(R.id.star3);
        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star_si);
                star2.setImageResource(R.drawable.star_si);
                star3.setImageResource(R.drawable.star_si);
                star4.setImageResource(R.drawable.star);
                star5.setImageResource(R.drawable.star);
                stars=3;
            }
        });


        star4=findViewById(R.id.star4);
        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star_si);
                star2.setImageResource(R.drawable.star_si);
                star3.setImageResource(R.drawable.star_si);
                star4.setImageResource(R.drawable.star_si);
                star5.setImageResource(R.drawable.star);
                stars=4;
            }
        });


        star5=findViewById(R.id.star5);
        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageResource(R.drawable.star_si);
                star2.setImageResource(R.drawable.star_si);
                star3.setImageResource(R.drawable.star_si);
                star4.setImageResource(R.drawable.star_si);
                star5.setImageResource(R.drawable.star_si);
                stars=5;
            }
        });

    }

    private void nuovaRec() {
        String rec = recensione.getText().toString();

        /*
        *  IMPLEMENTARE QUI IL SALVATAGGIO DELLA RECENSIONE SUL DB
        * variabili necessarie:
        * --> rec: string  stringa della recensione
        * --> user: string   nome e cognome utente loggato
        * --> star: int   numero stelle selezionate dall'utente
        *
        *
         */

        Toast.makeText(this,"RECENSIONE EFFETTUATA",(int)3).show();
        finish();
    }

    public void onBackImageClick(View view) {
        finish();
    }


}
