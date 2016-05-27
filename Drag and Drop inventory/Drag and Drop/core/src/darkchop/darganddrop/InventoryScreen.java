package darkchop.darganddrop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import darkchop.darganddrop.inventory.InventoryActor;

public class InventoryScreen implements Screen {

    MainGame game;

    public InventoryScreen(MainGame game) {
        this.game = game;
    }

    Stage stage;
    private Viewport viewport;


    @Override
    public void show() {
        viewport = new FitViewport(800, 400);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        DragAndDrop dragAndDrop = new DragAndDrop();



        InventoryActor inventoryActor = new InventoryActor("Ventana 1",dragAndDrop, game.getSkin(),game);
        stage.addActor(inventoryActor);
        InventoryActor inventoryActor2 = new InventoryActor("Ventana 2", dragAndDrop, game.getSkin(),game);
        stage.addActor(inventoryActor2);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        stage.draw();
        stage.act(delta);

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        stage.dispose();
    }
}
