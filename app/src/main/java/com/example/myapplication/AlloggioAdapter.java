package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class AlloggioAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Alloggio> accommodationList;

    public AlloggioAdapter(Context context, ArrayList<Alloggio> accommodationList) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.cerca, parent, false);
        }

        Alloggio accommodation = accommodationList.get(position);

        // Ottieni riferimenti agli elementi del layout dell'elemento ListView
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView locationTextView = convertView.findViewById(R.id.locationTextView);

        // Imposta i dati dell'alloggio sugli elementi del layout
        nameTextView.setText(accommodation.getNome());
        locationTextView.setText(accommodation.getIndirizzo());

        return convertView;
    }
}


