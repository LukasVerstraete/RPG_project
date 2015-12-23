package com.rpgproject.controller.newControllers;

import com.rpgproject.RPGGame;
import com.rpgproject.controller.newControllers.GameController;
import com.rpgproject.view.screens.MainScreen;
import com.rpgproject.view.screens.PlayScreen;

/**
 * Created by Lukas on 13-12-2015.
 */
public class MainController {

    MainScreen mainScreen;
    PlayScreen playScreen;

    private RPGGame game;

    private GameController gameController;

    public MainController(RPGGame game, float width, float height)
    {
        this.game = game;
        mainScreen = new MainScreen(this, width, height);
        playScreen = new PlayScreen(this, width, height);

        gameController = new GameController(this, width, height);
        //loadMainMenu();
        startGame();
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
