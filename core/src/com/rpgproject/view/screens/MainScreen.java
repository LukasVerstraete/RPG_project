package com.rpgproject.view.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.rpgproject.RPGGame;
import com.rpgproject.utils.Utils;
import com.rpgproject.view.buttons.MainMenuButton;

/**
 * Created by Lukas on 1-12-2015.
 */
public class MainScreen extends GameScreen {
    public MainScreen(RPGGame game)
    {
        super(game);
        init();
    }
    private void init()
    {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(RPGGame.DEBUG);
        table.align(Align.center);
        MainMenuButton newGameButton = new MainMenuButton("New game");
        MainMenuButton continueGameButton = new MainMenuButton("Continue Game");
        table.add(newGameButton).fill().padBottom(30).width(250).height(50);
        table.row();
        table.add(continueGameButton).width(250).height(50);

        stage.addActor(table);
    }

    public void update(float delta)
    {

    }

    public void draw()
    {
        stage.draw();
    }
}
