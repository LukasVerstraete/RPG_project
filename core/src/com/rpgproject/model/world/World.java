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

/**
 * Created by lukas on 7-12-2015.
 */
public class World {


    private TiledMap currentMap;
    private TmxMapLoader mapLoader;
    private Player player;
    private ArrayList<Rectangle> colliders;

    public World()
    {
        player = new Player(20, 20);
        mapLoader = new TmxMapLoader();
        currentMap = mapLoader.load(Resources.getMapPath("entrance"));
        colliders = new ArrayList<Rectangle>();
        populateCollisionObjects();
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

    private void populateCollisionObjects()
    {
        MapObjects collisionObjects = currentMap.getLayers().get("collision").getObjects();
        for(MapObject object : collisionObjects)
        {
            RectangleMapObject rect = (RectangleMapObject) object;
            System.out.println(rect.getRectangle().x + " " + rect.getRectangle().y);
            colliders.add(rect.getRectangle());
        }
    }

    public boolean checkCollision(Rectangle testRect)
    {
        if(getMapBounds().contains(testRect))
        {
            for(Rectangle rect : colliders)
            {
                if(rect.overlaps(testRect))
                {
                    return true;
                }
            }
        }
        else
            return true;


        return false;
    }

    public Rectangle getMapBounds()
    {
        setMapBounds(currentMap);
        return mapBounds;
    }
    ////////////////////////////////////////////////////////////////
}
