package com.rpgproject.controller.newControllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rpgproject.model.world.World;

/**
 * Created by Lukas on 13-12-2015.
 */
public class GameController {

    private World world;
    private WorldRenderer renderer;
    private MainController mainController;

    public GameController(MainController controller)
    {
        this.mainController = controller;
        world = new World();
    }

    public void updateWorld(float delta)
    {

    }

    public void drawWorld(SpriteBatch batch)
    {

    }
}
