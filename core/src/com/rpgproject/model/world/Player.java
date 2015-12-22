package com.rpgproject.model.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.rpgproject.resources.Resources;

/**
 * Created by Lukas on 10-12-2015.
 */
public class Player extends Entity {

    private Animator animator;

    public Player()
    {
        this(0, 0);
    }

    public Player(float x, float y)
    {
        super(x, y, 26, 16, 100.0f);
        TextureAtlas textureAtlasFront = new TextureAtlas(Resources.getFile("playerAtlasFront"));
        TextureAtlas textureAtlasBack = new TextureAtlas(Resources.getFile("playerAtlasBack"));
        TextureAtlas textureAtlasLeft = new TextureAtlas(Resources.getFile("playerAtlasLeft"));
        TextureAtlas textureAtlasRight = new TextureAtlas(Resources.getFile("playerAtlasRight"));
        float updateSpeed = 1f / 5f;
        Animation animationFront = new Animation(updateSpeed, textureAtlasFront.getRegions());
        Animation animationBack = new Animation(updateSpeed, textureAtlasBack.getRegions());
        Animation animationLeft = new Animation(updateSpeed, textureAtlasLeft.getRegions());
        Animation animationRight = new Animation(updateSpeed, textureAtlasRight.getRegions());
        animationFront.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        animationBack.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        animationLeft.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        animationRight.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        animator = new Animator();
        animator.addAnimation(1, animationFront);
        animator.addAnimation(3, animationBack);
        animator.addAnimation(2, animationLeft);
        animator.addAnimation(4, animationRight);
        animator.setDirection(1);
        animator.setState(Animator.State.IDLE);
    }

    public TextureRegion getRegion(float delta)
    {
        return animator.getRegion(delta);
    }

    public void setDirection(int direction)
    {
        animator.setDirection(direction);
    }

    public void setState(Animator.State state){
        animator.setState(state);
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(getX() + (getRegion(0).getRegionWidth() - getWidth())/2, this.getY(), getWidth(), getHeight());
    }
}
