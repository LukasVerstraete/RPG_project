package com.rpgproject.model.world;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import java.util.HashMap;

/**
 * Created by lukas on 22-12-2015.
 */
public class Animator {

    private HashMap<Integer, Animation> animations;
    public enum State{
        IDLE, RUNNING
    }

    private State state;
    private int direction;

    public Animator()
    {
        animations = new HashMap<Integer, Animation>();
    }

    public void addAnimation(int direction, Animation animation)
    {
        if(animation != null)
            animations.put(direction, animation);
    }

    public TextureRegion getRegion(float delta)
    {
        if(state.equals(State.IDLE))
            return animations.get(direction).getKeyFrames()[1];
        else
            return animations.get(direction).getKeyFrame(delta, true);
    }

    public void setState(State state)
    {
        if(state != null)
            this.state = state;
    }

    public void setDirection(int direction)
    {
        if(animations.get(direction) != null)
            this.direction = direction;
    }
}
