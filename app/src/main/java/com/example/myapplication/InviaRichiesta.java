package com.example.myapplication;

import android.os.Bundle;
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

                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.example.com"); // Sostituisci con il tuo server SMTP
                props.put("mail.smtp.port", "587"); // Porta del server SMTP (potrebbe essere diversa)
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");

                // Crea l'oggetto Session
                Session session = Session.getInstance(props, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("tua-email@example.com", "tua-password");
                    }
                });

                try {
                    // Crea l'oggetto Message
                    Message message = new MimeMessage(session);

                    // Imposta il mittente
                    message.setFrom(new InternetAddress(editTextNomeCognome.getText().toString()));

                    // Aggiungi il destinatario
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("samuele.biondo.lavoro@gmail.com"));

                    // Imposta l'oggetto del messaggio
                    message.setSubject(editTextOggetto.getText().toString());

                    // Aggiungi il corpo del messaggio
                    String corpoMessaggio = editTextTestoMessaggio.getText().toString();
                    message.setText(corpoMessaggio);

                    // Invia il messaggio
                    Transport.send(message);

                    System.out.println("Mail inviata con successo.");
                    //Toast.makeText(this, "Mail inviata", Toast.LENGTH_LONG).show();

                } catch (MessagingException e) {
                    e.printStackTrace();
                    System.err.println("Errore nell'invio della mail: " + e.getMessage());
                }
                //inviaRichiesta();
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
