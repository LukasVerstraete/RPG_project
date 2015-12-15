package com.rpgproject;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rpgproject.controller.newControllers.MainController;
import com.rpgproject.resources.Resources;
import com.rpgproject.view.screens.MainScreen;

public class RPGGame extends Game {

    public static final boolean DEBUG = true;

    MainScreen mainScreen;
    MainController controller;

    SpriteBatch batch;
    Texture img;

    Sprite sprite;

    @Override
    public void create() {
        initResources();
        controller = new MainController(this);
        batch = new SpriteBatch();
        Gdx.gl.glClearColor(1, 1, 1, 1);

        sprite = new Sprite(new Texture(Gdx.files.internal(Resources.getImagePath("character"))));
        sprite.setPosition(200, 200);
    }

    public void initResources() {
        Resources.addSkin("default", "syncopate/uiskin.json");
        Resources.addString("newGame", "New Game");
        Resources.addString("loadGame", "Load Game");
        Resources.addMap("entrance", "inkomhal.tmx");
        Resources.addMap("testMap", "testmap.tmx");
        Resources.addImage("character", "character_lopen_1.png");
    }

    @Override
    public void render() {
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        getScreen().render(Gdx.graphics.getDeltaTime());
    }

    public SpriteBatch getSpriteBatch()
    {
        return batch;
    }

	public void startGame()
	{
		controller.startGame();
	}

	public void loadMainMenu()
	{
		controller.loadMainMenu();
	}
}
