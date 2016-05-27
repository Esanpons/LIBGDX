package darkchop.darganddrop;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Zan on 10/05/2016.
 */
public class SourceCarta extends Source {
    Screen screen;

    public SourceCarta(Actor actor, Screen screen) {
        super(actor);
        this.screen = screen;
    }

    @Override
    public Payload dragStart(InputEvent event, float x, float y, int pointer) {
        Payload payload = new DragAndDrop.Payload();
        payload.setObject(getActor());
        payload.setDragActor(getActor());


        return payload;
    }

    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer, Payload payload, Target target) {
        if (target == null) {
            screen.ultimaTAbla.get(0).add(getActor()).size(50);

        } else {

            if (target.getActor() == screen.scroll1) {

                screen.t1.add(getActor()).size(50);

                screen.ultimaTAbla.set(0, screen.t1);

            } else if (target.getActor() == screen.scroll2) {


                screen.t2.add(getActor()).size(50);

                screen.ultimaTAbla.set(0, screen.t2);

            }

            remove(screen.t2);
            remove(screen.t1);
        }

    }


    private void remove(Table t1) {
        Array<Actor> cells = new Array<Actor>();

        for (int i = 0; i < t1.getChildren().size; i++) {
            cells.add(t1.getChildren().get(i));
        }

        t1.clearChildren();

        for (int i = 0; i < cells.size; i++) {

            t1.add(cells.get(i)).size(50);

        }

    }
}
