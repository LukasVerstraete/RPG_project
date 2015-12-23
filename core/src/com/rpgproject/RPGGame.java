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

    MainController controller;

    SpriteBatch batch;

    @Override
    public void create() {
        initResources();
        controller = new MainController(this, 800, 480);
        batch = new SpriteBatch();
        Gdx.gl.glClearColor(1, 1, 1, 1);
    }

    public void initResources() {
        Resources.addFile("defaultSkin", "skins/syncopate/uiskin.json");
        Resources.addFile("labelSkin", "skins/default/uiskin.json");
        Resources.addString("newGame", "New Game");
        Resources.addString("loadGame", "Load Game");
        Resources.addFile("entrance", "maps/inkomhal.tmx");
        Resources.addFile("testMap", "maps/testmap.tmx");
        Resources.addFile("character", "character_lopen_1.png");
        Resources.addFile("label9Patch", "sprites/ui/labelNinePatch.png");
        Resources.addFile("playerAtlasFront", "sprites/spritesheets/walkFront.atlas");
        Resources.addFile("playerAtlasBack", "sprites/spritesheets/walkBack.atlas");
        Resources.addFile("playerAtlasLeft", "sprites/spritesheets/walkLeft.atlas");
        Resources.addFile("playerAtlasRight", "sprites/spritesheets/walkRight.atlas");
        Resources.addFile("navigationUI", "sprites/ui/controlsPack/controls.atlas");

        Resources.addFile("walkSound", "audio/Footsteps_on_Cement-Tim_Fryer.mp3");
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
