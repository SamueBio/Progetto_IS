package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Accommodation;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class InviaRichiesta extends AppCompatActivity {

    private EditText editTextNomeCognome, editTextEmail, editTextOggetto, editTextTestoMessaggio;
    private TextView aAlloggio;
    private Button buttonInviaRichiesta;
    private Accommodation acc;
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

        Intent intent = getIntent();
        acc = (Accommodation) intent.getSerializableExtra("alloggio");

        // Inizializza gli elementi UI
        editTextNomeCognome = findViewById(R.id.editTextNomeCognome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextOggetto = findViewById(R.id.editTextOggetto);
        editTextTestoMessaggio = findViewById(R.id.editTextTestoMessaggio);
        aAlloggio=findViewById(R.id.aAll);
        aAlloggio.setText(" A: "+acc.getEmail());
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


        final String username = "traveltogether.uni@gmail.com";
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


        //MAIL INVIATA ALL'ALLOGGIO
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("traveltogether.uni@gmail.com"));
            InternetAddress[] toAddresses = {
                    new InternetAddress(acc.getEmail())
                    //new InternetAddress("samuele.biondo.lavoro@gmail.com")

            };
            message.setRecipients(Message.RecipientType.TO,toAddresses);
            message.setSubject(oggetto);
            String htmlBody = "<b>NOMINATIVO MITTENTE:</b>"+nomeCognome+"<br><br><b>EMAIL MITTENTE:</b> "+email+
                    "<br><br><b>MESSAGGIO:</b> "+testoMessaggio+"<br><br><br><i>Mail inviata da APP TravelTogether</i>";

            // Crea la parte HTML del messaggio
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(htmlBody, "text/html; charset=utf-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(htmlPart);
            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        //MAIL INVIATA ALL'UTENTE
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("traveltogether.uni@gmail.com"));
            InternetAddress[] toAddresses = {
                    new InternetAddress(email),
            };
            message.setRecipients(Message.RecipientType.TO,toAddresses);
            message.setSubject(oggetto);

            String htmlBody = "<b>UTENTE:</b> "+nomeCognome+ "<br><br><b>EMAIL:</b> "+email+"<br><br><b>MESSAGGIO:</b> "+testoMessaggio+
                    "<br><br><b>ALLOGGIO:</b> "+acc.getName()+"<br>"+acc.getAddress()+", "+acc.getHouseNumber()+"<br><br><br><i>Ricevuta della mail inviata da APP TravelTogether</i>";

            // Crea la parte HTML del messaggio
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(htmlBody, "text/html; charset=utf-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(htmlPart);
            message.setContent(multipart);


            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        Toast.makeText(this, "Mail INVIATA", Toast.LENGTH_SHORT).show();
        finish();
       // Intent intent=new Intent(this, Dashboard.class);
        //startActivity(intent);

    }
}
