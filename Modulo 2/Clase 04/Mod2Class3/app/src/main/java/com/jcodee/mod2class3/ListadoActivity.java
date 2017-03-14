package com.jcodee.mod2class3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.jcodee.mod2class3.adapters.DetalleAdapter;
import com.jcodee.mod2class3.database.SentenciaSQL;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListadoActivity extends BaseActivity {

    @BindView(R.id.lvLista)
    ListView lvLista;

    private DetalleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SentenciaSQL sentenciaSQL = new SentenciaSQL();
        adapter = new DetalleAdapter(ListadoActivity.this,
                sentenciaSQL.obtenerDetalleTiendas());
        lvLista.setAdapter(adapter);
    }
}
