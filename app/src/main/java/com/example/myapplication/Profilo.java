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
import com.example.myapplication.model.User;
import com.example.myapplication.retrofit.RetrofitService;
import com.example.myapplication.retrofit.UserApi;
import com.google.gson.JsonObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profilo extends AppCompatActivity {

    private String username;
    private String password;
    private String nomee;
    private String cognomee;
    private String maill;

    private EditText nome_;
    private EditText cognome_;
    private EditText mail_;
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

        // Recupero della variabile dalla chiave specificata
        username =  GlobalData.getInstance().getUsername();
        nomee = GlobalData.getInstance().getNome();
        cognomee = GlobalData.getInstance().getCognome();
        maill = GlobalData.getInstance().getMail();

        nome_ = findViewById(R.id.nome2);
        nome_.setText(nomee);
        cognome_ = findViewById(R.id.cognome2);
        cognome_.setText(cognomee);
        mail_ = findViewById(R.id.email2);
        mail_.setText(maill);

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
                String nameToUpdate = String.valueOf(nome.getText());
                User userToUpdate = new User(GlobalData.getInstance().getUsername(),
                                            nameToUpdate,
                                            GlobalData.getInstance().getCognome(),
                                            GlobalData.getInstance().getMail(),"");
                updateValues(userToUpdate);
                nome_.setText(nome.getText());
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

                String lastNameToUpdate = String.valueOf(cognome.getText());
                User userToUpdate = new User(GlobalData.getInstance().getUsername(),
                        GlobalData.getInstance().getNome(),
                        lastNameToUpdate,
                        GlobalData.getInstance().getMail(),"");
                updateValues(userToUpdate);
                cognome_.setText(cognome.getText());
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

                String mailToUpdate = String.valueOf(mail.getText());
                User userToUpdate = new User(GlobalData.getInstance().getUsername(),
                        GlobalData.getInstance().getNome(),
                        GlobalData.getInstance().getCognome(),
                        mailToUpdate,"");
                updateValues(userToUpdate);
                mail_.setText(mail.getText());
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
                RetrofitService retrofitService = new RetrofitService();
                UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);
                String hashedPassword = CryptoUtils.hashPassword(String.valueOf(passatt.getText()));
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("username", GlobalData.getInstance().getUsername());
                jsonObject.addProperty("password", hashedPassword);

                Call<ResponseBody> call = userApi.login(jsonObject);

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if((isPasswordSecure(nuovapass.getText().toString())&&isPasswordSecure(checknuovapass.getText().toString()))){
                            if(nuovapass.getText().toString().equals(checknuovapass.getText().toString())) {
                                String password = CryptoUtils.hashPassword(nuovapass.getText().toString());

                                User userToUpdate = new User(GlobalData.getInstance().getUsername(),
                                        GlobalData.getInstance().getNome(),
                                        GlobalData.getInstance().getCognome(),
                                        GlobalData.getInstance().getMail(),
                                        password);
                                RetrofitService retrofitService2 = new RetrofitService();
                                UserApi userApi2 = retrofitService2.getRetrofit().create(UserApi.class);

                                Call<ResponseBody> call2 = userApi2.updatePassword(userToUpdate.generateJson());
                                call2.enqueue(new Callback<ResponseBody>() {
                                    @Override
                                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                        if(response.isSuccessful()){

                                            Toast.makeText(Profilo.this,"Update riuscito",Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            Toast.makeText(Profilo.this,"Update fallito",Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                                        Toast.makeText(Profilo.this,"Update fallito",Toast.LENGTH_SHORT).show();
                                    }
                                });
                                alertDialog.dismiss();

                            }else{
                                Toast.makeText(Profilo.this, "PASSWORD NON UGUALI", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Profilo.this, "REQUISITI NON RISPETTATI", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(Profilo.this, "Password attuale sbagliata", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }


    private static boolean isPasswordSecure(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&+-])[A-Za-z\\d@$!%*?&+-]{8,}$");
    }

    private void updateValues(User userToUpdate){
        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        Call<ResponseBody> call = userApi.updateValues(userToUpdate.generateJson());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    GlobalData.getInstance().setNome(userToUpdate.getFirstName());
                    GlobalData.getInstance().setCognome(userToUpdate.getLastName());
                    GlobalData.getInstance().setMail(userToUpdate.getEmail());
                    Toast.makeText(Profilo.this,"Update riuscito",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Profilo.this,"Update fallito",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Profilo.this,"Update fallito",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
