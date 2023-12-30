package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.model.Accommodation;

import java.util.ArrayList;


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
        ImageView heartIcon = (ImageView) convertView.findViewById(R.id.pref);
        heartIcon.setTag(accommodation);
        if(accommodation.isFavourite())
            heartIcon.setImageResource(R.drawable.cuore_si);

        // Ottieni riferimenti agli elementi del layout dell'elemento ListView
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView locationTextView = convertView.findViewById(R.id.locationTextView);


        // Imposta i dati dell'alloggio sugli elementi del layout
        nameTextView.setText(accommodation.getName());
        locationTextView.setText(accommodation.getAddress());

        return convertView;
    }
}

