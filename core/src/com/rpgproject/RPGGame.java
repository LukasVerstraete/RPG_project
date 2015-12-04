package com.rpgproject;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rpgproject.view.screens.MainScreen;

public class RPGGame extends Game {

	public static final boolean DEBUG = true;

	MainScreen mainScreen;

	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create ()
	{
		mainScreen = new MainScreen(this);
		setScreen(mainScreen);
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		getScreen().render(Gdx.graphics.getDeltaTime());
		batch.end();
	}
}
