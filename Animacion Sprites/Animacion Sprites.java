
//Animacion Sprites
//http://www.jc-mouse.net/android/animacion-con-sprites-y-libgdx


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MainGame implements ApplicationListener {
    //animaciones
    private Animation bailaAnimation;
    private Animation nobailaAnimation;
    //tecturas
    private SpriteBatch spriteBatch;
    private TextureRegion currentFrame;
    //control de tiempo
    private float stateTime;
    //bandera para cambio de estado
    private boolean baila = false;

    @Override
    public void create() {
        //carga las animaciones y la duracion entra cada una de ellas
        bailaAnimation = new Animation(0.1f, getSprites("baile.jpg", 8, 8));
        nobailaAnimation = new Animation(0.2f, getSprites("nobaile.jpg", 8, 2));
        //inicia valores
        spriteBatch = new SpriteBatch();
        stateTime = 0f;
    }

    @Override
    public void dispose() { /* ... */ }

    @Override
    public void pause() { /* ... */ }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Suma el tiempo transcurrido desde el ultimo frame
        stateTime += Gdx.graphics.getDeltaTime();

        //cuando se toque la pantalla cambia el estado del personaje
        if (Gdx.input.isTouched()) {
            baila = !baila;
        }

        if (baila) {
            currentFrame = bailaAnimation.getKeyFrame(stateTime, true);
        } else {
            currentFrame = nobailaAnimation.getKeyFrame(stateTime, true);
        }
        //pinta la textura en pantalla
        spriteBatch.begin();
        spriteBatch.draw(currentFrame, 50, 50, 500, 500);
        spriteBatch.end();
    }

    @Override
    public void resize(int arg0, int arg1) { /* ... */ }

    @Override
    public void resume() { /* ... */ }

    /**
     * Carga la textura y divide la imagen segun el numero de columnas y filas para colocar
     * por frames individuales en un array
     *
     * @param file: String Nombre del archivo imagen en la carpeta ASSETS
     * @param cols: numero de columnas
     * @param rows: numero de filas
     * @return TextureRegion[]
     */
    private TextureRegion[] getSprites(String file, int cols, int rows) {
        Texture texture = new Texture(Gdx.files.internal(file));

        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth() / cols, texture.getHeight() / rows);
        TextureRegion[] Frames = new TextureRegion[cols * rows];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Frames[index++] = tmp[i][j];
            }
        }
        return Frames;

    }

}//-->fin clase


