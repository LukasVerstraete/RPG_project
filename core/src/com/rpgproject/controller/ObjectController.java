package com.rpgproject.controller;

import com.badlogic.gdx.Game;
import com.rpgproject.model.GameObject;

/**
 * Created by lukas on 7-12-2015.
 */
public abstract class ObjectController {

    protected GameObject object;

    public ObjectController(GameObject object)
    {
        this.object = object;
    }

    public abstract void update(float delta);
    public abstract void draw();
}
