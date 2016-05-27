
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ListenerDobleClick extends ClickListener {

    private static final long DOUBLE_CLICK_TIME_DELTA = 300;//milliseconds
    private long lastClickTime = 0;

    @Override
    public void clicked(InputEvent event, float x, float y) {
        long clickTime = System.currentTimeMillis();

        ////////////////////////evento doble click///////////////////////////
        if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA) {



        }else{////////////////////evento un click////////////////////////////



        }
        lastClickTime = clickTime;
    }
}
