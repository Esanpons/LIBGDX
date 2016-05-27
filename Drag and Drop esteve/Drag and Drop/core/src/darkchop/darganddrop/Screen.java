package darkchop.darganddrop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;


public class Screen implements com.badlogic.gdx.Screen {

    MainGame game;
    Stage stage;
    Table t1, t2;
    Array<Table> ultimaTAbla;

    Array<Image> array1, array2;
    ScrollPane scroll1,scroll2;

    public Screen(MainGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage(new StretchViewport(800, 480));
        Gdx.input.setInputProcessor(stage);


         scroll1=new ScrollPane(null);
         scroll2=new ScrollPane(null);

        t1 = new Table();
        t2 = new Table();
        t1.setBackground(backgroundColor(Color.FOREST));
        t2.setBackground(backgroundColor(Color.BROWN));

        Table t0 = new Table();
        t0.setBackground(backgroundColor(Color.RED));


        ultimaTAbla = new Array<Table>();

        ultimaTAbla.add(new Table());

        DragAndDrop dragAndDrop = new DragAndDrop();


        for (int i = 0; i < game.arrayCartas.size; i++) {
            final Carta carta = game.arrayCartas.get(i);

            dragAndDrop.addSource(new SourceCarta(carta, this));
            dragAndDrop.addTarget(new TargetImg(scroll1));
            dragAndDrop.addTarget(new TargetImg(scroll2));


            t0.add(carta);
            t0.row();


        }


        scroll1.setWidget(t1);
        scroll2.setWidget(t2);

        Table t3 = new Table();
        t3.setSize(800 , 480);
        t3.setPosition(10, 0);
        t3.add(t0).height(480).width(100);
        t3.add(scroll1).height(480).width(350);
        t3.add(scroll2).height(480).width(350);

        array1 = new Array<Image>();
        array2 = new Array<Image>();

        array1.add(null);
        array2.add(null);


        stage.addActor(t3);


    }

    public TextureRegionDrawable backgroundColor(Color color) {

        //Creamos un fondo gris semitransparente para meter un color hacer new Color(1,1,1,1)
        Pixmap pm1 = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pm1.setColor(color);
        pm1.fill();


        return new TextureRegionDrawable(new TextureRegion(new Texture(pm1)));
    }

    public BitmapFont bitmapFontComicSanz() {
        return new BitmapFont(Gdx.files.internal("font/comicsanz.fnt"), false);
    }

    public TextButton.TextButtonStyle textButtonStyleBonitos(float scale, Color color) {
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        TextureAtlas buttonsAtlas = new TextureAtlas("skin/buttonSkin/button.pack");
        Skin buttonSkin = new Skin();
        buttonSkin.addRegions(buttonsAtlas);
        style.up = buttonSkin.getDrawable("buttonOff");
        style.down = buttonSkin.getDrawable("buttonOn");

        BitmapFont fuente = bitmapFontComicSanz();
        fuente.getData().setScale(scale);
        style.font = fuente;
        style.fontColor = color;


        return style;
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