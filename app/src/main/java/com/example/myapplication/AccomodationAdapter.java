package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.model.Accommodation;
import com.example.myapplication.model.Favourite;
import com.example.myapplication.retrofit.FavouritesApi;
import com.example.myapplication.retrofit.RetrofitService;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AccomodationAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Accommodation> accommodationList;

    public AccomodationAdapter(Context context, ArrayList<Accommodation> accommodationList) {
        this.context = context;
        this.accommodationList = accommodationList;
    }

    @Override
    public int getCount() {
        return accommodationList.size();
    }

    @Override
    public Object getItem(int position) {
        return accommodationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.cerca4, parent, false);
        }

        Accommodation accommodation = accommodationList.get(position);

        // Ottieni riferimenti agli elementi del layout dell'elemento ListView
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView locationTextView = convertView.findViewById(R.id.locationTextView);
        // Imposta i dati dell'alloggio sugli elementi del layout
        nameTextView.setText(accommodation.getName());
        locationTextView.setText(accommodation.getAddress());


        // Imposta l'icona del cuore in base allo stato preferito
        ImageView imageViewCuore = convertView.findViewById(R.id.pref);
        int cuoreIcon = accommodation.isFavourite() ? R.drawable.cuore_si : R.drawable.cuore;
        imageViewCuore.setImageResource(cuoreIcon);

        // GESTIONE ALLOGGIO PREFERITO CLIC ICONA DEL CUORE
        imageViewCuore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitService retrofitService = new RetrofitService();
                FavouritesApi favouritesApi = retrofitService.getRetrofit().create(FavouritesApi.class);
                Favourite favourite = new Favourite(GlobalData.getInstance().getUsername(), accommodation.getId());
                if (accommodation.isFavourite()) {
                    Call<ResponseBody> call = favouritesApi.delete(favourite.generateJson());
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            imageViewCuore.setImageResource(R.drawable.cuore);
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
                            imageViewCuore.setImageResource(R.drawable.cuore_si);
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                    });
                }
                accommodation.setFavourite(!accommodation.isFavourite());
                notifyDataSetChanged(); // Aggiorna l'intera lista
            }
        });

        return convertView;
    }
}

