package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Zan on 19/05/2016.
 */
public class garrazoActor extends Actor {

    Texture texture;
    public garrazoActor() {
        texture=new Texture("garrazo.png");

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture,getX(),getY());
    }

}
