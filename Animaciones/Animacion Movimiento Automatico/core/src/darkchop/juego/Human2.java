package darkchop.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Zan on 18/05/2016.
 */
public class Human2 extends Actor {

    //animaciones
    public int x,y;
    public boolean esIzquierda;

    private TextureRegion[] up, down, left, right;
    private Animation  Aleft, Aright;



    private TextureRegion currentFrame;
    //control de tiempo
    private float stateTime;
    //bandera para cambio de estado
    private boolean baila = false;
    boolean comprobar = false;


    public Human2(int x, int y) {
        this.x = x;
        this.y = y;
        TextureRegion[] temp = getSprites("free.png", 3, 4);
        esIzquierda=true;


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


        Aleft = new Animation(2/10f, left);
        Aright = new Animation(2/10f, right);


        stateTime = 0f;
        currentFrame = left[0];


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        stateTime += Gdx.graphics.getDeltaTime();
        if(esIzquierda){
            currentFrame= Aleft.getKeyFrame(stateTime,true);
        }else {
            currentFrame= Aright.getKeyFrame(stateTime,true);
        }

        batch.draw(currentFrame, x,y);


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
