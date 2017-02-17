package pe.area51.clase01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class InicioActivity extends AppCompatActivity {

    /*
    onCreate -> se carga el diseño
    onStart -> carga la apicación
    onResume -> podemos visualizar la pantalla
    onPause -> pausamos la actividad
    onStop -> detiene la actividad
    onDestroy -> destruye lña actividad del historico de pantallas
    onRestart -> volver a cargar datos de la actividad
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Log.d("TAG","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("TAG","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("TAG","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG","onRestart");
    }
}
