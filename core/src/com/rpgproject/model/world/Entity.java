package com.rpgproject.model.world;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Lukas on 8-12-2015.
 */
public abstract class Entity {

    private Vector2 position;
    private Vector2 direction;
    private Vector2 size;
    private float speed = 1.0f;

    public Entity()
    {
        this(0, 0, 0, 0, 1.0f);
    }

    public Entity(float x, float y, float width, float height, float speed)
    {
        position = new Vector2(x, y);
        direction = new Vector2(0, 0);
        size = new Vector2(width, height);
        this.speed = speed;
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

    public Vector2 getDirection()
    {
        return direction;
    }

    public void setDirection(Vector2 direction)
    {
        if(direction != null)
            this.direction = direction;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    public float getSpeed()
    {
        return speed;
    }

    public float getWidth()
    {
        return size.x;
    }

    public float getHeight()
    {
        return size.y;
    }

    public Rectangle getBoundingBox()
    {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}
