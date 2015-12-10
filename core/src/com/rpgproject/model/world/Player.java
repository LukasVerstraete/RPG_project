package com.rpgproject.model.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rpgproject.resources.Resources;

/**
 * Created by Lukas on 10-12-2015.
 */
public class Player extends Entity {

    private Sprite sprite;

    public Player()
    {
        sprite = new Sprite(new Texture(Gdx.files.internal(Resources.getImagePath("character"))));
        sprite.setPosition(0,0);
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    public Sprite getSprite()
    {
        return sprite;
    }
}
