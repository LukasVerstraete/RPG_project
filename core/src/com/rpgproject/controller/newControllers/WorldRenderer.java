package com.rpgproject.controller.newControllers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.rpgproject.model.world.World;

/**
 * Created by Lukas on 13-12-2015.
 */
public class WorldRenderer {

    private OrthogonalTiledMapRenderer renderer;
    private int[] backgroundLayers = {0, 1};
    private int[] foregroundLayers = {2};

    public WorldRenderer(World world)
    {
        renderer = new OrthogonalTiledMapRenderer(world.getCurrentMap().getMap());
    }

    public void render(SpriteBatch batch, World world, OrthographicCamera camera)
    {
        renderer.setView(camera);
        renderer.render(backgroundLayers);
        batch.setProjectionMatrix(camera.combined);
        //System.out.println(getObject().getPlayer().getSprite().getX() + "  " + getObject().getPlayer().getSprite().getY());
        //System.out.println(getObject().getPlayer().getPosition());
        batch.begin();
        world.getPlayer().getSprite().draw(batch);
        batch.end();
        renderer.render(foregroundLayers);
    }
}
