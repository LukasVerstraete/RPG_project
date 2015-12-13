package com.rpgproject.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.rpgproject.model.world.Entity;
import com.rpgproject.model.world.Player;

/**
 * Created by Lukas on 12-12-2015.
 */
public class PlayerController extends MoveController {

    public PlayerController(Entity entity, float speed) {
        super(entity, speed);
    }

    public Player getObject()
    {
        return (Player)object;
    }

    @Override
    public void update(float delta)
    {
        input();
        super.update(delta);
        //System.out.println(getObject().getPosition());
        //System.out.println(getObject().getSprite().getX() + "  " + getObject().getSprite().getY());
        getObject().getSprite().setPosition(getObject().getX(), getObject().getY());
        //System.out.println(getObject().getSprite().getX() + "  " + getObject().getSprite().getY());
        //getObject().getSprite().setPosition(300f, 200f);
    }

    private void input() {
        Vector2 direction = new Vector2(0, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            direction.y = 1;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            direction.y = -1;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            direction.x = -1;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            direction.x = 1;

        this.setDirection(direction);
    }
}
