package com.rpgproject.controller.newControllers;

import com.badlogic.gdx.Gdx;
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

    private float elapsedTime = 0.0f;

    public WorldRenderer(World world)
    {
        renderer = new OrthogonalTiledMapRenderer(world.getCurrentMap().getMap());
    }

    public void render(SpriteBatch batch, World world, OrthographicCamera camera)
    {
        elapsedTime += Gdx.graphics.getDeltaTime();
        renderer.setView(camera);
        renderer.render(backgroundLayers);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(world.getPlayer().getAnimation().getKeyFrame(elapsedTime, true), world.getPlayer().getX(), world.getPlayer().getY());
        batch.end();
        renderer.render(foregroundLayers);
    }
}
