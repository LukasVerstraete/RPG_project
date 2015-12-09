package com.rpgproject.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.rpgproject.model.world.CameraObject;

/**
 * Created by lukas on 8-12-2015.
 */
public class CameraController extends MoveController {

    private float zoom;

    public CameraController(CameraObject camera, float speed, float zoom)
    {
        super(camera, speed);
        this.zoom = zoom;
    }

    private CameraObject getObject()
    {
        return (CameraObject) object;
    }

    @Override
    public void update(float delta) {
        input();
        super.update(delta);
        setInBounds();
        System.out.println(getObject().getPosition());
        syncCamera();
    }

    private void setInBounds()
    {
        Rectangle bounds = getObject().getMapBounds();
        float halfWidth = bounds.getWidth() / 2;
        float halfHeight = bounds.getHeight() / 2;
        Vector2 position = getObject().getPosition();
        if(position.x - ((Gdx.graphics.getWidth() * zoom) / 2) < 0)
            position.x += ((Gdx.graphics.getWidth() * zoom) / 2) - position.x;
        if(position.x + ((Gdx.graphics.getWidth() * zoom) / 2) > bounds.getWidth())
            position.x -= (position.x + ((Gdx.graphics.getWidth() * zoom) / 2)) - bounds.getWidth();
        if(position.y - ((Gdx.graphics.getHeight() * zoom) / 2) < 0)
            position.y += ((Gdx.graphics.getHeight() * zoom) / 2) - position.y;
        if(position.y + ((Gdx.graphics.getHeight() * zoom) / 2) > bounds.getHeight())
            position.y -= (position.y + ((Gdx.graphics.getHeight() * zoom) / 2)) - bounds.getHeight();
        getObject().setPosition(position);
    }

    private void syncCamera()
    {
        getObject().getCamera().position.set(getObject().getX(), getObject().getY(), 0);
        getObject().getCamera().zoom = this.zoom;
    }

    private void input() {
        Vector2 direction = new Vector2(0, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            direction.y = 1;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            direction.y = -1;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            direction.x = -1;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            direction.x = 1;

        this.setDirection(direction);
    }
    public void setZoom(float zoom)
    {
        this.zoom = zoom;
    }
}
