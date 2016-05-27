package darkchop.juego;

/**
 * Created by Zan on 11/05/2016.
 */
public class Screen1 extends BaseScreen {
    public Screen1(MainGame game) {
        super(game);
    }

    Human2 human;

    @Override
    public void show() {
        super.show();
        human = new Human2(300, 100);

        stage.addActor(human);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if(!human.esIzquierda){
            human.x+=1;

            if(human.x==200){
                human.esIzquierda=true;
            }
        }else {
            human.x-=1;
            if(human.x==0){
                human.esIzquierda=false;
            }
        }

    }
}
