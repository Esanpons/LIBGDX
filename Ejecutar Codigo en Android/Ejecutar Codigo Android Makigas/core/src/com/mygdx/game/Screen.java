package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kotcrab.vis.ui.widget.VisTextButton;

/**
 * Created by Zan on 10/06/2016.
 */
public class Screen extends BaseScreen {

    public Screen(MainGame game) {
        super(game);

    }


    VisTextButton pregunta;

    @Override
    public void show() {
        super.show();


        final DialogListener listener = new DialogListener() {
            @Override
            public void onPressYes() {
                pregunta.setText("ha dicho que Si");
            }

            @Override
            public void onPressNo() {
                pregunta.setText("ha dicho que No");
            }
        };


        pregunta = new VisTextButton("Pulsa para preguntar");
        pregunta.setSize(200, 200);
        Float x = 800 / 2 - pregunta.getWidth() / 2;
        Float y = 480 / 2 - pregunta.getHeight() / 2;
        pregunta.setPosition(x, y);

        pregunta.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.plataforma.mostrarPregunta(listener);
                event.cancel();
            }
        });

        stage.addActor(pregunta);


    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
    }


}
