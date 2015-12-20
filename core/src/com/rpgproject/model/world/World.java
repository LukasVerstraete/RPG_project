package com.rpgproject.model.world;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.rpgproject.resources.Resources;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lukas on 7-12-2015.
 */
public class World {

    private Player player;
    private WorldMap currentMap;
    private HashMap<String, WorldMap> maps;

    public World()
    {
        player = new Player(20, 20);
        maps = new HashMap<String, WorldMap>();
        maps.put("testMap", new WorldMap("testMap"));
        maps.put("entrance", new WorldMap("entrance"));
        setCurrentMap("testMap");
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

    public Player getPlayer()
    {
        return player;
    }

}
