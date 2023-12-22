package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class InviaRichiesta extends AppCompatActivity {

    private EditText editTextNomeCognome, editTextEmail, editTextOggetto, editTextTestoMessaggio;
    private Button buttonInviaRichiesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.inviarichiesta);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


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

       /* String[] destinatario = {"destinatario@example.com"};

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:")); // Solo app email
        intent.putExtra(Intent.EXTRA_EMAIL, "samuele.biondo.lavoro@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, oggetto);
        intent.putExtra(Intent.EXTRA_TEXT, testoMessaggio);
        startActivity(Intent.createChooser(intent, "Scegli il client email:"));

        */final String username = "traveltogether.uni@gmail.com";
        final String password = "2E496FE5317A48E25B731E133332F24666F0";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.elasticemail.com");
        props.put("mail.smtp.port", "2525");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("traveltogether.uni@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject(oggetto);
            message.setText(testoMessaggio);

            Transport.send(message);

            System.out.println("Email inviata con successo!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        Toast.makeText(this, "Mail INVIATA", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, Dashboard.class);
        startActivity(intent);

    }
}
