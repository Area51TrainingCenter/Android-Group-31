package com.jcodee.mod3class4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by johannfjs on 31/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class InternetReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null) {
                boolean resultado = networkInfo.isConnected() && networkInfo.isAvailable()
                        && networkInfo.isConnectedOrConnecting();
                Toast.makeText(context, "R conexion estado->" + resultado, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "R conexion estado->false", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "R conexion estado->false", Toast.LENGTH_SHORT).show();
        }
    }
}
