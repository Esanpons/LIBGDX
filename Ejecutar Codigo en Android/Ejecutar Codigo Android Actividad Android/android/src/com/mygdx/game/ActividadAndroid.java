package com.mygdx.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mygdx.game.aaa.ActivityListener;

public class ActividadAndroid extends Activity {


    String nombreBoton1, nombreBoton2, nombreBoton3;
    Button botonNew, botonContinue, botonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_android);
        Bundle extras = getIntent().getExtras();

        final ActivityListener listener =  new Datos().listener;

        nombreBoton1 = extras.getString("boton1");
        nombreBoton2 = extras.getString("boton2");
        nombreBoton3 = extras.getString("boton3");

        botonNew = (Button) findViewById(R.id.buttonNew);
        botonContinue = (Button) findViewById(R.id.buttonContinuar);
        botonSalir = (Button) findViewById(R.id.buttonSalir);

        botonNew.setText(nombreBoton1);
        botonContinue.setText(nombreBoton2);
        botonSalir.setText(nombreBoton3);

        botonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPressNuevoJuego();


            }
        });
        botonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPressContinuar();


            }
        });
        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPressSalir();
                finish();

            }
        });

    }


}
