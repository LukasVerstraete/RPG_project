package com.rpgproject.model.world;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.rpgproject.model.world.triggers.Trigger;
import com.rpgproject.model.world.triggers.TriggerFactory;
import com.rpgproject.resources.Resources;
import com.rpgproject.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Lukas on 15-12-2015.
 */
public class WorldMap {

    private TiledMap map;
    private ArrayList<Rectangle> colliders;
    private ArrayList<Trigger> triggers;
    private HashMap<String, Rectangle> locations;
    private Rectangle mapBounds;
    private int[] backgroundLayers;
    private int[] dynamicLayers;
    private int[] foregroundLayers;


    public WorldMap(String map)
    {
        this.map = new TmxMapLoader().load(Resources.getMapPath(map));
        mapBounds = new Rectangle();
        colliders = new ArrayList<Rectangle>();
        triggers = new ArrayList<Trigger>();
        locations = new HashMap<String, Rectangle>();
        sortLayers();
        setMapBounds();
        populateCollisionObjects();
        populateTriggers();
        populateLocations();
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
            colliders.add(rect.getRectangle());
        }
    }

    public void populateTriggers()
    {
        TriggerFactory triggerFactory = new TriggerFactory(this);
        this.triggers = triggerFactory.getTriggers();
    }

    public void populateLocations()
    {

        MapObjects locationObjects = map.getLayers().get("locations").getObjects();
        for(MapObject object : locationObjects)
        {
            RectangleMapObject rect = (RectangleMapObject) object;
            String name = rect.getName();

            addLocation(name, rect.getRectangle());
        }
    }

    public ArrayList<Trigger> getTriggers()
    {
        return triggers;
    }

    public void addLocation(String name, Rectangle location)
    {
        if(name != null && location != null)
        {
            System.out.println(name + " " + location);
            locations.put(name, location);
        }

    }

    public Vector2 getLocation(String name)
    {
        Rectangle rect = locations.get(name);
        return new Vector2(rect.getX(), rect.getY());
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

    private void sortLayers()
    {
        ArrayList<Integer> backgroundLayers = new ArrayList<Integer>();
        ArrayList<Integer> dynamicLayers = new ArrayList<Integer>();
        ArrayList<Integer> foregroundLayers = new ArrayList<Integer>();
        int index = 0;
        MapLayers layers = map.getLayers();
        for(MapLayer layer : layers)
        {
            if(layer.getProperties().containsKey("order"))
            {
                String order = (String)(layer.getProperties().get("order"));
                if(order.equals("B"))
                {
                    backgroundLayers.add(index);
                }
                else if(order.equals("D"))
                {
                    dynamicLayers.add(index);
                }
                else if(order.equals("F")) {
                    foregroundLayers.add(index);
                }
            }
            index++;
        }
        this.backgroundLayers = Utils.toArray(backgroundLayers);
        this.dynamicLayers = Utils.toArray(dynamicLayers);
        this.foregroundLayers = Utils.toArray(foregroundLayers);
    }

    public TiledMap getMap()
    {
        return map;
    }

    public Rectangle getMapBounds()
    {
        return mapBounds;
    }

    public int[] getBackgroundLayers()
    {
        return backgroundLayers;
    }

    public int[] getDynamicLayers()
    {
        return dynamicLayers;
    }

    public int[] getForegroundLayers()
    {
        return foregroundLayers;
    }

    public int getWidth()
    {
        return map.getProperties().get("width", Integer.class);
    }

    public int getHeight()
    {
        return map.getProperties().get("height", Integer.class);
    }

    public int getTileWidth()
    {
        return map.getProperties().get("tilewidth", Integer.class);
    }

    public int getTileHeight()
    {
        return map.getProperties().get("tileheight", Integer.class);
    }
}
