package com.rpgproject.view.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.rpgproject.RPGGame;
import com.rpgproject.controller.newControllers.MainController;
import com.rpgproject.resources.Resources;
import com.rpgproject.view.ui.GameLabel;
import com.rpgproject.view.ui.InGameButton;
import com.rpgproject.view.skins.MovementButtonStyle;
import com.rpgproject.view.ui.MainMenuButton;

/**
 * Created by Lukas on 4-12-2015.
 */
public class PlayScreen extends GameScreen
{
    private GameLabel dialogLabel;
    private InGameButton actionButton;

    public PlayScreen(MainController controller, float width, float height)
    {
        super(controller, width, height);
        init();
    }

    public void init()
    {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(RPGGame.DEBUG);
        table.align(Align.bottom | Align.right);

        InGameButton upButton = new InGameButton(MovementButtonStyle.Direction.UP);
        InGameButton downButton = new InGameButton(MovementButtonStyle.Direction.DOWN);
        InGameButton leftButton = new InGameButton(MovementButtonStyle.Direction.LEFT);
        InGameButton rightButton = new InGameButton(MovementButtonStyle.Direction.RIGHT);
        actionButton = new InGameButton(MovementButtonStyle.Direction.ACTION);

        dialogLabel = new GameLabel("");
        dialogLabel.setWrap(true);
        dialogLabel.setDebug(RPGGame.DEBUG);
        //dialogLabel.setVisible(false);

        upButton.addListener(new ClickListener() {
//          @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                controller.movePlayerUp(true);
                super.enter(event, x, y, pointer, fromActor);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor)
            {
                controller.movePlayerUp(false);
                super.exit(event, x, y, pointer, toActor);
            }
        });

        downButton.addListener(new ClickListener() {
            @Override
            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                controller.movePlayerDown(true);
                super.enter(event, x, y, pointer, fromActor);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor)
            {
                controller.movePlayerDown(false);
                super.exit(event, x, y, pointer, toActor);
            }
        });

        leftButton.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                controller.movePlayerLeft(true);
                super.enter(event, x, y, pointer, fromActor);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                controller.movePlayerLeft(false);
                super.exit(event, x, y, pointer, toActor);
            }
        });

        rightButton.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                controller.movePlayerRight(true);
                super.enter(event, x, y, pointer, fromActor);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                controller.movePlayerRight(false);
                super.exit(event, x, y, pointer, toActor);
            }
        });

        actionButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {


                super.clicked(event, x, y);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                controller.performAction();
                super.touchUp(event, x, y, pointer, button);
            }
        });

        table.add();
        table.add(upButton).width(50).height(50);
        table.add();
        table.row();
        table.add(leftButton).width(50).height(50);
        table.add(actionButton).width(50).height(50).pad(5);
        table.add(rightButton).width(50).height(50);
        table.row();
        table.add();
        table.add(downButton).width(50).height(50);
        table.add();


        stage.addActor(table);

        Table tmp = new Table();
        tmp.align(Align.bottom | Align.left);
        tmp.add(dialogLabel).width(stage.getWidth() - 160.0f);
        stage.addActor(tmp);

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
    }

    @Override
    public void update(float delta) {
        if(controller.actionsPossible())
            actionButton.setDisabled(false);
        else
            actionButton.setDisabled(true);
        controller.updateWorld(delta);
    }

    @Override
    public void draw() {
        controller.drawWorld();
        stage.draw();
    }

    public void setMessage(String message)
    {
        dialogLabel.setText(message);
        dialogLabel.validate();
        dialogLabel.setVisible(true);
    }

    public void hideDialog()
    {
        dialogLabel.setVisible(false);
    }
}
