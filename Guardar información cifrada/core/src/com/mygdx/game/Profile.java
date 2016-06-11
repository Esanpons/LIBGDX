package com.mygdx.game;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

import java.util.ArrayList;

/**
 * Created by Zan on 11/06/2016.
 */
public class Profile implements Json.Serializable {
    public int level;
    public String nick;
    public ArrayList<Integer> scores;

    public Profile() {
        level = 100;
        nick = "pepito";
        scores = new ArrayList<Integer>();
        scores.add(5);

    }

	 /* Resto de funciones de la clase */

    @Override
    public void write(Json json) {
        json.writeValue("ProfileLevel", level);
        json.writeValue("ProfileNick", nick);
        json.writeArrayStart("ProfileScores");
        for (int score : scores) {
            json.writeValue(score);
        }
        json.writeArrayEnd();
    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        level = json.readValue("ProfileLevel", Integer.class, jsonData);
        nick = json.readValue("ProfileNick", String.class, jsonData);
        scores = json.readValue("ProfileScores", ArrayList.class, Integer.class, jsonData);
    }
}
