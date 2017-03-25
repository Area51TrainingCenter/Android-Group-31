package com.jcodee.mod3class1_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jcodee.mod3class1_1.rest.HelperWS;
import com.jcodee.mod3class1_1.rest.TypicodeWS;
import com.jcodee.mod3class1_1.rest.response.UserResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvUsername)
    TextView tvUsername;
    @BindView(R.id.tvAddress)
    TextView tvAddress;
    @BindView(R.id.tvWebsite)
    TextView tvWebsite;
    @BindView(R.id.tvPhone)
    TextView tvPhone;

    GoogleMap googleMapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMapp = googleMap;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        TypicodeWS typicodeWS = HelperWS.obtenerConfiguracion().create(TypicodeWS.class);
        Call<ArrayList<UserResponse>> resultado = typicodeWS.obtenerUsuarios();
        resultado.enqueue(new Callback<ArrayList<UserResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<UserResponse>> call, Response<ArrayList<UserResponse>> response) {
                ArrayList<UserResponse> datos = response.body();
                if (datos != null && !datos.isEmpty()) {
                    for (UserResponse item : datos) {
                        tvName.setText(item.getNombre());
                        tvUsername.setText(item.getUsername());
                        tvAddress.setText(item.getAddress().getCity());
                        tvPhone.setText(item.getPhone());
                        tvWebsite.setText(item.getPaginaWeb());

                        LatLng latLng = new LatLng(
                                Double.parseDouble(item.getAddress().getGeo().getLat()),
                                Double.parseDouble(item.getAddress().getGeo().getLng())
                        );

                        googleMapp.addMarker(new MarkerOptions()
                                .position(latLng)
                                .icon(BitmapDescriptorFactory.defaultMarker())
                        );
                        googleMapp.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));

                        break;
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<UserResponse>> call, Throwable t) {

            }
        });
    }

    @OnClick({R.id.tvWebsite, R.id.tvPhone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvWebsite:

                Intent intent =
                        new Intent(
                                Intent.ACTION_VIEW, Uri.parse("http://" + tvWebsite.getText().toString()));
                startActivity(intent);
                //AREA51
                //area5100

                break;
            case R.id.tvPhone:

                Intent intent1 =
                        new Intent(
                                Intent.ACTION_CALL, Uri.parse("tel:" + tvPhone.getText().toString()));
                startActivity(intent1);

                break;
        }
    }
}
