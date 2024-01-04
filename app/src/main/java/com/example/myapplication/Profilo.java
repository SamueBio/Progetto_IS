package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.crypto.CryptoUtils;

public class Profilo extends AppCompatActivity {

    private String username;
    private String password;
    private String nomee;
    private String cognomee;
    private String maill;

    private AlertDialog alertDialog;

    private ImageButton home;
    private ImageButton nomeMod;
    private ImageButton cognomeMod;
    private ImageButton mailMod;
    private Button pwMod;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.profilo);
        //Intent intent = getIntent();

        // Recupero della variabile dalla chiave specificata
        username =  GlobalData.getInstance().getUsername();
        nomee = GlobalData.getInstance().getNome();
        cognomee = GlobalData.getInstance().getCognome();
        maill = GlobalData.getInstance().getMail();
        //System.out.println("USERNAME: "+username+"\nPW: "+password+nome+cognome+mail);
        EditText nome = findViewById(R.id.nome2);
        nome.setText(nomee);
        EditText cognome = findViewById(R.id.cognome2);
        cognome.setText(cognomee);
        EditText mail = findViewById(R.id.email2);
        mail.setText(maill);

        home = (ImageButton) findViewById(R.id.house);
        nomeMod = (ImageButton) findViewById(R.id.nomeMod);
        cognomeMod = (ImageButton) findViewById(R.id.cognomeMod);
        mailMod = (ImageButton) findViewById(R.id.mailMod);
        pwMod = findViewById(R.id.pwMod);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

        nomeMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openn1();
            }
        });

        nomeMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openn1();
            }
        });

        cognomeMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openn2();
            }
        });

        mailMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openn3();
            }
        });
        pwMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openn4();
            }
        });



    }

    public void openDashboard(){
        Intent intent=new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    private void openn1() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.nomemod, null);
        dialogBuilder.setView(dialogView);
        final EditText nome = dialogView.findViewById(R.id.nome2);
        Button salva = dialogView.findViewById(R.id.salva);
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                 *
                 *
                 * AGGIORNA QUI IL NUOVO NOME PER L'UTENTE LOGGATO
                 * variabile dove è salvato il nome --> "nome"
                 *
                 *
                 */
                alertDialog.dismiss();
            }
        });
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private void openn2() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.cognomemod, null);
        dialogBuilder.setView(dialogView);
        final EditText cognome = dialogView.findViewById(R.id.cognome2);
        Button salva = dialogView.findViewById(R.id.salva);
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                 *
                 *
                 * AGGIORNA QUI IL NUOVO COGNOME PER L'UTENTE LOGGATO
                 * variabile dove è salvato il cognome --> "cognome"
                 *
                 *
                 */
                alertDialog.dismiss();
            }
        });
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
    private void openn3() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.mailmod, null);
        dialogBuilder.setView(dialogView);
        final EditText mail = dialogView.findViewById(R.id.mail2);
        Button salva = dialogView.findViewById(R.id.salva);
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                 *
                 *
                 * AGGIORNA QUI LA NUOVA MAIL PER L'UTENTE LOGGATO
                 * variabile dove è salvato la nuova mail --> "mail"
                 *
                 *
                 */
                alertDialog.dismiss();
            }
        });
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
    private void openn4() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.pw, null);
        dialogBuilder.setView(dialogView);
        final EditText passatt = dialogView.findViewById(R.id.passatt);
        final EditText nuovapass = dialogView.findViewById(R.id.nuovapass);
        final EditText checknuovapass = dialogView.findViewById(R.id.checknuovapass);
        Button salva = dialogView.findViewById(R.id.salva);
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(verifyPass(passatt.getText().toString())==false)
                if(true)
                    Toast.makeText(Profilo.this, "Password attuale sbagliata", Toast.LENGTH_SHORT).show();
                else{
                    if((isPasswordSecure(nuovapass.getText().toString())&&isPasswordSecure(checknuovapass.getText().toString()))){
                        if(nuovapass.getText().toString().equals(checknuovapass.getText().toString())) {
                            String password = CryptoUtils.hashPassword(nuovapass.getText().toString());

                            /*
                             *
                             *
                             * AGGIORNA QUI LA NUOVA PASSWORD PER L'UTENTE LOGGATO
                             * variabile da salvare già con l'HASH --> "password"
                             *
                             *
                             */
                            alertDialog.dismiss();

                        }else{
                            Toast.makeText(Profilo.this, "PASSWORD NON UGUALI", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Profilo.this, "REQUISITI NON RISPETTATI", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }


    private static boolean isPasswordSecure(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&+-])[A-Za-z\\d@$!%*?&+-]{8,}$");
    }


}
