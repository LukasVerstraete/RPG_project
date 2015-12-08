package com.rpgproject.model.world;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Lukas on 8-12-2015.
 */
public abstract class Entity extends GameObject {

    private Vector2 position;

    public Entity()
    {
        this(0,0);
    }

    public Entity(float x, float y)
    {
        position = new Vector2(x, y);
    }

    public Vector2 getPosition()
    {
        return position;
    }

    public float getX()
    {
        return position.x;
    }

    public float getY()
    {
        return position.y;
    }

    public void setPosition(Vector2 position)
    {
        if(position != null)
            this.position = position;
    }
}
