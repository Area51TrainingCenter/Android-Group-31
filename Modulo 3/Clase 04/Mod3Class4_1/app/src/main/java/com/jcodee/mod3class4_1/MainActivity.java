package com.jcodee.mod3class4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jcodee.mod3class4_1.asyntask.SumarAsyntask;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            String resultado = new SumarAsyntask(MainActivity.this, 1, 1).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
