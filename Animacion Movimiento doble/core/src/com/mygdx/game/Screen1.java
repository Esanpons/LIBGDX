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

    Monigote demonio;
    Monigote ninja;
    boolean activarDemonio=false;

    @Override
    public void show() {
        super.show();
        demonio = new Monigote(400, 100,256,256,3,4,"Izquierda","demon.png");
        ninja=new Monigote(0, 100,64,64,3,4,"Derecha","Ninja.png");



        VisUI.load();
       VisTextButton tb1 = new VisTextButton("Atacar");


        tb1.setPosition(250,0);


        tb1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                demonio.criaturaActivada=true;
                ninja.criaturaActivada=true;
            }
        });


        stage.addActor(tb1);


        stage.addActor(ninja);
        stage.addActor(demonio);
    }

}
