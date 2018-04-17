package com.example.usuari.servicios;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static ProgressBar progreso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progreso = (ProgressBar) this.findViewById(R.id.progressBar);
        progreso.setMax(100);
    }
    public void iniciar(View v){
        startService(new Intent(this,MyService.class));
    }
    public void auxiliar(View v){
        Toast.makeText(this,"La UI sigue funcionando",Toast.LENGTH_LONG).show();
    }
    public static Handler manejador=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int valor=msg.arg1;
            progreso.setProgress(valor);
        }
    };
}
