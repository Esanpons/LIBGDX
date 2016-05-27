package darkchop.darganddrop;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;

/**
 * Created by Zan on 10/05/2016.
 */
public class Carta extends WidgetGroup {
    Image image;
    public int cell=0;
    public Carta(MainGame game,Sprite sprite) {

         image = new Image(sprite);

        image.setSize(50,50);
        Label titulo=new Label("Titulo",game.getSkin());



        addActor(image);
        addActor(titulo);
    }

    public Image getImage() {

        return image;
    }
}
