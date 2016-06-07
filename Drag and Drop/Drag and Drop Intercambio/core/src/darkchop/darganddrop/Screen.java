package darkchop.darganddrop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;


public class Screen implements com.badlogic.gdx.Screen {

    MainGame game;
    Stage stage;

    public Screen(MainGame game) {
        this.game = game;
    }



    @Override
    public void show() {
        final Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));


        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        final actor a1=new actor(new Texture("ImagenesPJ01.png"));

        a1.setBounds(50, 125, 100, 100);
        a1.setOriginX(a1.getX());
        a1.setOriginY(a1.getY());
        stage.addActor(a1);

        final actor a2=new actor(new Texture("ImagenesPJ02.png"));
        a2.setBounds(200, 50, 100, 100);
        a2.setOriginX(a2.getX());
        a2.setOriginY(a2.getY());
        stage.addActor(a2);

        final actor a3=new actor(new Texture("ImagenesPJ03.png"));
        a3.setBounds(200, 200, 100, 100);
        a3.setOriginX(a3.getX());
        a3.setOriginY(a3.getY());
        stage.addActor(a3);

        DragAndDrop dragAndDrop = new DragAndDrop();
        dragAndDrop.addSource(new SourceActor(a1,stage));
        dragAndDrop.addSource(new SourceActor(a2,stage));
        dragAndDrop.addSource(new SourceActor(a3,stage));
        dragAndDrop.addTarget(new TargetActor(a2));
        dragAndDrop.addTarget(new TargetActor(a3));
        dragAndDrop.addTarget(new TargetActor(a1));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}