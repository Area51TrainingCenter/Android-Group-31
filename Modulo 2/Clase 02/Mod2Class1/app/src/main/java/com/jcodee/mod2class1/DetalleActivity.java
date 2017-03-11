package com.jcodee.mod2class1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jcodee.mod2class1.database.SentenciaSQL;
import com.jcodee.mod2class1.modelos.Datos;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetalleActivity extends AppCompatActivity {

    @BindView(R.id.tvTextoUno)
    TextView tvTextoUno;
    @BindView(R.id.tvTextoDos)
    TextView tvTextoDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SentenciaSQL sentenciaSQL = new SentenciaSQL(DetalleActivity.this);
        int id = getIntent().getIntExtra("id", -1);
        Datos datos = sentenciaSQL.obtenerDatoPorId(id);
        tvTextoUno.setText(datos.getTextoUno());
        tvTextoDos.setText(datos.getTextoDos());
    }
}
