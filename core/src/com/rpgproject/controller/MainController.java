package com.rpgproject.controller;

import com.rpgproject.RPGGame;
import com.rpgproject.model.world.World;
import com.rpgproject.view.screens.MainScreen;
import com.rpgproject.view.screens.PlayScreen;

/**
 * Created by Lukas on 4-12-2015.
 */
public class MainController {

    MainScreen mainScreen;
    PlayScreen playScreen;

    private RPGGame game;
    private World world;

    public MainController(RPGGame game)
    {
        this.game = game;
        mainScreen = new MainScreen(this.game);
        playScreen = new PlayScreen(this.game);
        loadMainMenu();
    }

    public void loadMainMenu()
    {
        game.setScreen(mainScreen);
    }

    public void startGame()
    {
        game.setScreen(playScreen);
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
