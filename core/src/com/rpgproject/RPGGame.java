package com.rpgproject;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.rpgproject.controller.newControllers.MainController;
import com.rpgproject.resources.Resources;
import com.rpgproject.utils.Utils;
import com.rpgproject.view.screens.MainScreen;

public class RPGGame extends Game {

    public static final boolean DEBUG = false;

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
        Resources.addSkin("label", "default/uiskin.json");
        Resources.addString("newGame", "New Game");
        Resources.addString("loadGame", "Load Game");
        Resources.addMap("entrance", "inkomhal.tmx");
        Resources.addMap("testMap", "testmap.tmx");
        Resources.addImage("character", "character_lopen_1.png");
        Resources.addImage("label", "ui/labelNinePatch.png");
        Resources.addAtlas("playerAtlasFront", "sprites/spritesheets/walkFront.atlas");
        Resources.addAtlas("playerAtlasBack", "sprites/spritesheets/walkBack.atlas");
        Resources.addAtlas("navigationUI", "sprites/ui/controlsPack/controls.atlas");
        initStrings();
    }

    public void initStrings()
    {
        XmlReader.Element root = Utils.parseXmlFile(Gdx.files.internal("dialog/dialogMessages.xml"));
        Array<XmlReader.Element> list = root.getChildrenByName("message");
        for(int i = 0; i < list.size; i++)
        {
            XmlReader.Element e = list.get(i);
            String name = e.getAttribute("name");
            String content = e.getText();
            System.out.println(name + " " + content);
            Resources.addString(name, content);
        }
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
