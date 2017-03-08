package com.jcodee.mod2class1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.jcodee.mod2class1.adapters.DatoAdapter;
import com.jcodee.mod2class1.database.SentenciaSQL;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListadoActivity extends AppCompatActivity {

    @BindView(R.id.lvLista)
    ListView lvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SentenciaSQL sentenciaSQL = new SentenciaSQL(ListadoActivity.this);
        DatoAdapter datoAdapter = new DatoAdapter(ListadoActivity.this, sentenciaSQL.obtener());
        lvLista.setAdapter(datoAdapter);
    }
}
