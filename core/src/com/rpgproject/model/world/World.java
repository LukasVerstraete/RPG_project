package com.rpgproject.model.world;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.rpgproject.resources.Resources;

/**
 * Created by lukas on 7-12-2015.
 */
public class World extends GameObject {


    private TiledMap currentMap;
    private TmxMapLoader mapLoader;

    public World()
    {
        mapLoader = new TmxMapLoader();
        currentMap = mapLoader.load(Resources.getMapPath("entrance"));
    }

    public TiledMap getCurrentMap()
    {
        return currentMap;
    }
}
