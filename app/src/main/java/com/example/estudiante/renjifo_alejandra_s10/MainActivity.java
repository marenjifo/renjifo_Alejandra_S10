package com.example.estudiante.renjifo_alejandra_s10;


import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Comunicacion.OnMessage {

    DrawView lienzo;
    Comunicacion com;
    int x,y;
    String envio;
    String[] posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        posicion=new String[2];

        com =new Comunicacion();
        com.setObserver(this);
        com.start();

        //HABILITAR MULTICAST
        WifiManager wm= (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiManager.MulticastLock multicastLock=wm.createMulticastLock( "mydebuginfo");
        multicastLock.acquire();


        lienzo = findViewById(R.id.lienzo);



        lienzo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {



                switch (motionEvent.getAction()){

                    //PRESSED
                    case MotionEvent.ACTION_DOWN:

                        break;

                    //CLICK
                    case MotionEvent.ACTION_MOVE:
                        break;

                        //RELEASED
                    case MotionEvent.ACTION_UP:



                        com.enviarDatos(motionEvent.getX()+";"+motionEvent.getY());


                        break;
                }

                return true;
            }
        });

    }


    @Override
    public void onReceived(String msg) {

        posicion= msg.split(";");

        x= Integer.parseInt(posicion[0]);

        y= Integer.parseInt(posicion[1]);

        lienzo.addPoint(x, y);


    }
}