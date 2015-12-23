package com.rpgproject.model.world;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.rpgproject.model.world.actions.Action;
import com.rpgproject.resources.Resources;
import com.rpgproject.utils.ConfigLoader;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lukas on 7-12-2015.
 */
public class World {

    private Player player;
    private WorldMap currentMap;
    private HashMap<String, WorldMap> maps;
    private ArrayList<Action> actions;

    public World(ConfigLoader config)
    {
        player = new Player();
        maps = config.getMaps();
        actions = new ArrayList<Action>();
        currentMap = maps.get(config.getMap());
        player.setPosition(config.getPlayerPosition());
    }

    public WorldMap getCurrentMap()
    {
        return currentMap;
    }

    public void setCurrentMap(String map)
    {
        if(maps.get(map) != null)
            currentMap = maps.get(map);
    }

    public boolean checkCollision(Rectangle testRect)
    {
        return currentMap.checkCollision(testRect);
    }

    public void addAction(Action action)
    {
        if(action != null)
            actions.add(action);
    }

    public ArrayList<Action> getActions()
    {
        return actions;
    }

    public void clearActions()
    {
        actions.clear();
    }

    public Player getPlayer()
    {
        return player;
    }

}
