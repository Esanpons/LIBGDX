package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Zan on 19/05/2016.
 */
public class MonigoteIzquierda extends Monigote {


    public MonigoteIzquierda(int cols, int rows, String URLimage) {
        super(cols, rows, URLimage);

        currentFrame = right[0];




    }

    @Override
    public void act(float delta) {
        super.act(delta);



        if (criaturaActivada) {

            if (!volver) {

                setX(getX() + velocidad * delta);
                currentFrame = Aright.getKeyFrame(stateTime, true);

                if (colision) {
                    volver = true;


                }
            } else {
                if (!booleanTimer) {
                    Timer.schedule(new Timer.Task() {

                        @Override
                        public void run() {

                            booleanTimer = true;
                        }

                    }, 0.5f);

                } else {
                    setX(getX() - velocidad * delta);
                    currentFrame = Aleft.getKeyFrame(stateTime, true);

                    if (getX() < 0) {
                        volver = false;
                        criaturaActivada = false;
                        currentFrame = Aright.getKeyFrame(stateTime, true);
                        booleanTimer=false;
                    }
                }


            }
            stateTime += Gdx.graphics.getDeltaTime();
        }


    }

}
