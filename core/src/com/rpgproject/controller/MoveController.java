package com.rpgproject.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.rpgproject.model.world.Entity;

/**
 * Created by Lukas on 8-12-2015.
 */
public class MoveController extends ObjectController {

    protected float speed;

    protected Vector2 direction = new Vector2(0,0);

    public MoveController(Entity entity, float speed)
    {
        super(entity);
        this.speed = speed;
    }

    private Entity getObject()
    {
        return (Entity)object;
    }

    @Override
    public void update(float delta) {
        direction.nor();
        Vector2 oldPosition = getObject().getPosition();
        float distance = delta * speed;
        Vector2 copy_dir = new Vector2(direction.x, direction.y);
        getObject().setPosition(oldPosition.mulAdd(copy_dir, distance));
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

   public void setDirection(Vector2 direction)
   {
       if(direction != null)
           this.direction = direction;
   }
}
