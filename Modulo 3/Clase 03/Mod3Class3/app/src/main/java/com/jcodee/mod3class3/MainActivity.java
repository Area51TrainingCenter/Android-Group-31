package com.jcodee.mod3class3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;
import com.jcodee.mod3class3.rest.GeocoderWS;
import com.jcodee.mod3class3.rest.HelperWS;
import com.jcodee.mod3class3.rest.response.ResultResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etDireccion)
    EditText etDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnConsultar)
    public void onViewClicked() {

        GeocoderWS geocoderWS = HelperWS.getConfiguration().create(GeocoderWS.class);
        Call<ResultResponse> respuesta = geocoderWS.obtenerPosicion(etDireccion.getText().toString());
        respuesta.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                ResultResponse resultResponse = response.body();
                //Mapa
                double lat =
                        resultResponse.getResults().get(0).getGeometry().getLocation().getLat();
                double lng =
                        resultResponse.getResults().get(0).getGeometry().getLocation().getLng();
                LatLng latLng = new LatLng(lat, lng);

            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {

            }
        });

    }
}
