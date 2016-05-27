package darkchop.darganddrop;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;

/**
 * Created by Zan on 10/05/2016.
 */
public class TargetImg extends Target{

    public TargetImg(Actor actor1) {
        super(actor1);
    }

    @Override
    public boolean drag(Source source, Payload payload, float x, float y, int pointer) {
        return true;
    }

    @Override
    public void drop(Source source, Payload payload, float x, float y, int pointer) {


    }
}
