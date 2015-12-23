package com.rpgproject.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.WorldManifold;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.utils.StringBuilder;
import com.badlogic.gdx.utils.XmlReader.Element;
import com.rpgproject.controller.newControllers.MainController;
import com.rpgproject.model.world.World;
import com.rpgproject.model.world.WorldMap;
import com.rpgproject.resources.Resources;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

/**
 * Created by lukas on 23-12-2015.
 */
public class ConfigLoader {

    private FileHandle file;
    private FileHandle currentSaveFile;

    private Element root;
    private Element currentSave;
    private String currentSaveId = "1";
    private Array<Element> saves;

    private boolean isGameActive;
    private HashMap<String, WorldMap> worldMaps;

    public ConfigLoader()
    {
        root = null;
        currentSave = null;
        worldMaps = new HashMap<String, WorldMap>();
    }

    public void loadConfig(FileHandle file)
    {
        this.file = file;
        root = Utils.parseXmlFile(file);
        initResources();
        initStrings();
        getActiveGame();
        if(currentSave != null)
            isGameActive = true;
    }

    private void initResources()
    {
        Array<Element> files = root.getChildrenByName("file");
        for(Element file : files)
            Resources.addFile(file.getAttribute("name"), file.getAttribute("path"));

        Array<Element> maps = root.getChildrenByName("map");
        for(Element map : maps)
            worldMaps.put(map.getAttribute("name"), new WorldMap(map.getAttribute("name")));

        saves = root.getChildrenByName("save");
    }

    private void initStrings()
    {
        Array<Element> strings = root.getChildrenByName("string");
        for(Element string : strings)
            Resources.addString(string.getAttribute("name"), string.getAttribute("text"));
    }

    private void getActiveGame()
    {
        Element save = root.getChildByName("state");
        if(!save.getAttribute("name").equals("menu"))
            setCurrentSave(save.getAttribute("save"));
    }

    public HashMap<String, WorldMap> getMaps()
    {
        return worldMaps;
    }

    public void setState(MainController controller)
    {
        if(isGameActive)
            controller.startGame();
        else
            controller.loadMainMenu();
    }

    public Vector2 getPlayerPosition()
    {
        if(isGameActive) {
            return new Vector2(Float.parseFloat(currentSave.getChildByName("position").getAttribute("x")), Float.parseFloat(currentSave.getChildByName("position").getAttribute("y")));
        }
        else
            return new Vector2(0,0);
    }

    private WorldMap getCurrentMap()
    {
        return worldMaps.get(currentSave.getChildByName("map").getAttribute("name"));
    }

    public String getMap()
    {
        return currentSave.getChildByName("map").getAttribute("name");
    }

    public float getViewportWidth()
    {
        return Float.parseFloat(root.getChildByName("viewport").getAttribute("width"));
    }

    public float getViewportHeight()
    {
        return Float.parseFloat(root.getChildByName("viewport").getAttribute("height"));
    }

    public void setCurrentSave(String id)
    {
        for(Element save : saves)
        {
            if(save.getAttribute("id").equals(id)) {
                currentSaveId = id;
                currentSaveFile = Gdx.files.local(save.getAttribute("path"));
                currentSave = Utils.parseXmlFile(currentSaveFile);
            }
        }
    }

    public void startGame()
    {
        isGameActive = true;
        root.getChildByName("state").setAttribute("save", currentSaveId);
        root.getChildByName("state").setAttribute("name", "game");
    }

    public void saveGame(World world)
    {
        savePlayerPosition(world);
        XmlWriter writerconfig = new XmlWriter(file.writer(false));
        XmlWriter writersave = new XmlWriter(currentSaveFile.writer(false));

        try {
            writerconfig.write(root.toString());
            writersave.write(currentSave.toString());
            writerconfig.close();
            writersave.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void savePlayerPosition(World world)
    {
        currentSave.getChildByName("map").setAttribute("name", world.getCurrentMap().getName());
        currentSave.getChildByName("position").setAttribute("x", "" + world.getPlayer().getX());
        currentSave.getChildByName("position").setAttribute("y", "" + world.getPlayer().getY());
    }
}
