package darkchop.juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Zan on 18/05/2016.
 */
public class Human2 extends Actor {

    //animaciones
    private Animation bailaAnimation;
    private TextureRegion[] up,down,left,right;
    private Animation Aup,Adown,Aleft,Aright;
    private Vector2 velocity;



    private TextureRegion currentFrame;
    //control de tiempo
    private float stateTime;
    //bandera para cambio de estado
    private boolean baila = false;


    public Human2() {
        TextureRegion[] temp =getSprites("free.png", 3, 4);

        up = new TextureRegion[3];
        up[0]=temp[9];
        up[1]=temp[10];
        up[2]=temp[11];

        down = new TextureRegion[3];
        down[0]=temp[0];
        down[1]=temp[1];
        down[2]=temp[2];

        left = new TextureRegion[3];
        left[0]=temp[3];
        left[1]=temp[4];
        left[2]=temp[5];

        right = new TextureRegion[3];
        right[0]=temp[6];
        right[1]=temp[7];
        right[2]=temp[8];


        Aup = new Animation(0.4f, up);
        Adown = new Animation(0.4f, down);
        Aleft = new Animation(0.4f, left);
        Aright = new Animation(0.4f, right);

        stateTime = 0f;
        velocity = new Vector2(0,0);
        currentFrame = down[0];

        setPosition(400,400);
        setHeight(64);
        setWidth(64);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        velocity.x = 0;
        velocity.y = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.W) & !Gdx.input.isKeyPressed(Input.Keys.S) & !Gdx.input.isKeyPressed(Input.Keys.A) & !Gdx.input.isKeyPressed(Input.Keys.D)) velocity.y = 1;
        if(Gdx.input.isKeyPressed(Input.Keys.A) & !Gdx.input.isKeyPressed(Input.Keys.S) & !Gdx.input.isKeyPressed(Input.Keys.D) & !Gdx.input.isKeyPressed(Input.Keys.W)) velocity.x = -1;
        if(Gdx.input.isKeyPressed(Input.Keys.S) & !Gdx.input.isKeyPressed(Input.Keys.W) & !Gdx.input.isKeyPressed(Input.Keys.A) & !Gdx.input.isKeyPressed(Input.Keys.D)) velocity.y = -1;
        if(Gdx.input.isKeyPressed(Input.Keys.D) & !Gdx.input.isKeyPressed(Input.Keys.S) & !Gdx.input.isKeyPressed(Input.Keys.A) & !Gdx.input.isKeyPressed(Input.Keys.W)) velocity.x = 1;


        //Movemos nuestro Sprite
        setX(getX() + velocity.x);
        setY(getY() + velocity.y);

        //comprobamos la velocidad y gracias al método getKeyFrame de la clase Animation recuperamos el frame que necesitamos en cada momento.
        //El true representa que es un movimiento cíclico.

        if(velocity.x> 0 & velocity.y == 0)    currentFrame = Aright.getKeyFrame(stateTime,true);
        if(velocity.x< 0 & velocity.y == 0)    currentFrame = Aleft.getKeyFrame(stateTime,true);
        if(velocity.y> 0 & velocity.x == 0)    currentFrame = Aup.getKeyFrame(stateTime,true);
        if(velocity.y< 0 & velocity.x == 0)    currentFrame = Adown.getKeyFrame(stateTime,true);

        //actualizamos nuestro stateTime y dibujamos el currentFrame.
        stateTime += Gdx.graphics.getDeltaTime();

        batch.draw(currentFrame, getX(), getY(), getWidth()*2,getHeight()*2);


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
