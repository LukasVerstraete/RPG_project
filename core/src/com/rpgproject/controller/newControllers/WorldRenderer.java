package com.rpgproject.controller.newControllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.rpgproject.model.world.World;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Lukas on 13-12-2015.
 */
public class WorldRenderer {

    private OrthogonalTiledMapRenderer renderer;
    private ArrayList<Iterator<TiledMapTile>> iterators;

    private float elapsedTime = 0.0f;

    public WorldRenderer(World world)
    {
        renderer = new OrthogonalTiledMapRenderer(world.getCurrentMap().getMap());
    }

    public void render(SpriteBatch batch, World world, OrthographicCamera camera)
    {
        elapsedTime += Gdx.graphics.getDeltaTime();
        renderer.setMap(world.getCurrentMap().getMap());
        renderer.setView(camera);
        renderer.render((world.getCurrentMap().getBackgroundLayers()));
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        renderDynamicBackground(batch, world);
        batch.draw(world.getPlayer().getAnimation().getKeyFrame(elapsedTime, true), world.getPlayer().getX(), world.getPlayer().getY());
        renderDynamicForeground(batch, world);
        batch.end();
        renderer.render(world.getCurrentMap().getForegroundLayers());
    }

    private void renderDynamicForeground(SpriteBatch batch, World world)
    {
        int end = (int)world.getPlayer().getY() / world.getCurrentMap().getTileHeight();
        for(int i = 0; i < world.getCurrentMap().getDynamicLayers().length; i++)
        {
            TiledMapTileLayer layer = (TiledMapTileLayer)world.getCurrentMap().getMap().getLayers().get(world.getCurrentMap().getDynamicLayers()[i]);
            for(int y = 0; y <= end; y++)
            {
                for(int x = 0; x < world.getCurrentMap().getWidth(); x++)
                {
                    TiledMapTileLayer.Cell cell = layer.getCell(x,y);
                    if(cell != null)
                        batch.draw(cell.getTile().getTextureRegion(), x * layer.getTileWidth(), y * layer.getTileHeight());
                }
            }
        }
    }

    private void renderDynamicBackground(SpriteBatch batch, World world)
    {
        int start = (int)world.getPlayer().getY() / world.getCurrentMap().getTileHeight();
        for(int i = 0; i < world.getCurrentMap().getDynamicLayers().length; i++)
        {
            TiledMapTileLayer layer = (TiledMapTileLayer)world.getCurrentMap().getMap().getLayers().get(world.getCurrentMap().getDynamicLayers()[i]);
            for(int y = start + 1; y < world.getCurrentMap().getHeight(); y++)
            {
                for(int x = 0; x < world.getCurrentMap().getWidth(); x++)
                {
                    TiledMapTileLayer.Cell cell = layer.getCell(x,y);
                    if(cell != null)
                        batch.draw(cell.getTile().getTextureRegion(), x * layer.getTileWidth(), y * layer.getTileHeight());
                }
            }
        }
    }
}
