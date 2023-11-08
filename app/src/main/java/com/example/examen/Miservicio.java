package com.example.examen;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

public class Miservicio extends Service {

    private String cadena;
    private int posicion = 0;

    private Timer tiempo = new Timer();
    public static PrincipalActivity ACTUALIZA_TEXTO;

    public static Activity miactividad;

    public static void ACTUALIZA_ESCUCHA(PrincipalActivity miactividad){
        ACTUALIZA_TEXTO = miactividad;
    }

    private void desplazar(){
        tiempo.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //proceso para las letras
                if (posicion>cadena.length()) posicion=0;
                ACTUALIZA_TEXTO.actualizatexto(cadena.substring(0,posicion));
                posicion++;

            }
        },0,1000);
    }
    public Miservicio() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        cadena = ACTUALIZA_TEXTO.enviatexto;
        desplazar();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}