package com.rpgproject;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.rpgproject.controller.newControllers.MainController;
import com.rpgproject.resources.Resources;
import com.rpgproject.utils.ConfigLoader;
import com.rpgproject.utils.Utils;
import com.rpgproject.view.screens.MainScreen;

public class RPGGame extends Game {

    public static final boolean DEBUG = false;

    MainController controller;

    SpriteBatch batch;

    @Override
    public void create() {
        checkFiles();
        initStrings();
        ConfigLoader config = new ConfigLoader();
        config.loadConfig(Gdx.files.local("saves/default-config.xml"));
        controller = new MainController(this, config);

        batch = new SpriteBatch();
    }

    @Override
    public void pause()
    {
        controller.pause();
        super.pause();
    }

    @Override
    public void dispose()
    {
        controller.dispose();
    }

//    public void initResources() {
//        Resources.addFile("defaultSkin", "skins/syncopate/uiskin.json");
//        Resources.addFile("labelSkin", "skins/default/uiskin.json");
//        Resources.addString("newGame", "New Game");
//        Resources.addString("loadGame", "Load Game");
//        Resources.addFile("entrance", "maps/inkomhal.tmx");
//        Resources.addFile("testMap", "maps/testmap.tmx");
//        Resources.addFile("character", "character_lopen_1.png");
//        Resources.addFile("label9Patch", "sprites/ui/labelNinePatch.png");
//        Resources.addFile("playerAtlasFront", "sprites/spritesheets/walkFront.atlas");
//        Resources.addFile("playerAtlasBack", "sprites/spritesheets/walkBack.atlas");
//        Resources.addFile("playerAtlasLeft", "sprites/spritesheets/walkLeft.atlas");
//        Resources.addFile("playerAtlasRight", "sprites/spritesheets/walkRight.atlas");
//        Resources.addFile("navigationUI", "sprites/ui/controlsPack/controls.atlas");
//
//        Resources.addFile("walkSound", "audio/Footsteps_on_Cement-Tim_Fryer.mp3");
//        initStrings();
//    }

    public void initStrings()
    {
        XmlReader.Element root = Utils.parseXmlFile(Gdx.files.internal("dialog/dialogMessages.xml"));
        Array<XmlReader.Element> list = root.getChildrenByName("message");
        for(int i = 0; i < list.size; i++)
        {
            XmlReader.Element e = list.get(i);
            String name = e.getAttribute("name");
            String content = e.getText();
            Resources.addString(name, content);
        }
    }

    private void checkFiles()
    {
        FileHandle file = Gdx.files.local("/saves/default-config.xml");
        //System.out.println(file.exists());
        if(file.exists())
            return;
        FileHandle configFile = Gdx.files.internal("saves/default-config.xml");
        FileHandle save0 = Gdx.files.internal("saves/defaultSave.xml");
        FileHandle save1 = Gdx.files.internal("saves/save1.xml");
        FileHandle save2 = Gdx.files.internal("saves/save2.xml");
        FileHandle save3 = Gdx.files.internal("saves/save3.xml");
        file = Gdx.files.local("saves");
        file.mkdirs();
        configFile.copyTo(file);
        save0.copyTo(file);
        save1.copyTo(file);
        save2.copyTo(file);
        save3.copyTo(file);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        getScreen().render(Gdx.graphics.getDeltaTime());
    }

    public SpriteBatch getSpriteBatch()
    {
        return batch;
    }

}
