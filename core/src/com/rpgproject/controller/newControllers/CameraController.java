package com.rpgproject.controller.newControllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.rpgproject.model.world.Player;
import com.rpgproject.model.world.World;

/**
 * Created by Lukas on 13-12-2015.
 */
public class CameraController {

    private float zoom = 1.0f;

    public CameraController(OrthographicCamera camera, float zoom, World world)
    {
        this.zoom = zoom;
        update(Gdx.graphics.getDeltaTime(), camera, world);
    }

    public void update(float delta, OrthographicCamera camera, World world)
    {
        syncCamera(camera);
        setPosition(camera, world.getPlayer().getPosition());
        setInBounds(camera, world);
        camera.update();
    }

    private void setInBounds(OrthographicCamera camera, World world)
    {
        Rectangle bounds = world.getCurrentMap().getMapBounds();
        float halfWidth = bounds.getWidth() / 2;
        float halfHeight = bounds.getHeight() / 2;
        Vector2 position = new Vector2(camera.position.x, camera.position.y);
        if(position.x - ((camera.viewportWidth * camera.zoom) / 2) < 0)
            position.x += ((camera.viewportWidth * camera.zoom) / 2) - position.x;
        if(position.x + ((camera.viewportWidth * camera.zoom) / 2) > bounds.getWidth())
            position.x -= (position.x + ((camera.viewportWidth * camera.zoom) / 2)) - bounds.getWidth();
        if(position.y - ((camera.viewportHeight * camera.zoom) / 2) < 0)
            position.y += ((camera.viewportHeight * camera.zoom) / 2) - position.y;
        if(position.y + ((camera.viewportHeight * camera.zoom) / 2) > bounds.getHeight())
            position.y -= (position.y + ((camera.viewportHeight * camera.zoom) / 2)) - bounds.getHeight();
        setPosition(camera, position);
    }

    private void setPosition(OrthographicCamera camera, Vector2 position)
    {
        camera.position.set(position.x, position.y, 0);
    }

    private void syncCamera(OrthographicCamera camera)
    {
        camera.zoom = zoom;
    }

    public void setZoom(float zoom)
    {
        this.zoom = zoom;
    }
}
