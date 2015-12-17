package com.rpgproject.model.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.rpgproject.resources.Resources;

/**
 * Created by Lukas on 10-12-2015.
 */
public class Player extends Entity {

    private Sprite sprite;
    private TextureAtlas textureAtlas;
    private Animation animation;

    public Player()
    {
        this(0,0);
    }

    public Player(float x, float y)
    {
        super(x, y, 26, 16, 100.0f);
        sprite = new Sprite(new Texture(Gdx.files.internal(Resources.getImagePath("character"))));
        sprite.setPosition(0, 0);
        textureAtlas = new TextureAtlas(Gdx.files.internal(Resources.getImagePath("playerAtlas")));
        animation = new Animation(1f / 2f, textureAtlas.getRegions());
        animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }

    public Sprite getSprite()
    {
        return sprite;
    }

    public Animation getAnimation()
    {
        return animation;
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(getX() + sprite.getWidth() / 2 - this.getWidth() / 2, this.getY(), getWidth(), getHeight());
    }
}
