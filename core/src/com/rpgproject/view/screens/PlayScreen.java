package com.rpgproject.view.screens;

import com.rpgproject.controller.newControllers.MainController;

/**
 * Created by Lukas on 4-12-2015.
 */
public class PlayScreen extends GameScreen
{

    public PlayScreen(MainController controller)
    {
        super(controller);
    }

    @Override
    public void update(float delta) {
        controller.updateWorld(delta);
    }

    @Override
    public void draw() {
        controller.drawWorld();
    }
}
