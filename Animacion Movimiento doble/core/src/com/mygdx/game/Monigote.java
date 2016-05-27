package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Zan on 18/05/2016.
 */
public class Monigote extends Actor {

    //animaciones
    public int x, y;
    public float width, height;
    public boolean criaturaActivada;
    private boolean volver;

    private TextureRegion[] left, right;
    private Animation Aleft, Aright;
    private int empieza;


    private TextureRegion currentFrame;
    //control de tiempo
    private float stateTime;
    //bandera para cambio de estado
    private boolean baila = false;
    boolean comprobar = false;
    String direccionInicial;


    public Monigote(int x, int y, float width, float height, int cols, int rows, String direccionInicial, String URLimage) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.direccionInicial=direccionInicial;

        TextureRegion[] temp = getSprites(URLimage, cols, rows);

        criaturaActivada = false;


        left = new TextureRegion[3];
        left[0] = temp[3];
        left[1] = temp[4];
        left[2] = temp[5];

        right = new TextureRegion[3];
        right[0] = temp[6];
        right[1] = temp[7];
        right[2] = temp[8];

        TextureRegion[] animacion = new TextureRegion[6];
        animacion[0] = left[0];
        animacion[1] = left[1];
        animacion[2] = left[2];
        animacion[3] = right[0];
        animacion[4] = right[1];
        animacion[5] = right[2];


        Aleft = new Animation(2 / 10f, left);
        Aright = new Animation(2 / 10f, right);


        stateTime = 0f;

        if (direccionInicial == "Izquierda") {
            volver = true;
            currentFrame = left[0];
        }else  if (direccionInicial == "Derecha") {
            volver = false;
            currentFrame = right[0];
        }


        empieza = x;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        if (criaturaActivada) {
            if (!volver) {
                x += 1;
                currentFrame = Aright.getKeyFrame(stateTime, true);
                if (direccionInicial == "Izquierda") {
                    if (x == empieza) {
                        volver = true;
                        criaturaActivada = false;
                        currentFrame = Aleft.getKeyFrame(stateTime, true);
                    }
                }else  if (direccionInicial == "Derecha") {
                    if (x == empieza+200) {
                        volver = true;

                    }

                }




            } else {
                x -= 1;
                currentFrame = Aleft.getKeyFrame(stateTime, true);
                if (direccionInicial == "Izquierda") {
                    if (x == empieza / 2) {
                        volver = false;
                    }
                }else  if (direccionInicial == "Derecha") {
                    if (x == empieza ) {
                        volver = false;
                        criaturaActivada = false;
                        currentFrame = Aright.getKeyFrame(stateTime, true);
                    }
                }



            }

            stateTime += Gdx.graphics.getDeltaTime();


        }
        batch.draw(currentFrame, x, y, width, height);

    }

    private TextureRegion[] getSprites(String file, int cols, int rows) {


        Texture texture = new Texture(Gdx.files.internal(file));

        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth() / cols, texture.getHeight() / rows);
        TextureRegion[] Frames = new TextureRegion[cols * rows];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Frames[index++] = tmp[i][j];
            }
        }
        return Frames;

    }

}
