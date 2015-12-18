package com.rpgproject.view.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.rpgproject.RPGGame;
import com.rpgproject.controller.newControllers.MainController;
import com.rpgproject.view.buttons.MainMenuButton;

/**
 * Created by Lukas on 4-12-2015.
 */
public class PlayScreen extends GameScreen
{

    public PlayScreen(MainController controller)
    {
        super(controller);
        init();
    }

    public void init()
    {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(RPGGame.DEBUG);
        table.align(Align.bottom | Align.right);

        MainMenuButton upButton = new MainMenuButton("U");
        MainMenuButton downButton = new MainMenuButton("D");
        MainMenuButton leftButton = new MainMenuButton("L");
        MainMenuButton rightButton = new MainMenuButton("R");

        upButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                controller.movePlayerUp(true);
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                controller.movePlayerUp(false);
                super.touchUp(event, x, y, pointer, button);
            }
        });

        downButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                controller.movePlayerDown(true);
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                controller.movePlayerDown(false);
                super.touchUp(event, x, y, pointer, button);
            }
        });

        leftButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                controller.movePlayerLeft(true);
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                controller.movePlayerLeft(false);
                super.touchUp(event, x, y, pointer, button);
            }
        });

        rightButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                controller.movePlayerRight(true);
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                controller.movePlayerRight(false);
                super.touchUp(event, x, y, pointer, button);
            }
        });

        table.add();
        table.add(upButton).width(50).height(50);
        table.add();
        table.row();
        table.add(leftButton).width(50).height(50);
        table.add();
        table.add(rightButton).width(50).height(50);
        table.row();
        table.add();
        table.add(downButton).width(50).height(50);
        table.add();

        stage.addActor(table);
    }

    @Override
    public void update(float delta) {
        controller.updateWorld(delta);
    }

    @Override
    public void draw() {
        controller.drawWorld();
        stage.draw();
    }
}
