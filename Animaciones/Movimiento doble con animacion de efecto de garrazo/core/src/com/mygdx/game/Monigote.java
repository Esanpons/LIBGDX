package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by Zan on 18/05/2016.
 */
public class Monigote extends Actor implements Disposable {


    public boolean criaturaActivada;
    boolean volver;
    boolean booleanTimer = false;
    boolean recibirGarrote = false;
    boolean colision=false;

    TextureRegion[] left, right;
    Animation Aleft, Aright,garrazoAnimacion;

    int velocidad = 100;

    TextureRegion currentFrame,currentGarrazo;

    float stateTime;
    Texture textureGarra;

    public Monigote(int cols, int rows, String URLimage) {


        TextureRegion[] temp = getSprites(URLimage, cols, rows);
        TextureRegion[] tempGarrazo = getSprites("efecto1.png", 5, 6);



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

        garrazoAnimacion=new Animation(2/10f,tempGarrazo);


        stateTime = 0f;

        volver = false;
        textureGarra =new Texture("garrazo.png");

        currentGarrazo=tempGarrazo[0];

    }


    @Override
    public void act(float delta) {
        if(recibirGarrote){
            currentGarrazo=garrazoAnimacion.getKeyFrame(stateTime,true);
            stateTime += Gdx.graphics.getDeltaTime();
        }

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(currentFrame, getX(), getY(), getWidth(), getHeight());

        if(recibirGarrote){


            batch.draw(currentGarrazo, getX()+(getWidth()/2)-64, getY() + (getHeight()/2),128,128);
        }
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

    @Override
    public void dispose() {
        textureGarra.dispose();
    }
}
