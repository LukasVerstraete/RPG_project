package com.rpgproject.controller.newControllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.rpgproject.model.world.World;

/**
 * Created by Lukas on 13-12-2015.
 */
public class GameController {

    private MainController mainController;

    private World world;
    private OrthographicCamera camera;

    private WorldController worldController;
    private CameraController cameraController;

    private WorldRenderer renderer;

    public GameController(MainController controller)
    {
        this.mainController = controller;

        world = new World();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        worldController = new WorldController(world);
        cameraController = new CameraController(camera, 0.3f, world);

        renderer = new WorldRenderer(world);
    }

    public void updateWorld(float delta)
    {
        worldController.update(delta, world);
        cameraController.update(delta, camera, world);
    }

    public void drawWorld(SpriteBatch batch)
    {
        renderer.render(batch, world, camera);
    }

    public void movePlayer(float x, float y)
    {
        world.getPlayer().setDirection(new Vector2(x, y));
    }
}
