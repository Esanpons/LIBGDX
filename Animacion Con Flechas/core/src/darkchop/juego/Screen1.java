package darkchop.juego;

import com.badlogic.gdx.Gdx;

/**
 * Created by Zan on 11/05/2016.
 */
public class Screen1 extends BaseScreen {
    public Screen1(MainGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        stage.addActor(new Human2());
        Gdx.input.setInputProcessor(stage);
    }


}
