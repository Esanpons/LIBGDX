package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class Main extends Game {

    /**
     * Distance between items (in pixels)
     */
    private static final float PAD = 20f;
    private static final String TEXTURE_PATH = "data/animvs-logo.png";

    private AssetManager assetManager;
    private Stage stage;

    /**
     * All items available
     */
    private ArrayMap<Integer, Item> items;

    /**
     * Just items to be displayed on the screen
     */
    private ArrayMap<Integer, Item> itemsDisplayed;

    private Skin uiSkin;
    private Table scrollTable;



    @Override
    public void create() {

        stage = new Stage(new StretchViewport(800, 480));
        items = new ArrayMap<Integer, Item>();
        itemsDisplayed = new ArrayMap<Integer, Item>();


        Gdx.input.setInputProcessor(this.stage);

        assetManager = new AssetManager();
        assetManager.load("data/animvs-logo.png", Texture.class);
        assetManager.load("data/uiskin.atlas", TextureAtlas.class);
        assetManager.finishLoading();

        uiSkin = new Skin(Gdx.files.internal("data/uiskin.json"), assetManager.get("data/uiskin.atlas", TextureAtlas.class));


        scrollTable = new Table();


        criaItens(333);


        Window window = new Window("", uiSkin);
             window.setFillParent(true);

        rearrangeTable();

        // Prepares the scroll manager:
        ScrollPane scroll = new ScrollPane(scrollTable, uiSkin);

        // Only scroll vertically:
        scroll.setScrollingDisabled(true, false);

        window.add(scroll).fill().expand();


        window.pack();
        stage.addActor(window);
    }

    @Override
    public void render() {

        stage.act();

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();

    }


    @Override
    public void dispose() {
        uiSkin.dispose();
        stage.dispose();
    }

    private final void criaItens(int total) {
        items.clear();
        itemsDisplayed.clear();

        for (int i = 0; i < total; i++) {
            Color novaCor = new Color(MathUtils.random(0.5f), MathUtils.random(0.5f), MathUtils.random(0.5f), 1f);
            items.put(i, new Item(i, "Item " + i, assetManager.get(TEXTURE_PATH, Texture.class), novaCor, uiSkin));
        }
    }

    /**
     * Recalculates the display items list (to fit the search criteria
     * specified)
     */
    private final void rearrangeTable() {

        itemsDisplayed.putAll(items);

        /**
         * The horizontal size of each image
         */
        int textureSizeX = assetManager.get(TEXTURE_PATH, Texture.class).getWidth();

        /**
         * Maximum itens to be displayed on a single line
         */
        int itemsMaxPerLine = (int) (Gdx.graphics.getWidth() / textureSizeX);
        itemsMaxPerLine -= (int) (PAD * itemsMaxPerLine / textureSizeX) + 1;

        /**
         * How many lines are needed to render all items
         */
        int linesTotal = itemsDisplayed.size / itemsMaxPerLine;

        /**
         * Items to be rendered on the last line
         */
        int furtherRecords = itemsDisplayed.size % itemsMaxPerLine;

        int itemsCount = 0;
        for (int i = 0; i < linesTotal; i++) {

			/*
             * IMPORTANT: Here we use two's whiles, this happens because it is
			 * necessary to position the labels in a row while the images are
			 * positioned on the next line. This effect "gives the felling" to
			 * the user that labels in fact image's title, although technically
			 * there is no relationship between them.
			 */

            itemsCount = 0;

            // Posiciona os Label's:
            while (itemsCount < itemsMaxPerLine) {

                // Adds the item's Label:
                addText((i * itemsMaxPerLine) + itemsCount);

                itemsCount++;
            }

            // Finishes the line, preparing the table to insert new items to the
            // next line:
            scrollTable.row();

            itemsCount = 0;

            // Places TextField's:
            while (itemsCount < itemsMaxPerLine) {

                addImage((i * itemsMaxPerLine) + itemsCount);

                itemsCount++;
            }

            // Finishes the line, preparing the table to insert new items to the
            // next line:
            scrollTable.row();
        }

        // Place last line's labels:
        for (int i = 0; i < furtherRecords; i++) {
            addText((linesTotal * itemsMaxPerLine) + i);
        }
        scrollTable.row();

        // Places last line's TextFields:
        for (int i = 0; i < furtherRecords; i++) {
            addImage((linesTotal * itemsMaxPerLine) + i);
        }
    }

    private final void addText(int indice) {
        scrollTable.add(itemsDisplayed.getValueAt(indice).getDescription()).center();
    }

    public final void addImage(int indice) {
        float imagemTamanhoX = assetManager.get(TEXTURE_PATH, Texture.class).getWidth();
        float imagemTamanhoY = assetManager.get(TEXTURE_PATH, Texture.class).getHeight();

        //@formatter:off
        scrollTable.add(itemsDisplayed.getValueAt(indice).getImage())
                .minHeight(imagemTamanhoY)    //Image's minimal vertical size (prevents the image to be distort)
                .minWidth(imagemTamanhoX)    //Image's horizontal size (prevents the image to be distort)
                .spaceBottom(PAD)            //Padding between images below this one
                .spaceLeft(PAD)                //Padding between images to the left of this one
                .spaceRight(PAD)            //Padding between images to the right if this one
                .center();                    //Centers the image on the cell
        //@formatter:on
    }

}
