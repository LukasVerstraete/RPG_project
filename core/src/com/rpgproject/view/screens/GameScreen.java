package com.rpgproject.view.screens;

import com.badlogic.gdx.Screen;
import com.rpgproject.RPGGame;

/**
 * Created by Lukas on 1-12-2015.
 */
public abstract class GameScreen implements Screen {

    protected RPGGame game;

    public GameScreen(RPGGame game)
    {
        this.game = game;
    }

    @Override
    public void show() {

    }

    public abstract void update(float delta);
    public abstract void draw();

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
