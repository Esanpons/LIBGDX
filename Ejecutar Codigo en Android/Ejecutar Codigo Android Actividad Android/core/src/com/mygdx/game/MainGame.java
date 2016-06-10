package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kotcrab.vis.ui.VisUI;
import com.mygdx.game.aaa.Plataforma;

public class MainGame extends Game {
    SpriteBatch batch;
    Texture img;
    public Plataforma plataforma;

    public MainGame(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public void create() {
        VisUI.load();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        setScreen(new Screen(this));
    }


}
