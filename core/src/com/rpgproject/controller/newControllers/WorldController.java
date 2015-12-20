package com.rpgproject.controller.newControllers;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.rpgproject.model.world.World;

/**
 * Created by Lukas on 13-12-2015.
 */
public class WorldController {

    private PlayerController playerController;
    private TriggerController triggerController;

    public WorldController(World world)
    {
        playerController = new PlayerController();
        triggerController = new TriggerController();
    }

    public void update(float delta, World world)
    {
        playerController.update(delta, world);
        triggerController.update(delta, world);
    }


}
