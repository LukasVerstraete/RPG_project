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
 * Created by Lukas on 15-12-2015.
 */
public class WorldMap {

    private TiledMap map;
    private ArrayList<Rectangle> colliders;
    private Rectangle mapBounds;


    public WorldMap(String map)
    {
        this.map = new TmxMapLoader().load(Resources.getMapPath(map));
        mapBounds = new Rectangle();
        colliders = new ArrayList<Rectangle>();
        setMapBounds();
        populateCollisionObjects();
    }

    public void setMapBounds()
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
        MapObjects collisionObjects = map.getLayers().get("collision").getObjects();
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

    public TiledMap getMap()
    {
        return map;
    }

    public Rectangle getMapBounds()
    {
        return mapBounds;
    }
}
