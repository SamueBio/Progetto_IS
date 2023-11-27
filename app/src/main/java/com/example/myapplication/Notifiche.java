package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.ArrayList;

public class Notifiche extends AppCompatActivity {
    private ImageButton home;
    private NotificheAdapter adapter;
    private ArrayList<Notification> allNotif;
    private ListView resultsListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        showNotification(this, "Prova", "Contenuto della notifica");
        setContentView(R.layout.notifica);

        home = (ImageButton) findViewById(R.id.house);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });
        allNotif = new ArrayList<>();
        allNotif.add(new Notification("Notifica 1", "Contenuto della notifica 1"));
        allNotif.add(new Notification("Notifica 2", "Contenuto della notifica 2"));
        allNotif.add(new Notification("Notifica 3", "Contenuto della notifica 3"));

        adapter = new NotificheAdapter(this, allNotif);

        resultsListView = findViewById(R.id.notificationListView);
        resultsListView.setAdapter(adapter);
    }

    private static final String CHANNEL_ID = "my_channel_id";
    private static final String CHANNEL_NAME = "My Channel";
    public static void showNotification(Context context, String title, String message) {
        // Create a notification manager
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Create a notification channel for Android Oreo and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        // Build the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Show the notification
        if (notificationManager != null) {
            notificationManager.notify(/*notificationId*/ 1, builder.build());
        }
    }

    public void openDashboard(){
        Intent intent=new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}
