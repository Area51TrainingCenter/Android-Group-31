package com.jcodee.clase02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nombre, apellido;
    private Button ejecutar;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vincular las variables con el diseño o con el componente
        nombre = (EditText) findViewById(R.id.etNombre);
        apellido = (EditText) findViewById(R.id.etApellido);
        ejecutar = (Button) findViewById(R.id.btnEjecutar);
        resultado = (TextView) findViewById(R.id.tvResultado);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ejecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Se pone todo lo que se realizara al momento de
                //selecccionar la acción
                String valorNombre = nombre.getText().toString(),
                        valorApellido = apellido.getText().toString();

                //Validamos que los datos esten con información
                if (valorNombre.trim().length() > 0 &&
                        valorApellido.trim().length() > 0) {

                    //Setteamos el componente de resultado para mostrar
                    //el valor del nombre con el apellido
                    resultado.setText(
                            Html.fromHtml(
                                    "<b>" + valorNombre + "</b> " + valorApellido
                            )
                    );

                } else {
                    //En caso no se haya ingresado, se mostrará un mensaje
                    Toast.makeText(MainActivity.this,
                            "Debe de ingresar un nombre y/o apellido",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
