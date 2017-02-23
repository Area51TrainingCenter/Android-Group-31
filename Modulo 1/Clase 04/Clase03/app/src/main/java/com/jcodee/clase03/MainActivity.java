package com.jcodee.clase03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etRUC, etRazonSocial;
    private RadioButton rbActivo, rbInactivo;
    private CheckBox cbNotificaciones;
    private Button btnVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Si es que la vinculación se realiza en está zona
        //no se va a encontrar el diseño, por lo tanto
        //saldría un error
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vinculamos la variable con nuestro componente que se
        //encuentra en el diseño
        etRUC = (EditText) findViewById(R.id.etRUC);
        etRazonSocial = (EditText) findViewById(R.id.etRazonSocial);
        rbActivo = (RadioButton) findViewById(R.id.rbActivo);
        rbInactivo = (RadioButton) findViewById(R.id.rbInactivo);
        cbNotificaciones = (CheckBox) findViewById(R.id.cbNotificaciones);
        btnVerificar = (Button) findViewById(R.id.btnVerificar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Obtener los datos de los componentes
                String ruc = etRUC.getText().toString(),
                        razonSocial = etRazonSocial.getText().toString(),
                        estado = (
                                rbActivo.isChecked() ?
                                        rbActivo.getText().toString() :
                                        rbInactivo.getText().toString()
                        );
                /*
                String dato = "";
                if (rbActivo.isChecked()) {
                    dato = rbActivo.getText().toString();
                } else if (rbInactivo.isChecked()) {
                    dato = rbInactivo.getText().toString();
                }
                */
                boolean recibeNotificaciones = cbNotificaciones.isChecked();

                //Validaciones
                //Validamos que se haya ingresado un ruc
                if (ruc.trim().length() == 0) {
                    etRUC.setError("Ingrese un RUC");
                    return;
                } else {
                    etRUC.setError(null);
                }

                //Validamos que se haya ingresado una razón social
                if (razonSocial.trim().length() == 0) {
                    etRazonSocial.setError("Ingrese una Razón Social");
                    //Si en caso no se ingreso, no continua con las demás acciones
                    return;
                } else {
                    etRazonSocial.setError(null);
                }

                //Enviar datos al DetalleActivity
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                //Enviamos datos a través del intent
                intent.putExtra("ruc", ruc);//String
                intent.putExtra("razon_social", razonSocial);//String
                intent.putExtra("estado", estado);//String
                intent.putExtra("notificacion", recibeNotificaciones);//Boolean
                //Ejecuta la sentencia que estamos poniendo
                startActivity(intent);

                Toast.makeText(MainActivity.this,
                        "OK", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
