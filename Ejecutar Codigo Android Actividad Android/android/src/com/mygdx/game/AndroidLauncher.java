package com.mygdx.game;

import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.game.aaa.ActivityListener;
import com.mygdx.game.aaa.Plataforma;

public class AndroidLauncher extends AndroidApplication implements Plataforma {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        initialize(new MainGame(this), config);
    }


    @Override
    public void mostrarActivity(String nombreBoton1, String nombreBoton2, String nombreBoton3, ActivityListener listener) {
        new Datos().listener=listener;
        Intent i = new Intent(this, ActividadAndroid.class);
        i.putExtra("boton1", nombreBoton1);
        i.putExtra("boton2", nombreBoton2);
        i.putExtra("boton3", nombreBoton3);


        startActivity(i);

    }


}
