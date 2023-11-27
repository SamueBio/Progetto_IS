package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class NotificheAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Notification> notificationList;

    public NotificheAdapter(Context context, ArrayList<Notification> notificationList) {
        this.context = context;
        this.notificationList = notificationList;
    }

    @Override
    public int getCount() {
        return notificationList.size();
    }

    @Override
    public Object getItem(int position) {
        return notificationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.notifiche, parent, false);
        }

        Notification notif = notificationList.get(position);

        // Ottieni riferimenti agli elementi del layout dell'elemento ListView
        TextView nome = convertView.findViewById(R.id.nome);
        TextView mess = convertView.findViewById(R.id.mess);

        // Imposta i dati dell'alloggio sugli elementi del layout
        nome.setText(notif.getTitle());
        mess.setText(notif.getContent());

        return convertView;
    }
}

