package darkchop.darganddrop;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

/**
 * Created by Zan on 07/06/2016.
 */
public class TargetActor extends DragAndDrop.Target {

Actor actor;
    public TargetActor(Actor actor) {
        super(actor);
        this.actor=actor;
    }

    public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {

        return true;
    }


    public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {

        float x1=payload.getDragActor().getOriginX();

        float y1=payload.getDragActor().getOriginY();



        getActor().setPosition(x1, y1);


    }
}
