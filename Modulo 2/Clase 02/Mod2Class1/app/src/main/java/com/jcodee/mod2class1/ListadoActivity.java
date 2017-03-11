package com.jcodee.mod2class1;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.jcodee.mod2class1.adapters.DatoAdapter;
import com.jcodee.mod2class1.database.SentenciaSQL;
import com.jcodee.mod2class1.modelos.Datos;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListadoActivity extends AppCompatActivity {

    @BindView(R.id.lvLista)
    ListView lvLista;
    @BindView(R.id.svFiltrado)
    SearchView svFiltrado;

    private ArrayList<Datos> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final SentenciaSQL sentenciaSQL = new SentenciaSQL(ListadoActivity.this);
        lista = sentenciaSQL.obtener();
        final DatoAdapter datoAdapter = new DatoAdapter(ListadoActivity.this, lista);
        lvLista.setAdapter(datoAdapter);

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ListadoActivity.this);
                builder.setTitle(getResources().getString(R.string.text_titulo));//Seleccione opción
                builder.setMessage(getResources().getString(R.string.text_message));//Acción a realizar
                builder.setPositiveButton(getResources().getString(R.string.text_eliminar),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                AlertDialog.Builder builder1 = new AlertDialog.Builder(ListadoActivity.this);
                                builder1.setTitle("Eliminar");
                                builder1.setMessage("EStá seguro de eliminar?");
                                builder1.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        sentenciaSQL.eliminar(lista.get(position).getId());
                                        Toast.makeText(ListadoActivity.this, "Se elimino correctamente.",
                                                Toast.LENGTH_SHORT).show();
                                        lista = sentenciaSQL.obtener();
                                        DatoAdapter datoAdapter = new DatoAdapter(ListadoActivity.this, lista);
                                        lvLista.setAdapter(datoAdapter);
                                        //datoAdapter.notifyDataSetChanged();
                                        dialog.dismiss();
                                    }
                                });
                                builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                builder1.create().show();

                            }
                        });
                builder.setNeutralButton(getResources().getString(R.string.text_modificar),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                /*
                                Intent intent = new Intent(ListadoActivity.this, MainActivity.class);
                                intent.putExtra("id", lista.get(position).getId());
                                startActivity(intent);
                                */
                                final Dialog dialogo = new Dialog(ListadoActivity.this);
                                dialogo.setContentView(R.layout.modificar);

                                final EditText etTextoUno = (EditText) dialogo.findViewById(R.id.etTextoUno);
                                final EditText etTextoDos = (EditText) dialogo.findViewById(R.id.etTextoDos);
                                Button btnActualizar = (Button) dialogo.findViewById(R.id.btnActualizar);

                                Datos datos = lista.get(position);
                                etTextoUno.setText(datos.getTextoUno());
                                etTextoDos.setText(datos.getTextoDos());

                                btnActualizar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        sentenciaSQL.actualizar(
                                                etTextoUno.getText().toString(),
                                                etTextoDos.getText().toString(),
                                                lista.get(position).getId()
                                        );
                                        DatoAdapter datoAdapter = new DatoAdapter(ListadoActivity.this, sentenciaSQL.obtener());
                                        lvLista.setAdapter(datoAdapter);
                                        dialogo.dismiss();
                                        Toast.makeText(ListadoActivity.this, "Se actualizo", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                dialogo.show();

                            }
                        });
                builder.setNegativeButton(getResources().getString(R.string.text_ver),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent = new Intent(ListadoActivity.this, DetalleActivity.class);
                                intent.putExtra("id", lista.get(position).getId());
                                startActivity(intent);

                            }
                        });
                builder.create().show();

            }
        });

        svFiltrado.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                DatoAdapter datoAdapter = new DatoAdapter(ListadoActivity.this,
                        sentenciaSQL.filtrar(newText));
                lvLista.setAdapter(datoAdapter);

                return true;
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SentenciaSQL sentenciaSQL = new SentenciaSQL(ListadoActivity.this);
        lista = sentenciaSQL.obtener();
        DatoAdapter datoAdapter = new DatoAdapter(ListadoActivity.this, lista);
        lvLista.setAdapter(datoAdapter);
    }
}
