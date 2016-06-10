package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kotcrab.vis.ui.widget.VisTextButton;
import com.mygdx.game.aaa.ActivityListener;

/**
 * Created by Zan on 10/06/2016.
 */
public class Screen extends BaseScreen {

    public Screen(MainGame game) {
        super(game);

    }


    VisTextButton pregunta;

    @Override
    public void show() {
        super.show();


        final ActivityListener listener=new ActivityListener() {
            @Override
            public void onPressNuevoJuego() {
                System.out.println("nuevo juego");
            }

            @Override
            public void onPressContinuar() {
                System.out.println("continuar");
            }

            @Override
            public void onPressSalir() {
                Gdx.app.exit();

            }
        };

        pregunta = new VisTextButton("Mostrar Activity");
        pregunta.setSize(200, 200);
        Float x = 800 / 2 - pregunta.getWidth() / 2;
        Float y = 480 / 2 - pregunta.getHeight() / 2;
        pregunta.setPosition(x, y);

        pregunta.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.plataforma.mostrarActivity("Nuevo juego","Continuar","Salir",listener);
                event.cancel();
            }
        });

        stage.addActor(pregunta);


    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
    }


}
