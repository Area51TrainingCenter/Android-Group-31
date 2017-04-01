package com.jcodee.mod3class4;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by johannfjs on 31/03/17.
 * Email: johann.jara@jcodee.com
 * Phone: (+51) 990870011
 */

public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addCategory(CONNECTIVITY_SERVICE);
        registerReceiver(new InternetReceiver(), intentFilter);
    }
}
