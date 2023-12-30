package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Accommodation;
import com.example.myapplication.model.Favourite;
import com.example.myapplication.retrofit.FavouritesApi;
import com.example.myapplication.retrofit.RetrofitService;

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
    private TextView inviaRichiesta;
    private ImageView cuore;

    private Accommodation acc;

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
        inviaRichiesta = findViewById(R.id.inviaRichiesta);

        inviaRichiesta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { inviaRic(v);
            }
        });

        Intent intent = getIntent();
        acc = (Accommodation) intent.getSerializableExtra("alloggio");
        if(acc.isFavourite())
            cuore.setImageResource(R.drawable.cuore_si);
        nome.setText(acc.getName());
        indirizzo.setText(acc.getAddress()+", "+acc.getHouseNumber()+" "+acc.getCap()+" "+acc.getTown());
        telefono.setText(acc.getTelephone());
        email.setText(acc.getEmail());
        sito.setText(acc.getWebsite());
    }

    public void inviaRic(View view){
        Intent intent=new Intent(this, InviaRichiesta.class);
        intent.putExtra("alloggio", acc);
        startActivity(intent);
    }

    public void onBackImageClick(View view) {
        finish();
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

}
