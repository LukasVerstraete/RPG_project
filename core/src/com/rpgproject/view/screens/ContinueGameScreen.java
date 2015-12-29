package com.rpgproject.view.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.rpgproject.RPGGame;
import com.rpgproject.controller.newControllers.MainController;
import com.rpgproject.resources.Resources;
import com.rpgproject.view.ui.MainMenuButton;

/**
 * Created by lukas on 26-12-2015.
 */
public class ContinueGameScreen extends GameScreen {

    public ContinueGameScreen(MainController controller, float width, float height) {
        super(controller, width, height);
        init();
    }

    private void init()
    {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(RPGGame.DEBUG);
        table.align(Align.center);

        Table homeButtonTable = new Table();
        homeButtonTable.setFillParent(true);
        homeButtonTable.setDebug(RPGGame.DEBUG);
        homeButtonTable.align(Align.top | Align.left);

        MainMenuButton homeButton = new MainMenuButton(Resources.getString("menu"));
        homeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.loadMainMenu();
            }
        });

        homeButtonTable.add(homeButton);

        stage.addActor(homeButtonTable);

        MainMenuButton save1Button = new MainMenuButton(Resources.getString("continueGame"));
        save1Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.startGame("1", false);
            }
        });

        MainMenuButton save2Button = new MainMenuButton(Resources.getString("continueGame"));
        save2Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.startGame("2", false);
            }
        });

        MainMenuButton save3Button = new MainMenuButton(Resources.getString("continueGame"));
        save3Button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.startGame("3", false);
            }
        });

        table.add(save1Button).fill().padBottom(30).width(250).height(50);
        table.row();
        table.add(save2Button).fill().padBottom(30).width(250).height(50);
        table.row();
        table.add(save3Button).fill().padBottom(30).width(250).height(50);
        table.row();

        stage.addActor(table);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw() {
        stage.draw();
    }
}
