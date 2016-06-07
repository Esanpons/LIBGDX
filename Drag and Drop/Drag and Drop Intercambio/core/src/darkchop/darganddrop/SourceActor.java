package darkchop.darganddrop;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

/**
 * Created by Zan on 07/06/2016.
 */
public class SourceActor extends DragAndDrop.Source {

    Stage stage;

    public SourceActor(Actor actor, Stage stage) {
        super(actor);
        this.stage = stage;
    }

    public DragAndDrop.Payload dragStart(InputEvent event, float x, float y, int pointer) {
        DragAndDrop.Payload payload = new DragAndDrop.Payload();

        payload.setDragActor(getActor());


        return payload;
    }

    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer, DragAndDrop.Payload payload, DragAndDrop.Target target) {

        float xoriginal = target.getActor().getOriginX();
        float yoriginal = target.getActor().getOriginY();
        float x1=getActor().getOriginX();
        float y1=getActor().getOriginY();

        Actor actor = target.getActor();

        getActor().setPosition(xoriginal, yoriginal);

        getActor().setOriginX(xoriginal);
        getActor().setOriginY(yoriginal);

        actor.setOriginX(x1);
        actor.setOriginY(y1);

        stage.addActor(getActor());

    }
}
