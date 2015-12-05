package com.rpgproject.view.screens;

import com.badlogic.gdx.Gdx;
import com.rpgproject.RPGGame;

/**
 * Created by Lukas on 4-12-2015.
 */
public class PlayScreen extends GameScreen
{

    public PlayScreen(RPGGame game)
    {
        super(game);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
    }
}
