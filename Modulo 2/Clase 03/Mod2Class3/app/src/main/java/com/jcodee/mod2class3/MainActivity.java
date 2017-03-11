package com.jcodee.mod2class3;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jcodee.mod2class3.database.SentenciaSQL;
import com.jcodee.mod2class3.entidade.DetalleTienda;
import com.jcodee.mod2class3.entidade.Tiendas;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;

public class MainActivity extends BaseActivity {

    @BindView(R.id.spTienda)
    Spinner spTienda;
    @BindView(R.id.etNombreAdministrador)
    EditText etNombreAdministrador;
    @BindView(R.id.etCapacidad)
    EditText etCapacidad;
    private RealmResults<Tiendas> listaTiendas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SentenciaSQL sentenciaSQL = new SentenciaSQL();

        listaTiendas = sentenciaSQL.obtenerTiendas();
        ArrayList<String> descripciones = new ArrayList<>();
        for (Tiendas tiendas : listaTiendas) {
            descripciones.add(tiendas.getDescripcion());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                descripciones);
        spTienda.setAdapter(arrayAdapter);
    }

    @OnClick({R.id.btnRegistrar, R.id.btnListado})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistrar:

                //Obtenemos los datos de los componentes
                String nombre = etNombreAdministrador.getText().toString();
                String cantidad = etCapacidad.getText().toString();
                String tienda = spTienda.getSelectedItem().toString();

                //Creamos una variable de tipo entero para poder obtener el id
                int codigoTienda = 0;
                //Recorremos el arraylist para poder obtener el id de la tienda
                for (Tiendas tiendas : listaTiendas) {
                    //Verificamos que el texto que obtenemos del spinner sea igual a alguno
                    //de los registros
                    if (tienda.equals(tiendas.getDescripcion())) {
                        //Seteamos el id
                        codigoTienda = tiendas.getId();
                    }
                }
                //Creamos un objeto de tipo detalleTienda
                SentenciaSQL sentenciaSQL = new SentenciaSQL();
                DetalleTienda detalleTienda = new DetalleTienda();
                detalleTienda.setId(sentenciaSQL.nextIdDetalleTienda());
                detalleTienda.setCapacidad(Integer.parseInt(cantidad));
                detalleTienda.setNombre(nombre);
                detalleTienda.setIdTienda(codigoTienda);
                //Registramos a la base de datos
                sentenciaSQL.registrarDetalleTienda(detalleTienda);
                //Mostramos un mensaje de confirmación
                Toast.makeText(this, "Se registro", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btnListado:
                break;
        }
    }
}
