package com.example.estudiante.renjifo_alejandra_s10;


import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class DrawView extends View {



    ArrayList<Point> puntos;

    public DrawView(Context context) {
        super(context);

        //Comunicacion com= new Comunicacion();
        //com.start();

        puntos= new ArrayList<>();
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        puntos= new ArrayList<>();
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        puntos= new ArrayList<>();
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        puntos= new ArrayList<>();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);


        Point puntoA= new Point(400,600);
        Paint brocha= new Paint();
        brocha.setColor(Color.argb(255,255,0,0));
        brocha.setStrokeWidth(20);
        canvas.drawPoint(puntoA.x,puntoA.y,brocha);



        for(int i=0; i<puntos.size(); i++){
            canvas.drawPoint(puntos.get(i).x, puntos.get(i).y, brocha);
        }
    }

    public void addPoint(float x, float y) {
        puntos.add(new Point(     (int) x, (int) y)   );
        invalidate();
    }

    public void OnRecieved(String input){

    }

    public ArrayList<Point> getpuntos() {
        return puntos;
    }
}