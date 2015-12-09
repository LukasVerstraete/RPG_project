package com.rpgproject.controller;

import com.badlogic.gdx.math.Rectangle;
import com.rpgproject.model.world.CameraObject;
import com.rpgproject.model.world.World;

/**
 * Created by lukas on 8-12-2015.
 */
public class GameController {

    private World world;
    private WorldRenderer worldRenderer;

    private CameraObject camera;
    private MoveController cameraMovementController;

    public GameController()
    {
        camera = new CameraObject(0, 0);
        cameraMovementController = new CameraController(camera, 40f, 0.3f);
        camera.addController(cameraMovementController);

        world = new World();
        worldRenderer = new WorldRenderer(world, camera);
        world.addController(worldRenderer);

        camera.setMapBounds(world.getCurrentMap());

        world.addChild(camera);
    }

    public void updateWorld(float delta)
    {
        world.update(delta);
    }

    public void drawWorld()
    {
        world.draw();
    }
}
