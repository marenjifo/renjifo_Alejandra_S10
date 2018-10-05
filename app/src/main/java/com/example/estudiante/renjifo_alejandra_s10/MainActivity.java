package com.example.estudiante.renjifo_alejandra_s10;

import android.content.Context;
import android.graphics.Canvas;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DrawView lienzo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //HABILITAR MULTICAST
        WifiManager wm=(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiManager.MulticastLock multicastLock=wm.createMulticastLock("mydebuginfo");
        multicastLock.acquire();

        lienzo=findViewById(R.id.lienzo);
        lienzo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        break;
                        //Multiples veces
                    case MotionEvent.ACTION_MOVE:
                        lienzo.addPoint(motionEvent.getX(),motionEvent.getY());
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }

                return true;
            }
        });
    }
}
