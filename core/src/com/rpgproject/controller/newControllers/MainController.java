package com.rpgproject.controller.newControllers;

import com.rpgproject.RPGGame;
import com.rpgproject.controller.newControllers.GameController;
import com.rpgproject.utils.ConfigLoader;
import com.rpgproject.view.screens.MainScreen;
import com.rpgproject.view.screens.PlayScreen;

/**
 * Created by Lukas on 13-12-2015.
 */
public class MainController {

    private MainScreen mainScreen;
    private PlayScreen playScreen;

    private RPGGame game;
    private float width;
    private float height;

    private GameController gameController;

    private ConfigLoader config;

    public MainController(RPGGame game, ConfigLoader config)
    {
        this.config = config;
        this.game = game;
        mainScreen = new MainScreen(this, config.getViewportWidth(), config.getViewportHeight());
        playScreen = new PlayScreen(this, config.getViewportWidth(), config.getViewportHeight());
        config.setState(this);
    }

    public void loadMainMenu()
    {
        game.setScreen(mainScreen);
    }

    public void startGame()
    {
        config.setCurrentSave("1");
        config.startGame();
        gameController = new GameController(this, config);
        game.setScreen(playScreen);
    }

    public void dispose()
    {
        config.saveGame(gameController.getWorld());
    }

    public void updateWorld(float delta)
    {
        gameController.updateWorld(delta);
    }

    public void drawWorld()
    {
        gameController.drawWorld(game.getSpriteBatch());
    }

    public void movePlayerUp(boolean move)
    {
        if(move)
            gameController.movePlayer(0, 1);
        else
            gameController.movePlayer(0, 0);
    }

    public void movePlayerDown(boolean move)
    {
        if(move)
            gameController.movePlayer(0, -1);
        else
            gameController.movePlayer(0, 0);
    }

    public void movePlayerLeft(boolean move)
    {
        if(move)
            gameController.movePlayer(-1, 0);
        else
            gameController.movePlayer(0, 0);
    }

    public void movePlayerRight(boolean move)
    {
        if(move)
            gameController.movePlayer(1, 0);
        else
            gameController.movePlayer(0, 0);
    }

    public void performAction()
    {
        gameController.performAction();
    }

    public void displayMessage(String message)
    {
        playScreen.setMessage(message);
    }

    public void hideMessage()
    {
        playScreen.hideDialog();
    }
}
