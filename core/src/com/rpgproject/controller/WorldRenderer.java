package com.rpgproject.controller;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.rpgproject.model.world.CameraObject;
import com.rpgproject.model.world.World;

/**
 * Created by Lukas on 8-12-2015.
 */
public class WorldRenderer extends WorldController {

    private CameraObject camera;
    private OrthogonalTiledMapRenderer renderer;
    private int[] backgroundLayers = {0};
    private int[] foregroundLayers = {1, 2};

    public WorldRenderer(World world, CameraObject camera)
    {
        super(world);
        this.camera = camera;
        this.renderer = new OrthogonalTiledMapRenderer(world.getCurrentMap());
    }

    @Override
    public void update(float delta) {
        camera.getCamera().update();
    }

    @Override
    public void draw() {
        renderer.setView(camera.getCamera());
        renderer.render(backgroundLayers);
        renderer.render(foregroundLayers);
    }
}
