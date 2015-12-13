package com.rpgproject.controller.backup;

import com.rpgproject.RPGGame;
import com.rpgproject.view.screens.MainScreen;
import com.rpgproject.view.screens.PlayScreen;

/**
 * Created by Lukas on 4-12-2015.
 */
public class MainController {

    MainScreen mainScreen;
    PlayScreen playScreen;

    private RPGGame game;

    private GameController gameController;

    public MainController(RPGGame game)
    {
        this.game = game;
        mainScreen = new MainScreen(this);
        playScreen = new PlayScreen(this);

        gameController = new GameController();
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
        gameController.updateWorld(delta);
    }

    public void drawWorld()
    {
        gameController.drawWorld(game.getSpriteBatch());
    }
}
