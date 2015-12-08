package com.rpgproject.controller;

import com.rpgproject.model.world.World;

/**
 * Created by Lukas on 8-12-2015.
 */
public class WorldController extends ObjectController {

    public WorldController(World world)
    {
        super(world);
    }

    public World getObject()
    {
        return (World) object;
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw() {

    }
}
