package com.jcodee.mod2class7_31;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.jcodee.mod2class7_31.database.SentenciaSQL;
import com.jcodee.mod2class7_31.entidades.Ubicaciones;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapitaActivity extends AppCompatActivity {
    public GoogleMap googleMapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapita);
        ButterKnife.bind(this);

        MapFragment mapFragment =
                (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final GoogleMap googleMap) {
                googleMapp = googleMap;


                googleMap.getUiSettings().setMyLocationButtonEnabled(true);
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.setMyLocationEnabled(true);

                //GPSTracker
                googleMap.setOnMyLocationButtonClickListener(
                        new GoogleMap.OnMyLocationButtonClickListener() {
                    @Override
                    public boolean onMyLocationButtonClick() {

                        Location location = googleMap.getMyLocation();
                        location.getLatitude();
                        location.getLongitude();


                        return true;
                    }
                });

                ArrayList<LatLng> listaPuntos = new ArrayList<LatLng>();
                for (Ubicaciones item : SentenciaSQL.obtenerUbicaciones()) {
                    googleMap.addMarker(
                            new MarkerOptions()
                                    .title(item.getTitulo())
                                    .snippet(item.getDireccion())
                                    .position(new LatLng(item.getLatitud(), item.getLongitud()))
                                    .icon(BitmapDescriptorFactory.defaultMarker())
                    );
                    listaPuntos.add(new LatLng(item.getLatitud(), item.getLongitud()));
                }

                googleMap.addPolyline(new PolylineOptions().addAll(listaPuntos));

/*
                googleMap.addMarker(
                        new MarkerOptions()
                                .title("Titulo")
                                .snippet("Descripción")
                                .position(new LatLng(-12.1021498, -77.0276599))
                                .icon(BitmapDescriptorFactory.defaultMarker())
                );*/
                googleMap.moveCamera(
                        CameraUpdateFactory.newLatLngZoom(
                                new LatLng(-12.1021498, -77.0276599), 10));

            }
        });
    }

    @OnClick({R.id.btnMapa1, R.id.btnMapa2, R.id.btnMapa3, R.id.btnMapa4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMapa1:

                googleMapp.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                break;
            case R.id.btnMapa2:

                googleMapp.setMapType(GoogleMap.MAP_TYPE_HYBRID);

                break;
            case R.id.btnMapa3:

                googleMapp.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

                break;
            case R.id.btnMapa4:

                googleMapp.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

                break;
        }
    }
}
