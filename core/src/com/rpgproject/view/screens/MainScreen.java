package com.rpgproject.view.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.rpgproject.RPGGame;
import com.rpgproject.controller.newControllers.MainController;
import com.rpgproject.resources.Resources;
import com.rpgproject.view.buttons.MainMenuButton;

/**
 * Created by Lukas on 1-12-2015.
 */
public class MainScreen extends GameScreen {
    public MainScreen(MainController controller)
    {
        super(controller);
        init();
    }
    private void init()
    {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(RPGGame.DEBUG);
        table.align(Align.center);

        MainMenuButton newGameButton = new MainMenuButton(Resources.getString("newGame"));
        newGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.startGame();
            }
        });

        MainMenuButton continueGameButton = new MainMenuButton(Resources.getString("loadGame"));

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
