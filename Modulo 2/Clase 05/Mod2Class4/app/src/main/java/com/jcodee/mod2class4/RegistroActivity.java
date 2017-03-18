package com.jcodee.mod2class4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jcodee.mod2class4.database.SentenciaSQL;
import com.jcodee.mod2class4.entidades.DatosEntidad;

import java.io.File;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistroActivity extends AppCompatActivity {

    @BindView(R.id.etTitulo)
    EditText etTitulo;
    @BindView(R.id.tilTitulo)
    TextInputLayout tilTitulo;
    @BindView(R.id.etDescripcion)
    EditText etDescripcion;
    @BindView(R.id.tilDescripcion)
    TextInputLayout tilDescripcion;
    @BindView(R.id.etRutaImagen)
    EditText etRutaImagen;
    @BindView(R.id.tilRutaImagen)
    TextInputLayout tilRutaImagen;
    @BindView(R.id.ivImagen)
    ImageView ivImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnBuscar, R.id.btnRegistrar, R.id.btnListado})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBuscar:

                //Hacemos que cargue los archivos que tenemos en nuestro celular
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                //Filtramos los archivos para que solo muestre las imagenes
                intent.setType("image/*");
                //Ejecutamos la acción y esperamos un retorno del código 100
                startActivityForResult(intent, 100);

                break;
            case R.id.btnRegistrar:

                String titulo = etTitulo.getText().toString();
                String descripcion = etDescripcion.getText().toString();
                String rutaImagen = etRutaImagen.getText().toString();

                DatosEntidad datosEntidad = new DatosEntidad();
                datosEntidad.setId(SentenciaSQL.nextIdDatos());
                datosEntidad.setTitulo(titulo);
                datosEntidad.setDescripcion(descripcion);
                datosEntidad.setRutaImagen(rutaImagen);

                SentenciaSQL.registrarDatos(datosEntidad);
                Toast.makeText(this, "Se registro correctamente.", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btnListado:
                Intent intent1 = new Intent(RegistroActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                try {
                    InputStream inputStream =
                            getContentResolver().openInputStream(data.getData());
                    ivImagen.setImageBitmap(BitmapFactory.decodeStream(inputStream));

                    etRutaImagen.setText(data.getData().getPath());
                } catch (Exception e) {

                }
            }
        }
    }
}
