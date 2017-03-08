package com.jcodee.mod2class1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodee.mod2class1.database.SentenciaSQL;

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

    @OnClick(R.id.btnRegistrar)
    public void onClick() {

        //Obtenemos los datos de las cajas de texto
        String textoUno = etTextoUno.getText().toString();
        String textoDos = etTextoDos.getText().toString();

        //Registramos los datos en nuestra base de datos
        SentenciaSQL sentenciaSQL = new SentenciaSQL(MainActivity.this);
        sentenciaSQL.registrar(textoUno, textoDos);

        //Mostramos un mensaje de confirmación
        Toast.makeText(this, "Se registro.", Toast.LENGTH_SHORT).show();

        //Se cambia de pantalla
        Intent intent = new Intent(MainActivity.this, ListadoActivity.class);
        startActivity(intent);

    }
}
