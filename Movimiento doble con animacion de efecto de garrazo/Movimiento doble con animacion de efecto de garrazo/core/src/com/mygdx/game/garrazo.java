package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Zan on 18/05/2016.
 */
public class garrazo {
    ShapeRenderer shapeRenderer;
    public garrazo() {

        shapeRenderer = new ShapeRenderer();
    }

    public void zarpa(final float x, final float y){




                int posicion = 0;
                for (int i = 0; i < 10; i++) {
                    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                    shapeRenderer.line(x + posicion, y, x + 30 + posicion - i, y + 30);
                    shapeRenderer.end();
                }
                posicion = 20;
                for (int i = 0; i < 10; i++) {
                    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                    shapeRenderer.line(x + posicion, y, x + 30 - i + posicion, y + 30);
                    shapeRenderer.end();
                }
                posicion = 40;
                for (int i = 0; i < 10; i++) {
                    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                    shapeRenderer.line(x + posicion, y, x + 30 - i + posicion, y + 30);
                    shapeRenderer.end();
                }
            }




}
