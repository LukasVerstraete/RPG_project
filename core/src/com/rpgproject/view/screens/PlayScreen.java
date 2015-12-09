package com.rpgproject.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.rpgproject.RPGGame;
import com.rpgproject.controller.MainController;
import com.rpgproject.resources.Resources;
import com.rpgproject.view.buttons.MainMenuButton;

/**
 * Created by Lukas on 4-12-2015.
 */
public class PlayScreen extends GameScreen
{

    public PlayScreen(MainController controller)
    {
        super(controller);
    }

    @Override
    public void update(float delta) {
        controller.updateWorld(delta);
    }

    @Override
    public void draw() {
        controller.drawWorld();
    }
}
