package com.example.myapplication.retrofit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class IpAddress extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String ipAddress = getLocalIpAddress();
    }

    @SuppressLint("DefaultLocale")
    public String getLocalIpAddress() {
        try {
            // Utilizza la classe WifiManager per ottenere l'indirizzo IPv4
            WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            int ipAddress = wifiInfo.getIpAddress();

            // Formatta l'indirizzo IPv4
            return String.format(Locale.getDefault(), "%d.%d.%d.%d",
                    (ipAddress & 0xff),
                    (ipAddress >> 8 & 0xff),
                    (ipAddress >> 16 & 0xff),
                    (ipAddress >> 24 & 0xff));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
