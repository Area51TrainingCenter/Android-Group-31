package com.jcodee.mod3class4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnStart, R.id.btnStop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnStart:

                Intent intent = new Intent(MainActivity.this, InternetService.class);
                startService(intent);

                break;
            case R.id.btnStop:

                Intent intent1 = new Intent(MainActivity.this, InternetService.class);
                stopService(intent1);

                break;
        }
    }
}
