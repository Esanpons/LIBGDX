package darkchop.darganddrop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MainGame extends Game {
    public AssetManager assets;

    @Override
    public void create() {
        assets = new AssetManager();
        assets.load("skins/uiskin.json", Skin.class);
        assets.load("icons/icons.atlas", TextureAtlas.class);
        assets.finishLoading();


        setScreen(new InventoryScreen(this));
    }

    public Skin getSkin() {

        return assets.get("skins/uiskin.json");
    }

    public TextureAtlas textureAtlasIcons() {
        return assets.get("icons/icons.atlas");
    }
}
