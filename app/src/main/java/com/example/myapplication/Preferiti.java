package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.Accommodation;
import com.example.myapplication.model.Favourite;
import com.example.myapplication.retrofit.FavouritesApi;
import com.example.myapplication.retrofit.RetrofitService;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Preferiti extends AppCompatActivity {
    private ImageButton home;
    private ListView resultsListView;
    private AccomodationAdapter adapter; // Supponiamo che tu abbia un adattatore personalizzato per gli alloggi
    private ArrayList<Accommodation> allAccommodations; // La lista completa degli alloggi
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.preferiti);

        home = (ImageButton) findViewById(R.id.house);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });
        performSearch();

    }
    public void onHeartIconClick(View view) {
        RetrofitService retrofitService = new RetrofitService();
        FavouritesApi favouritesApi = retrofitService.getRetrofit().create(FavouritesApi.class);
        ImageView heartIcon = (ImageView) view;
        Accommodation accommodation = (Accommodation) heartIcon.getTag();
        Favourite favourite = new Favourite(GlobalData.getInstance().getUsername(), accommodation.getId());
        if (accommodation.isFavourite()) {

            Call<ResponseBody> call = favouritesApi.delete(favourite.generateJson());
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    heartIcon.setImageResource(R.drawable.cuore);
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        } else {

            Call<ResponseBody> call = favouritesApi.save(favourite.generateJson());
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    heartIcon.setImageResource(R.drawable.cuore_si);
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }
        accommodation.setFavourite(!accommodation.isFavourite());
    }
    public void openDashboard(){
        Intent intent=new Intent(this, Dashboard.class);
        startActivity(intent);
    }
    @SuppressLint("MissingInflatedId")
    private void performSearch() {
        allAccommodations = new ArrayList<>();
        resultsListView = findViewById(R.id.accommodationListView);

        RetrofitService retrofitService = new RetrofitService();
        FavouritesApi favouritesApi = retrofitService.getRetrofit().create(FavouritesApi.class);
        Favourite user = new Favourite(GlobalData.getInstance().getUsername(), 0);
        Call<ResponseBody> call = favouritesApi.getFavouriteAccomodationByUser(user.generateJson());

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String responseBody = response.body().string();
                    allAccommodations = (ArrayList<Accommodation>)Accommodation.parseString(responseBody);
                    adapter = new AccomodationAdapter(Preferiti.this, allAccommodations);
                    resultsListView.setAdapter(adapter);
                    resultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            // Alloggio selezionato dalla lista
                            Accommodation alloggioSelezionato = allAccommodations.get(position);
                            // Creazione di un Intent
                            Intent intent=new Intent(Preferiti.this, SpecAll.class);
                            // Passaggio dell'alloggio attraverso l'Intent
                            intent.putExtra("alloggio", alloggioSelezionato);
                            // Avvio dell'attività successiva
                            startActivity(intent);
                        }
                    });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }
}
