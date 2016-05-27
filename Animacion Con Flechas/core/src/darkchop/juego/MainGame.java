package darkchop.juego;

import com.badlogic.gdx.Game;

public class MainGame extends Game {

    @Override
    public void create() {
        setScreen(new Screen1(this));
    }
}