package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * TO to hold item's data
 * 
 * @author Daldegan
 * 
 */
public final class Item {

	private final class ImageClick extends ClickListener {
		private Item item;

		public ImageClick(Item item) {
			this.item = item;
		}

		public void clicked(InputEvent event, float x, float y) {
			Gdx.app.log("SELECTED ITEM", "ID: " + item.getId() + " Description: " + item.getDescription().getText());
		}
	}

	private int id;
	private Label description;
	private Image image;
	private Color color;

	public final int getId() {
		return id;
	}

	public final Label getDescription() {
		return description;
	}

	public final Image getImage() {
		return image;
	}

	public final Color getColor() {
		return color;
	}

	public Item(int index, String description, Texture texture, Color color, Skin skin) {
		this.id = index;
		this.description = new Label(description, skin);
		this.image = new Image(texture);
		this.color = color;

		image.setColor(color);

		image.addListener(new ImageClick(this));
	}
}
