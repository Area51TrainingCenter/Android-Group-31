package com.jcodee.mod2class7_31;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodee.mod2class7_31.database.SentenciaSQL;
import com.jcodee.mod2class7_31.entidades.Ubicaciones;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etTitulo)
    EditText etTitulo;
    @BindView(R.id.etLatitud)
    EditText etLatitud;
    @BindView(R.id.etLongitud)
    EditText etLongitud;
    @BindView(R.id.etDireccion)
    EditText etDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnBuscar, R.id.btnRegistrar, R.id.btnVerMapa})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBuscar:
                break;
            case R.id.btnRegistrar:

                String titulo = etTitulo.getText().toString();
                String latitud = etLatitud.getText().toString();
                String longitud = etLongitud.getText().toString();
                String direccion = etDireccion.getText().toString();

                Ubicaciones ubicaciones = new Ubicaciones();
                ubicaciones.setId(SentenciaSQL.nextId());
                ubicaciones.setTitulo(titulo);
                ubicaciones.setDireccion(direccion);
                ubicaciones.setLatitud(Double.parseDouble(latitud));
                ubicaciones.setLongitud(Double.parseDouble(longitud));

                SentenciaSQL.registrar(ubicaciones);
                Toast.makeText(this, "Se registro correctamente", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btnVerMapa:

                Intent intent = new Intent(MainActivity.this, MapitaActivity.class);
                startActivity(intent);

                break;
        }
    }
}
