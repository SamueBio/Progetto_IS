package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.Accommodation;
import com.example.myapplication.model.Favourite;
import com.example.myapplication.model.Review;
import com.example.myapplication.retrofit.FavouritesApi;
import com.example.myapplication.retrofit.RetrofitService;
import com.example.myapplication.retrofit.ReviewApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecAll extends AppCompatActivity {
    private TextView indirizzo;
    private TextView nome;
    private TextView telefono;
    private TextView sito;
    private TextView email;
    private Button inviaRichiesta;
    private Button nuovaRec;
    private ImageView cuore;
    private TextView servizi;
    private TextView lingue;
    private TextView backk;
    private ImageButton back;
    private Accommodation acc, alloggioRic;
    private ListView resultsListView;
    private ReviewAdapter adapterRev;
    private ArrayList<Review> resultRev;
    private boolean pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.alloggio);

        cuore = findViewById(R.id.pref);

        nome= findViewById(R.id.nameTextView);
        indirizzo = findViewById(R.id.locationTextView);
        telefono=findViewById(R.id.telefono2);
        email=findViewById(R.id.email2);
        sito=findViewById(R.id.sito2);
        servizi=findViewById(R.id.servizi2);
        lingue=findViewById(R.id.lingue2);
        inviaRichiesta = findViewById(R.id.inviaRichiesta);

        inviaRichiesta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { inviaRic(v);
            }
        });

        Intent intent = getIntent();
        acc = (Accommodation) intent.getSerializableExtra("alloggio");
        alloggioRic = (Accommodation) intent.getSerializableExtra("alloggioRicerca");
        pref = intent.getBooleanExtra("pref", false);
        if(acc.isFavourite())
            cuore.setImageResource(R.drawable.cuore_si);
        nome.setText(acc.getName());
        indirizzo.setText(acc.getAddress()+", "+acc.getHouseNumber()+" "+acc.getCap()+" "+acc.getTown());
        telefono.setText(acc.getTelephone());
        if(acc.getEmail().isEmpty()) {
            email.setText("  /  ");
            inviaRichiesta.setVisibility(View.GONE);
        }
        else
            email.setText(acc.getEmail());

        if(acc.getWebsite().isEmpty())
            sito.setText("  /  ");
        else
            sito.setText(acc.getWebsite());

        if(acc.getServiziTrue().isEmpty())
            servizi.setText("  /  ");
        else
            servizi.setText(acc.getServiziTrue());

        lingue.setText(acc.getLingueTrue());

    }

    public void inviaRic(View view){
        Intent intent=new Intent(this, InviaRichiesta.class);
        intent.putExtra("alloggio", acc);
        startActivity(intent);
    }

    public void onBackImageClick(View view) {
        Intent intent;
        if(pref){
            intent = new Intent(SpecAll.this, Preferiti.class);
            startActivity(intent);
        }
        else{
            intent = new Intent(SpecAll.this, Cerca.class);
            //intent.putExtra("alloggioAgg", acc);
            intent.putExtra("alloggioRicerca", alloggioRic);
            intent.putExtra("cerca", true);
            startActivity(intent);

        }


    }


    public void onHeartIconClick(View view) {
        RetrofitService retrofitService = new RetrofitService();
        FavouritesApi favouritesApi = retrofitService.getRetrofit().create(FavouritesApi.class);
        Favourite favourite = new Favourite(GlobalData.getInstance().getUsername(), acc.getId());
        if (acc.isFavourite()) {
            Call<ResponseBody> call = favouritesApi.delete(favourite.generateJson());
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    cuore.setImageResource(R.drawable.cuore);
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {   }
            });
        } else {
            Call<ResponseBody> call = favouritesApi.save(favourite.generateJson());
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    cuore.setImageResource(R.drawable.cuore_si);
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {   }
            });
        }
        acc.setFavourite(!acc.isFavourite());
    }



    public void openReview(View view){
        setContentView(R.layout.recensioni);
        resultRev = new ArrayList<>();
        back=findViewById(R.id.back);
        backk=findViewById(R.id.back2);
        resultsListView = findViewById(R.id.reviewListView);
        nuovaRec=findViewById(R.id.nuovaRec);

        nuovaRec.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { nuovarec(v);
            }
        });

        RetrofitService retrofitService = new RetrofitService();
        ReviewApi reviewApi = retrofitService.getRetrofit().create(ReviewApi.class);

        Call<ResponseBody> call = reviewApi.getReviewsByAccommodation(acc.generateJson());

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String responseBody = response.body().string();
                        resultRev = (ArrayList<Review>) Review.parseString(responseBody);
                        adapterRev = new ReviewAdapter(SpecAll.this, resultRev);
                        resultsListView.setAdapter(adapterRev);
                    }
                    catch (IOException e){
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoSpec(acc);
            }
        });
        backk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoSpec(acc);
            }
        });
    }

    public void nuovarec(View view){
        Intent intent=new Intent(this, InserisciRecensione.class);
        intent.putExtra("alloggio", acc);
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 123) {
            Accommodation alloggio = (Accommodation) data.getSerializableExtra("alloggio");
            setContentView(R.layout.recensioni);
            resultRev = new ArrayList<>();
            back=findViewById(R.id.back);
            backk=findViewById(R.id.back2);
            resultsListView = findViewById(R.id.reviewListView);
            nuovaRec=findViewById(R.id.nuovaRec);

            nuovaRec.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) { nuovarec(v);
                }
            });

            RetrofitService retrofitService = new RetrofitService();
            ReviewApi reviewApi = retrofitService.getRetrofit().create(ReviewApi.class);

            Call<ResponseBody> call = reviewApi.getReviewsByAccommodation(acc.generateJson());

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        try {
                            String responseBody = response.body().string();
                            resultRev = (ArrayList<Review>) Review.parseString(responseBody);
                            adapterRev = new ReviewAdapter(SpecAll.this, resultRev);
                            resultsListView.setAdapter(adapterRev);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
            back.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    gotoSpec(alloggio);
                }
            });
            backk.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    gotoSpec(alloggio);
                }
            });


        }
    }


    private void gotoSpec(Accommodation alloggio){
        Intent intent=new Intent(SpecAll.this, SpecAll.class);
        intent.putExtra("alloggio", alloggio);
        intent.putExtra("alloggioRicerca", alloggioRic);
        intent.putExtra("pref", pref);
        startActivity(intent);
    }
}
