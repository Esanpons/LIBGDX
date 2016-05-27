/* Copyright (c) 2014 PixelScientists
 * 
 * The MIT License (MIT)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package darkchop.darganddrop.inventory;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.Array;

import darkchop.darganddrop.MainGame;

/**
 * @author Daniel Holderbaum
 */
public class InventoryActor extends Window {


    public InventoryActor(String Titulo, DragAndDrop dragAndDrop, Skin skin, MainGame game) {
        super(Titulo, skin);

        setPosition(400, 100);
        defaults().space(8);
        row().fill().expandX();

        int i = 0;
        for (Slot slot : slotArray()) {
            SlotActor slotActor = new SlotActor(skin, slot, game);
            dragAndDrop.addSource(new SlotSource(slotActor, game));
            dragAndDrop.addTarget(new SlotTarget(slotActor));
            add(slotActor);

            i++;
            if (i % 5 == 0) {
                row();
            }
        }
        pack();


    }

    private Array<Slot> slotArray() {
        Array<Slot> slots;
        slots = new Array<Slot>(25);
        for (int i = 0; i < 25; i++) {
            slots.add(new Slot(null, 0));


        }

        int j = 0;
        for (Slot slot : slots) {

            slot.add(null, 1);

            if (j < 19) {
                slot.setItem(Item.values()[j]);
            }

            j++;
        }


        return slots;
    }

}
