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
        this(0,0);
    }

    public Player(float x, float y)
    {
        super(x, y, 32, 32, 100.0f);
        sprite = new Sprite(new Texture(Gdx.files.internal(Resources.getImagePath("character"))));
        sprite.setPosition(0, 0);
    }

    public Sprite getSprite()
    {
        return sprite;
    }
}
