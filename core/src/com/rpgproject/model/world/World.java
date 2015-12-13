package com.rpgproject.model.world;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.rpgproject.resources.Resources;

/**
 * Created by lukas on 7-12-2015.
 */
public class World extends GameObject {


    private TiledMap currentMap;
    private TmxMapLoader mapLoader;
    private Player player;

    public World()
    {
        player = new Player();
        mapLoader = new TmxMapLoader();
        currentMap = mapLoader.load(Resources.getMapPath("entrance"));
    }

    public TiledMap getCurrentMap()
    {
        return currentMap;
    }

    public Player getPlayer()
    {
        return player;
    }

    ////////////////////////////temporary///////////////////////////
    //TODO: move to map class;

    private Rectangle mapBounds = new Rectangle();

    public void setMapBounds(TiledMap map)
    {
        if(map != null)
        {
            MapProperties properties = map.getProperties();
            int mapWidth = properties.get("width", Integer.class);
            int mapHeight = properties.get("height", Integer.class);
            int tilePixelWidth = properties.get("tilewidth", Integer.class);
            int tilePixelHeight = properties.get("tileheight", Integer.class);
            int mapPixelWidth = mapWidth * tilePixelWidth;
            int mapPixelHeight = mapHeight * tilePixelHeight;
            this.mapBounds.set(0,0,mapPixelWidth, mapPixelHeight);
        }
    }

    public Rectangle getMapBounds()
    {
        setMapBounds(currentMap);
        return mapBounds;
    }
}
