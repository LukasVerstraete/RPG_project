package com.rpgproject.model;

import com.badlogic.gdx.Game;
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

    public void draw()
    {
        for(ObjectController controller : controllers)
        {
            controller.draw();
        }
        for(GameObject object : children)
        {
            object.draw();
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
