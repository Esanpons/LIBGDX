package darkchop.darganddrop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Zan on 07/06/2016.
 */
public class actor extends Actor {

    Texture texture;
   private float xOririnal;
    private   float yOririnal ;

    public actor(Texture texture) {
        this.texture = texture;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public float getOriginX() {
        return xOririnal;
    }

    @Override
    public float getOriginY() {
        return yOririnal;
    }

    @Override
    public void setOriginX(float originX) {
        xOririnal=originX;
    }

    @Override
    public void setOriginY(float originY) {
        yOririnal=originY;
    }
}
