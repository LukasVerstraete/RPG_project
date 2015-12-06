package com.rpgproject.controller;

import com.badlogic.gdx.Gdx;
import com.rpgproject.RPGGame;
import com.rpgproject.model.GameWorld;
import com.rpgproject.view.screens.MainScreen;
import com.rpgproject.view.screens.PlayScreen;

/**
 * Created by Lukas on 4-12-2015.
 */
public class MainController {

    MainScreen mainScreen;
    PlayScreen playScreen;

    private RPGGame game;
    private GameWorld world;

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


}
