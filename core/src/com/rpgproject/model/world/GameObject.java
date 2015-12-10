package com.rpgproject.model.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rpgproject.controller.ObjectController;

import java.util.ArrayList;

/**
 * Created by lukas on 7-12-2015.
 */
public abstract class GameObject {

    protected ArrayList<GameObject> children;
    protected ArrayList<ObjectController> controllers;

    public GameObject()
    {
        children = new ArrayList<GameObject>();
        controllers = new ArrayList<ObjectController>();
    }

    public void update(float delta)
    {
        for(ObjectController controller : controllers)
        {
            controller.update(delta);
        }
        for(GameObject object : children)
        {
            object.update(delta);
        }
    }

    public void draw(SpriteBatch batch)
    {
        for(ObjectController controller : controllers)
        {
            controller.draw(batch);
        }
        for(GameObject object : children)
        {
            object.draw(batch);
        }
    }

    public void addChild(GameObject object)
    {
        if(object != null)
            children.add(object);
    }

    public void addController(ObjectController controller)
    {
        if(controller != null)
            controllers.add(controller);
    }
}
