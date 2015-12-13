package com.rpgproject.controller.backup;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
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
    public void draw(SpriteBatch batch) {
        renderer.setView(camera.getCamera());
        renderer.render(backgroundLayers);
        batch.setProjectionMatrix(camera.getCamera().combined);
        //System.out.println(getObject().getPlayer().getSprite().getX() + "  " + getObject().getPlayer().getSprite().getY());
        System.out.println(getObject().getPlayer().getPosition());
        batch.begin();
        getObject().getPlayer().getSprite().draw(batch);
        batch.end();
        renderer.render(foregroundLayers);
    }
}
