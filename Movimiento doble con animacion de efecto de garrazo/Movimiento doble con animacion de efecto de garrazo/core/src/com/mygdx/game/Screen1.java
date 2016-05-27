package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisTextButton;

/**
 * Created by Zan on 11/05/2016.
 */
public class Screen1 extends BaseScreen {
    public Screen1(MainGame game) {
        super(game);
    }

    MonigoteDerecha demonio;
    MonigoteIzquierda ninja;


    @Override
    public void show() {
        super.show();
       // stage.setDebugAll(true);

        demonio = new MonigoteDerecha(3, 4, "demon.png");
        demonio.setBounds(400, 100, 256, 256);
        ninja = new MonigoteIzquierda(3, 4, "Ninja.png");
        ninja.setBounds(0, 100, 64, 64);


        VisUI.load();
        VisTextButton tb1 = new VisTextButton("Atacar");


        tb1.setPosition(250, 0);


        tb1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
               demonio.criaturaActivada = true;
                ninja.criaturaActivada = true;
            }
        });


        stage.addActor(tb1);


        stage.addActor(ninja);
        stage.addActor(demonio);
    }

    @Override
    public void render(float delta) {
        super.render(delta);


        stage.act(delta);
        colisiones();
        stage.draw();
    }

    public void colisiones() {
        if (ninja.getX()+ninja.getWidth()>demonio.getX()){
           demonio.recibirGarrote=true;
            ninja.colision=true;


            ninja.recibirGarrote=true;
            demonio.colision=true;

        }else {
            demonio.recibirGarrote=false;
            ninja.recibirGarrote=false;

            ninja.colision=false;
            demonio.colision=false;

        }

    }

    @Override
    public void dispose() {
        demonio.dispose();
        ninja.dispose();
    }
}
