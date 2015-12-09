package com.rpgproject.model.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.rpgproject.model.*;

/**
 * Created by lukas on 8-12-2015.
 */
public class CameraObject extends Entity
{

    private OrthographicCamera camera;
    private Rectangle mapBounds;

    public CameraObject()
    {
        this(0,0);
    }

    public CameraObject(float x, float y)
    {
        super(x, y);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.translate(x, y);
        mapBounds = new Rectangle();
    }

    public OrthographicCamera getCamera()
    {
        return camera;
    }

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
        return mapBounds;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        camera.update();
    }
}
