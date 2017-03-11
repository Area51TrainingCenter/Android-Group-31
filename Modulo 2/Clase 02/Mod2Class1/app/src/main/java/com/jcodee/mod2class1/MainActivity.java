package com.jcodee.mod2class1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodee.mod2class1.database.SentenciaSQL;
import com.jcodee.mod2class1.modelos.Datos;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etTextoUno)
    EditText etTextoUno;
    @BindView(R.id.etTextoDos)
    EditText etTextoDos;
    @BindView(R.id.btnRegistrar)
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        int id = getIntent().getIntExtra("id", -1);
        if (id > -1) {
            SentenciaSQL sentenciaSQL = new SentenciaSQL(MainActivity.this);
            Datos datos = sentenciaSQL.obtenerDatoPorId(id);
            etTextoUno.setText(datos.getTextoUno());
            etTextoDos.setText(datos.getTextoDos());
        }
    }

    @OnClick(R.id.btnRegistrar)
    public void onClick() {

        int id = getIntent().getIntExtra("id", -1);
        SentenciaSQL sentenciaSQL = new SentenciaSQL(MainActivity.this);

        if (id > -1) {

            sentenciaSQL.actualizar(
                    etTextoUno.getText().toString(),
                    etTextoDos.getText().toString(),
                    id
            );
            Toast.makeText(this, "Se actualizo correctamente", Toast.LENGTH_SHORT).show();
            finish();

        } else {
            //Obtenemos los datos de las cajas de texto
            String textoUno = etTextoUno.getText().toString();
            String textoDos = etTextoDos.getText().toString();

            //Registramos los datos en nuestra base de datos
            sentenciaSQL.registrar(textoUno, textoDos);

            //Mostramos un mensaje de confirmación
            Toast.makeText(this, "Se registro.", Toast.LENGTH_SHORT).show();

            //Se cambia de pantalla
            Intent intent = new Intent(MainActivity.this, ListadoActivity.class);
            startActivity(intent);
        }

    }
}
