package darkchop.darganddrop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;


public class MainGame extends Game {
    private AssetManager assets;
    public Array<Carta> arrayCartas;

    @Override
    public void create() {
        assets = new AssetManager();
        //cargar los atlas
        assets.load("atlas/imagenescarta.atlas", TextureAtlas.class);
        assets.load("atlas/fondosbatalla.atlas", TextureAtlas.class);
        assets.load("atlas/BotonesMapa/BotonesMapa.atlas", TextureAtlas.class);

        //cargar los skins
        assets.load("skin/uiskin.json", Skin.class);


        assets.finishLoading();

        arrayCartas=new Array<Carta>();
        Array<Sprite> arrayImagenes = getAtlasImagenesCarta().createSprites();
        for (int i = 0; i < arrayImagenes.size; i++) {
            arrayCartas.add(new Carta(this,arrayImagenes.get(i)));

        }


        setScreen(new Screen(this));
    }
    public AssetManager getAssets() {
        return assets;
    }


    public  Skin getSkin() {
        return getAssets().get("skin/uiskin.json");
    }


    public  TextureAtlas getAtlasImagenesCarta() {
        return assets.get("atlas/imagenescarta.atlas");
    }
}