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
    private ActionController actionController;

    private DialogController dialogController;

    private WorldRenderer renderer;

    public GameController(MainController controller)
    {
        this.mainController = controller;

        world = new World();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        worldController = new WorldController(world);
        cameraController = new CameraController(camera, 0.3f, world);
        actionController = new ActionController();

        dialogController = new DialogController();

        renderer = new WorldRenderer(world);
    }

    public void updateWorld(float delta)
    {
        worldController.update(delta, world);
        cameraController.update(delta, camera, world);
        dialogController.update(world);
        actionController.update(delta, world, this);
    }

    public void drawWorld(SpriteBatch batch) {
        renderer.render(batch, world, camera);
    }

    public void movePlayer(float x, float y)
    {
        hideDialog();
        world.getPlayer().setDirection(new Vector2(x, y));
    }

    public void performAction()
    {
        actionController.perform();
    }

    public void addMessage(String message)
    {
        dialogController.pushMessage(message);
    }

    public void nextMessage()
    {
        dialogController.nextMessage(world, this);
    }

    public void showDialog(String dialog)
    {
        mainController.displayMessage(dialog);
    }

    public void hideDialog()
    {
        mainController.hideMessage();
    }
}
